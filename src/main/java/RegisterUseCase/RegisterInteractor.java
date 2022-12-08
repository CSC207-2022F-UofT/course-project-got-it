package RegisterUseCase;

import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.UserFactory;
import screens.Presenter;

import java.util.Arrays;
import java.util.Objects;

/**
 *Interactor for register that stores the new user information to the database
 */
public class RegisterInteractor implements RegisterInputBoundary {
    private final DatabaseGateway gateway;
    private final UserFactory factory;
    private final Presenter presenter;
    private final APIGateway apiGateway;

    public RegisterInteractor(DatabaseGateway DBgateway, APIGateway apiGateway, UserFactory factory, Presenter presenter){
        this.gateway = DBgateway;
        this.apiGateway = apiGateway;
        this.factory = factory;
        this.presenter = presenter;
    }
    @Override
    public void create(RegisterRequest request){
        if (Objects.equals(request.getPassword(), "")){
            presenter.registerFailView();
        } else if (gateway.exists(request.getEmail())){
            presenter.registerFailView();
        } else if (!(request.getPassword().equals(request.getRepeatPassword()))) {
            presenter.registerFailView();
        }
        else {
            double[] coordinates = apiGateway.getGeocode(request.getAddress());
            System.out.println(Arrays.toString(coordinates));
            User user = factory.create(coordinates[0], coordinates[1], request.getEmail(), request.getPassword(), request.getName());
            RegisterDBRequest DBmodel = new RegisterDBRequest(user.getLongitude(), user.getLatitude(),user.getEmail(), user.getPassword(), user.getName());
            gateway.save(DBmodel);
            presenter.registerSuccessView();
        }
    }
}
