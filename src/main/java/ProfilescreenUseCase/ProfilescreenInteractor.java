package ProfilescreenUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.UserFactory;
import screens.Presenter;

public class ProfilescreenInteractor {
    private final DatabaseGateway gateway;

    public  User user;
    private final Presenter presenter;

    public ProfilescreenInteractor(DatabaseGateway gateway, User user, Presenter presenter) {
        this.gateway = gateway;
        this.user = user;
        this.presenter = presenter;
    }

    public void changeName(String name){
        this.user.setName(name);
    }
    public void changeEmail(String email){
        this.user.setEmail(email);
    }

    public void changePassword(String password){
        this.user.setPassword(password);
    }

    public void changeAddress(String address) {
        this.user.setAddress(address);
    }
}
