package RegisterUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.UserFactory;
import screens.Presenter;

public class RegisterInteractor implements RegisterInputBoundary {
    private final DatabaseGateway gateway;
    private final UserFactory factory;
    private final Presenter presenter;

    public RegisterInteractor(DatabaseGateway DBgateway, UserFactory factory, Presenter presenter){
        this.gateway = DBgateway;
        this.factory = factory;
        this.presenter = presenter;
    }

    @Override
    public void create(RegisterRequest request){
        if (gateway.exists(request.getEmail())){
            presenter.registerFailView();
        } else if (!request.getPassword().equals(request.getRepeatPassword())) {
            presenter.registerFailView();
        }

        User user = factory.create(request.getAddress(), request.getEmail(), request.getPassword(), request.getName());

        RegisterDBRequest DBmodel = new RegisterDBRequest(user.getaddress(), user.getEmail(), user.getPassword(), user.getName());
        gateway.save(DBmodel);

        RegisterResponse accountResponse = new RegisterResponse(user.getEmail());
        presenter.registerSuccessView();
    }
}
