package screens;
import RegisterUseCase.RegisterInputBoundary;
import RegisterUseCase.RegisterRequest;
import RegisterUseCase.RegisterResponse;

public class RegisterController {
    final RegisterInputBoundary inputBoundary;

    public RegisterController(RegisterInputBoundary inputBoundary) {this.inputBoundary = inputBoundary;}
    RegisterResponse create(String name, double[] coords, String email, String pass1, String pass2){
        RegisterRequest request = new RegisterRequest(name, coords, email, pass1, pass2);

        return inputBoundary.create(request);
    }
}
