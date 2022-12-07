package UserResponseWindowUseCase;

import screens.Presenter;

public class UserResponseInteractor {
    private Presenter presenter;
    public UserResponseInteractor(Presenter presenter){
        this.presenter = presenter;
    }

    public void goBack(){
        presenter.showPreviousScreen();
    }
}
