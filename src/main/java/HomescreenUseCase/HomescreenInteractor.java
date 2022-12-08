package HomescreenUseCase;
//KEEP MINE
import APIGateway.APIGateway;
import entities.User;
import screens.Presenter;

public class HomescreenInteractor {
    private final Presenter presenter;
    private final User currentUser;
    private final APIGateway APIGateway;
    public HomescreenInteractor(Presenter presenter, User currentUser, APIGateway APIGateway){
        this.presenter = presenter;
        this.currentUser = currentUser;
        this.APIGateway = APIGateway;
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
        this.presenter.showPastRequests();
    }

    public void navigateCurrentrequests() {this.presenter.showCurrentrequest();}

}

