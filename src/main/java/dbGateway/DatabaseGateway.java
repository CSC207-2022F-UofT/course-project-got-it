package dbGateway;

import MakeRequestUseCase.RequestRequest;

public interface DatabaseGateway {
    boolean validateAndLogin(String email, String password);

    void storeRequestInfo(RequestRequest requestRequest);

}
