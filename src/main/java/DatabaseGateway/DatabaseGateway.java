package DatabaseGateway;

import MakeRequestUseCase.RequestRequest;
import RegisterUseCase.RegisterDBRequest;
import entities.Request;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for database to prevent strong coupling between the database and interior components
 * Holds all functions that are required by components
 */
public interface DatabaseGateway {
    boolean validateAndLogin(String email, String password);

    boolean exists(String email);
    void save(RegisterDBRequest request);

    String storeRequestInfo(Request requestRequest);

    boolean assignClosestDriver(String requestID);

    HashMap<String, Object> getLoggedInUser();

    boolean updateUser(User user);

    void completeRequest(String requestId);

    double[] getDriverLocation(String requestId);

    ArrayList<Request> getRequests(User user);

    ArrayList<Request> getPassedRequests(User user);
    
    String getDriverName(String requestId);

}
