package DatabaseGateway;

import RegisterUseCase.RegisterDBRequest;

public interface DatabaseGateway {
    boolean validateAndLogin(String email, String password);

    boolean exists(String email);
    void save(RegisterDBRequest request);
}
