package HomescreenUseCase;
import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import entities.Request;
import entities.User;
import screens.Presenter;

/**
 * Interactor for homescreen that helps the presenter to navigate through the screens
 */
import java.util.ArrayList;

public class HomescreenInteractor {
    private final Presenter presenter;
    private final User currentUser;
    private final APIGateway APIGateway;
    private final DatabaseGateway dbGateway;

    public HomescreenInteractor(Presenter presenter, User currentUser, APIGateway APIGateway,
                                DatabaseGateway dbGateway){
        this.presenter = presenter;
        this.currentUser = currentUser;
        this.APIGateway = APIGateway;
        this.dbGateway = dbGateway;
    }

    public void navigateProfile(){
        double[] coords = {this.currentUser.getLongitude(), this.currentUser.getLatitude()};
        String address = this.APIGateway.getAddress(coords);
        System.out.println(address);
        this.presenter.showProfile(currentUser.getName(), address,
                currentUser.getEmail(), currentUser.getPassword());
    }

    public void navigateNewrequest(){
        this.presenter.showMakeRequest();
    }

    public void navigatePastrequests(){
        ArrayList<Request> pastRequests = this.dbGateway.getPassedRequests(this.currentUser);
        this.presenter.showPastRequests(pastRequests);
    }

    public void navigateCurrentrequests() {
        ArrayList<Request> requests = this.dbGateway.getRequests(this.currentUser);
        Request request = requests.get(0);
        String itemLocation = this.APIGateway.getAddress(request.getItemAddress());
        String deliveryLocation = this.APIGateway.getAddress(request.getDeliveryAddress());
        String driverName = this.dbGateway.getDriverName(request.getRequestId());
        this.presenter.showCurrentrequest(request.getItemName(), request.getitemDescription(), itemLocation,
                deliveryLocation, driverName);
    }

}

