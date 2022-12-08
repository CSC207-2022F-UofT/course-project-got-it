package HomescreenUseCase;

import screens.Presenter;

public class HomescreenInteractor {
    private final Presenter presenter;
    public HomescreenInteractor(Presenter presenter){
        this.presenter = presenter;
    }

    public void navigateProfile(){
        this.presenter.to_profile();
    }

//    public void navigateNewrequest(){
//        this.presenter.to_Newrequest();
//    }

    public void navigatePastrequests(){
        this.presenter.to_Pastrequests();
    }
}

