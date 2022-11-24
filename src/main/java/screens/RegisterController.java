package screens;
import RegisterUseCase.RegisterInputBoundary;
import RegisterUseCase.RegisterRequest;
import RegisterUseCase.RegisterResponse;

public class RegisterController {
    final RegisterInputBoundary inputBoundary;

    public RegisterController(RegisterInputBoundary inputBoundary) {this.inputBoundary = inputBoundary;}
    RegisterResponse create(String email, String pass1, String pass2){
        RegisterRequest request = new RegisterRequest(email, pass1, pass2);

        return inputBoundary.create(request);
    }
}
