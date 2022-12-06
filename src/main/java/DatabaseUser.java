import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import MakeRequestUseCase.RequestRequest;
import DatabaseGateway.DatabaseGateway;
import RegisterUseCase.RegisterDBRequest;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class DatabaseUser implements DatabaseGateway {
    private final ConnectionString mongoURI;
    private HashMap<String, Object> loggedInUser;

    private MongoCollection<Document> usersCollection;
    private MongoCollection<Document> requestsCollection;

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
    }

    @Override
    public boolean validateAndLogin(String email, String password) {
        Bson filter = Filters.and(Filters.eq("email", email),Filters.eq("password", password));
        try{
            if(this.usersCollection.countDocuments(filter) == 1){
                this.loggedInUser = new HashMap<>();
                Document userQuery = this.usersCollection.find(filter).first();
                Set<String> keys = Objects.requireNonNull(userQuery).keySet();
                System.out.println("\n\n\n\n");
                for(String key: keys){
                    System.out.println(key);
                    System.out.println(userQuery.get(key));
                    this.loggedInUser.put(key, userQuery.get(key));
                }
                System.out.println("\n\n\n\n");
                return true;
            };
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

    public boolean storeRequestInfo(RequestRequest requestRequest) {
        Document newRequest = new Document();
        newRequest.append("requester", requestRequest.getRequester());
        newRequest.append("description", requestRequest.getDescription());
        newRequest.append("deliveryAddress", requestRequest.getReq_loc());
        newRequest.append("itemAddress", requestRequest.getItem_loc());
        newRequest.append("deliveryNotes", requestRequest.getDeliveryNotes());
        try{
            this.requestsCollection.insertOne(newRequest);
            return true;
        }catch(MongoException me){
            System.err.println("An error occurred: " + me);
        }
        return false;
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
        newUser.append("address", request.getAddress());

        try{
            this.usersCollection.insertOne(newUser);
        }catch (MongoException error){
            System.out.println("error");
        }
    }
}
