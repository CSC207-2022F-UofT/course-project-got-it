package UserResponseWindowUseCase;

import screens.Presenter;

/**
 * User response interactor which calls show previous screen from presenter when back button is clicked
 */
public class UserResponseInteractor {
    private Presenter presenter;
    public UserResponseInteractor(Presenter presenter){
        this.presenter = presenter;
    }

    public void goBack(){
        presenter.showPreviousScreen();
    }
}