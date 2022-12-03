package HomescreenUseCase;

import screens.Presenter;

public class HomescreenInteractor {
    private final Presenter presenter;
    public HomescreenInteractor(Presenter presenter){
        this.presenter = presenter;
    }

    public void navigateProfile(){
        this.presenter.showProfile();
    }

    public void navigateNewrequest(){
        this.presenter.showMakeRequest();
    }

    public void navigatePastrequests(){
        this.presenter.showPastRequests();
    }
}

