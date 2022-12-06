package HomescreenUseCase;

import entities.User;
import screens.Presenter;

public class HomescreenInteractor {
    private final Presenter presenter;
    private final User currentUser;
    public HomescreenInteractor(Presenter presenter, User currentUser){
        this.presenter = presenter;
        this.currentUser = currentUser;
    }

    public void navigateProfile(){
        this.presenter.showProfile(currentUser.getName(), currentUser.getaddress(),
                currentUser.getEmail(), currentUser.getPassword());
    }

    public void navigateNewrequest(){
        this.presenter.showMakeRequest();
    }

    public void navigatePastrequests(){
        this.presenter.showPastRequests();
    }
}

