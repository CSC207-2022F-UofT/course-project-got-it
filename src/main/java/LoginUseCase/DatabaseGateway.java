package LoginUseCase;

public interface DatabaseGateway {
    boolean validateAndLogin(String email, String password);

}
