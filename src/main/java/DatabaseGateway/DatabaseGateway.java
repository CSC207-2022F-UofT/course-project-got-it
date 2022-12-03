package DatabaseGateway;

import MakeRequestUseCase.RequestRequest;
import RegisterUseCase.RegisterDBRequest;

import java.util.HashMap;

public interface DatabaseGateway {
    boolean validateAndLogin(String email, String password);

    boolean exists(String email);
    void save(RegisterDBRequest request);

    boolean storeRequestInfo(RequestRequest requestRequest);

    HashMap<String, Object> getLoggedInUser();
}
