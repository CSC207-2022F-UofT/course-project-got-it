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
        int[] a = {1, 2};
        User user = factory.create(a, request.getEmail(), request.getPassword(), "abc");

        RegisterDBRequest DBmodel = new RegisterDBRequest(user.getHomeCoordinates(), user.getEmail(), user.getPassword(), user.getName());
        gateway.save(DBmodel);

        RegisterResponse accountResponse = new RegisterResponse(user.getEmail());
        presenter.registerSuccessView();
    }
}
