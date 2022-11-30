package screens;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginRequest;
import LoginUseCase.LoginResponse;

public class LoginController {

    final LoginInputBoundary inputBoundary;
    private Presenter presenter;
    public LoginController(LoginInputBoundary inputBoundary, Presenter presenter){
        this.inputBoundary = inputBoundary;
        this.presenter = presenter;
    }

     public void login(String username, String password){
        LoginRequest request = new LoginRequest(username, password);
        LoginResponse response = inputBoundary.login(request);
        if(response.isLoggedIn()){
            this.presenter.addScreen(new LoggedInScreen(response));
        }
        else{
            this.presenter.addScreen(new LoginFailed());
        }
    }
}
