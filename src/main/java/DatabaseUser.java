import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import MakeRequestUseCase.RequestRequest;
import com.mongodb.*;
import com.mongodb.client.*;
import dbGateway.DatabaseGateway;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

public class DatabaseUser implements DatabaseGateway {
    private final ConnectionString mongoURI;

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
        System.out.println("test");
        Bson filter = Filters.and(Filters.eq("email", email),Filters.eq("password", password));
        try{
            if(this.usersCollection.countDocuments(filter) == 1){
                System.out.println("test123");
                return true;
            };
        } catch (MongoException me) {
            System.err.println("An error occurred: " + me);
        }
        return false;
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
}
