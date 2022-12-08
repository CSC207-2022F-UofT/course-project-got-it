package screens;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginRequest;

public class LoginController implements Controller {

    final LoginInputBoundary inputBoundary;
    public LoginController(LoginInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void navigateSignup(){
        inputBoundary.navigateSignup();
    }
     public void login(String email, String password){
        LoginRequest request = new LoginRequest(email, password);
        inputBoundary.login(request);
    }


}
