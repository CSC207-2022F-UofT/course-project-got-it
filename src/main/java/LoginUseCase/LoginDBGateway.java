package LoginUseCase;

public interface LoginDBGateway {
    boolean validateAndLogin(String email, String password);

}
