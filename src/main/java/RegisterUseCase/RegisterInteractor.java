package RegisterUseCase;

import entities.User;
import entities.UserFactory;

public class RegisterInteractor implements RegisterInputBoundary {
    private final RegisterDBGateway gateway;
    private final UserFactory factory;
    private final RegisterPresenter presenter;

    public RegisterInteractor(RegisterDBGateway DBgateway, UserFactory factory, RegisterPresenter presenter){
        this.gateway = DBgateway;
        this.factory = factory;
        this.presenter = presenter;
    }

    @Override
    public RegisterResponse create(RegisterRequest request){
        if (gateway.exists(request.getEmail())){
            return presenter.makeFailView();
        } else if (!request.getPassword().equals(request.getRepeatPassword())) {
            return presenter.makeFailView();
        }
        int[] a = {1, 2};
        User user = factory.create(a, request.getEmail(), request.getPassword(), "abc", "");

        RegisterDBRequest DBmodel = new RegisterDBRequest(user.getEmail(), user.getPassword());
        gateway.save(DBmodel);

        RegisterResponse accountResponse = new RegisterResponse(user.getEmail());
        return presenter.makeSuccessView();
    }
}
