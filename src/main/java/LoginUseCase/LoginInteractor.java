package LoginUseCase;

import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import entities.User;
import screens.Presenter;
import java.util.HashMap;

/**
 * Interactor for login that validates the user login from the database
 */
public class LoginInteractor implements LoginInputBoundary, Interactor{

    private final DatabaseGateway dbgateway;
    private User currentUser;
    private APIGateway apiGateway;
    private final Presenter presenter;

    public LoginInteractor(DatabaseGateway dbGateway, APIGateway apiGateway, Presenter presenter, User currentUser){
        this.currentUser = currentUser;
        this.apiGateway = apiGateway;
        this.dbgateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        if(dbgateway.validateAndLogin(loginRequest.getEmail(), loginRequest.getPassword())){
            HashMap<String, Object> dbUser = dbgateway.getLoggedInUser();
            System.out.println(dbUser);
            this.currentUser.setLongitude((double)dbUser.get("longitude"));
            this.currentUser.setLatitude((double)dbUser.get("latitude"));
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
    public void back() {this.presenter.showPreviousScreen();}
    public void navigateSignup(){
        this.presenter.start();
    }
}
