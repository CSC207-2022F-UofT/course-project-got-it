package LoginUseCase;

import screens.Presenter;

public class LoginInteractor implements LoginInputBoundary{

    private final DatabaseGateway gateway;
    public LoginInteractor(DatabaseGateway dbGateway){
        this.gateway = dbGateway;
    }
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        if(gateway.validateAndLogin(loginRequest.getEmail(), loginRequest.getPassword())){
            System.out.println("logged in");
            return new LoginResponse(true, loginRequest.getEmail(), loginRequest.getPassword());
        }
        else{
            System.out.println("Not logged in");
            return new LoginResponse(false);
        }
    }
}
