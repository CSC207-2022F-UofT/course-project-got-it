package LoginUseCase;

import dbGateway.DatabaseGateway;
import screens.Presenter;

public class LoginInteractor implements LoginInputBoundary, Interactor{

    private final DatabaseGateway gateway;
    private final Presenter presenter;
    public LoginInteractor(DatabaseGateway dbGateway, Presenter presenter){
        this.gateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        if(gateway.validateAndLogin(loginRequest.getEmail(), loginRequest.getPassword())){
            System.out.println("logged in");
            this.presenter.loginSuccess(new LoginResponse(true,
                    loginRequest.getEmail(), loginRequest.getPassword()));
        }
        else{
            this.presenter.loginFailed();
        }
    }
}
