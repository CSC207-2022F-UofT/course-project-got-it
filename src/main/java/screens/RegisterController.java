package screens;
import RegisterUseCase.RegisterInputBoundary;
import RegisterUseCase.RegisterRequest;
import RegisterUseCase.RegisterResponse;

/**
 * The register controller has a create method which allows the user to create an account
 */
public class RegisterController implements Controller {
    final RegisterInputBoundary inputBoundary;

    public RegisterController(RegisterInputBoundary inputBoundary) {this.inputBoundary = inputBoundary;}
    public void create(String name, String Address, String email, String pass1, String pass2){
        RegisterRequest request = new RegisterRequest(name, Address, email, pass1, pass2);
        inputBoundary.create(request);
    }
}
