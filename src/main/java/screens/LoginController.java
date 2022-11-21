package screens;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginRequest;
import LoginUseCase.LoginResponse;

public class LoginController {

    final LoginInputBoundary inputBoundary;
    public LoginController(LoginInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

     LoginResponse login(String username, String password){
        LoginRequest request = new LoginRequest(username, password);
        return inputBoundary.login(request);
    }
}
