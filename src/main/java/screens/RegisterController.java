package screens;
import RegisterUseCase.RegisterInputBoundary;
import RegisterUseCase.RegisterRequest;
import RegisterUseCase.RegisterResponse;

public class RegisterController implements Controller {
    final RegisterInputBoundary inputBoundary;

    public RegisterController(RegisterInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;}
    public void create(String email, String pass1, String pass2){
        RegisterRequest request = new RegisterRequest(email, pass1, pass2);
        inputBoundary.create(request);
    }
}
