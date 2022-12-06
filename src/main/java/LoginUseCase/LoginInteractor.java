package LoginUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import screens.Presenter;
import java.util.HashMap;
public class LoginInteractor implements LoginInputBoundary, Interactor{

    private final DatabaseGateway gateway;
    private User currentUser;
    private final Presenter presenter;

    public LoginInteractor(DatabaseGateway dbGateway, Presenter presenter, User currentUser){
        this.currentUser = currentUser;
        this.gateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        if(gateway.validateAndLogin(loginRequest.getEmail(), loginRequest.getPassword())){
            HashMap<String, Object> dbUser = gateway.getLoggedInUser();
            this.currentUser.setAddress( (String) dbUser.get("address"));
            this.currentUser.setName((String)dbUser.get("name"));
            this.currentUser.setPassword((String)dbUser.get("password"));
            this.currentUser.setEmail((String)dbUser.get("email"));
            this.currentUser.setUid(dbUser.get("_id").toString());
            this.currentUser.setLoggedIn();
            this.presenter.loginSuccess(new LoginResponse(true,
                    loginRequest.getEmail(), loginRequest.getPassword()));
            this.presenter.showHomescreen();
        }
        else{
            this.presenter.loginFailed();
        }
    }

    public void navigateSignup(){
        this.presenter.start();
    }
}
