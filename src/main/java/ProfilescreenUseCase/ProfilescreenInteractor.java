package ProfilescreenUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import screens.Presenter;

/**
 * Interactor for profile screen that allows user to change their information
 */
public class ProfilescreenInteractor {
    private final DatabaseGateway dbGateway;

    public  User user;
    private final Presenter presenter;

    public ProfilescreenInteractor(DatabaseGateway dbGateway, User user, Presenter presenter) {
        this.dbGateway = dbGateway;
        this.user = user;
        this.presenter = presenter;
    }

    public void changeName(String name){
        this.user.setName(name);
        dbGateway.updateUser(this.user);
        presenter.showHomescreen();
    }
    public void changeEmail(String email){
        this.user.setEmail(email);
        dbGateway.updateUser(this.user);
        presenter.showHomescreen();
    }

    public void changePassword(String password){
        this.user.setPassword(password);
        dbGateway.updateUser(this.user);
        presenter.showHomescreen();

    }


}
