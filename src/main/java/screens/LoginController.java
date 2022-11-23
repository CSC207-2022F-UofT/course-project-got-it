package screens;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginRequest;
import LoginUseCase.LoginResponse;

public class LoginController {

    final LoginInputBoundary inputBoundary;
    public LoginController(LoginInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

     LoggedInScreen login(String username, String password){
        LoginRequest request = new LoginRequest(username, password);
        LoginResponse response = inputBoundary.login(request);
        LoggedInScreen updatedScreen = new LoggedInScreen(response);
        return updatedScreen;
    }
}
