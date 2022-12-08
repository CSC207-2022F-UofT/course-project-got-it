import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import DatabaseGateway.DatabaseGateway;
import RegisterUseCase.RegisterDBRequest;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entities.Request;
import entities.User;
import geocode.geocodeDistanceHelper;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.time.LocalTime;
import java.util.*;
import java.util.logging.Filter;

public class DatabaseUser implements DatabaseGateway {
    private final ConnectionString mongoURI;
    private HashMap<String, Object> loggedInUser;

    private MongoCollection<Document> usersCollection;
    private MongoCollection<Document> requestsCollection;
    private MongoCollection<Document> driversCollection;

    public DatabaseUser(String uri){
        this.mongoURI = new ConnectionString(uri);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings settings =
                MongoClientSettings.builder()
                        .applyConnectionString(mongoURI)
                        .codecRegistry(codecRegistry)
                        .serverApi(ServerApi.builder()
                                .version(ServerApiVersion.V1).build())
                        .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase mainDB = mongoClient.getDatabase("main");
        this.usersCollection = mainDB.getCollection("users");
        this.requestsCollection = mainDB.getCollection("requests");
        this.driversCollection = mainDB.getCollection("drivers");
    }

    @Override
    public boolean validateAndLogin(String email, String password) {
        Bson filter = Filters.and(Filters.eq("email", email),Filters.eq("password", password));
        try{
            if(this.usersCollection.countDocuments(filter) == 1){
                this.loggedInUser = new HashMap<>();
                Document userQuery = this.usersCollection.find(filter).first();
                Set<String> keys = Objects.requireNonNull(userQuery).keySet();
                for(String key: keys){
                    this.loggedInUser.put(key, userQuery.get(key));
                }
                return true;
            }
        } catch (MongoException error) {
            System.err.println("An error occurred: " + error);
        }
        return false;
    }
    @Override
    public HashMap<String, Object> getLoggedInUser(){
        return this.loggedInUser;
    }

    @Override
    public String storeRequestInfo(Request request) {
        Document newRequest = new Document();
        newRequest.append("requester", request.getRequester().getUid());
        newRequest.append("description", request.getitemDescription());
        newRequest.append("deliveryAddress", Arrays.asList(request.getDeliveryAddress()[0], request.getDeliveryAddress()[1]));
        newRequest.append("itemAddress", Arrays.asList(request.getItemAddress()[0], request.getItemAddress()[1]));
        newRequest.append("deliveryNotes", request.getDeliveryNotes());
        newRequest.append("startTime", request.getStartTime());
        newRequest.append("completed", false);
        try{
            this.requestsCollection.insertOne(newRequest);
            System.out.println("\n\n\n\n\n");
            System.out.println(newRequest.get("_id").toString());
            System.out.println("\n\n\n\n\n");
            return newRequest.get("_id").toString();
        }catch(MongoException me){
            System.err.println("An error occurred: " + me);
        }
        return "save_failed";
    }

    @Override
    public void completeRequest(String requestID) {
        Bson filter = Filters.in("_id", new ObjectId(requestID));
        Bson update = Updates.set("completed", true);
        this.requestsCollection.updateOne(filter, update);
    }

    @Override
    public double[] getDriverLocation(String requestID) {
        System.out.println(requestID);
        Bson filter = Filters.in("_id", new ObjectId(requestID));
        Document request = this.requestsCollection.find(filter).first();
        assert request != null;
        String driverId = (String) request.get("driver");
        Bson driverFilter = Filters.in("_id", new ObjectId(driverId));
        Document driver = this.driversCollection.find(driverFilter).first();
        assert driver != null;
        return new double[]{(double) driver.get("latitude"), (double) driver.get("longitude")};
    }

    @Override
    public ArrayList<Request> getRequests(User user) {
        Bson filter = Filters.and(Filters.eq("completed", false), Filters.eq("requester", user.getUid()));
        FindIterable<Document> requests = this.requestsCollection.find(filter);
        ArrayList<Request> allValidRequests = new ArrayList<>();
        for(Document request : requests){
            ArrayList<Double> itemAddress = (ArrayList<Double>) request.get("itemAddress");
            double[] itemAddressArray = {itemAddress.get(0), itemAddress.get(1)};
            ArrayList<Double> deliveryAddress = (ArrayList<Double>) request.get("deliveryAddress");
            double[] deliveryAddressArray = {deliveryAddress.get(0), deliveryAddress.get(1)};
            Request newRequest = new Request((String) request.get("name"), (String) request.get("description"),
                    itemAddressArray, deliveryAddressArray, (String) request.get("deliveryNotes"), user);
            newRequest.setRequestId((request.get("_id").toString()));
            newRequest.setStartTime(request.get("startTime").toString());
            allValidRequests.add(newRequest);
        }
        return allValidRequests;
    }

    @Override
    public boolean assignClosestDriver(String requestID) {
        Bson requestFilter = Filters.in("_id", new ObjectId(requestID));
        Document request = this.requestsCollection.find(requestFilter).first();
        HashMap<Double, Document> distanceDriverMap = new HashMap<>();
        double smallestDistance = Double.POSITIVE_INFINITY;
        try{
            FindIterable<Document> drivers = this.driversCollection.find();
            for(Document driver : drivers){
                if(driver.get("available", Boolean.class)){
                    double[] driverCoords = {(double)driver.get("longitude"), (double)driver.get("latitude")};
                    assert request != null;
                    ArrayList addressCoords = request.get("itemAddress", ArrayList.class);
                    geocodeDistanceHelper helper = new geocodeDistanceHelper();
                    double distance = helper.getDistance(driverCoords[0], driverCoords[1], (double) addressCoords.get(0),
                            (double) addressCoords.get(1));
                    if(distance < smallestDistance){
                        smallestDistance = distance;
                    }
                    distanceDriverMap.put(distance, driver);
                }
            }
            Bson requestUpdate = Updates.set("driver", distanceDriverMap.get(smallestDistance).get("_id").toString());
            Bson driverUpdate = Updates.set("available", false);
            Bson driverFilter = Filters.in("_id", distanceDriverMap.get(smallestDistance).get("_id"));
            this.requestsCollection.updateOne(requestFilter, requestUpdate);
            this.driversCollection.updateOne(driverFilter, driverUpdate);
            return true;
        }catch(MongoException error){
            System.out.println(error);
            return false;
        }
    }

    public boolean exists(String email) {
        Bson filter = Filters.and(Filters.eq("email", email));
        try{
            if(this.usersCollection.countDocuments(filter) == 1){
                return true;
            };
        } catch (MongoException error){
            System.err.println("An error occurred" + error);
        }
        return false;
    }

    @Override
    public void save(RegisterDBRequest request) {
        Document newUser = new Document();
        newUser.append("name", request.getName());
        newUser.append("email", request.getEmail());
        newUser.append("password", request.getPassword());
        newUser.append("longitude", request.getLongitude());
        newUser.append("latitude", request.getLatitude());
        try{
            this.usersCollection.insertOne(newUser);
        }catch (MongoException error){
            System.out.println("error");
        }
    }

}