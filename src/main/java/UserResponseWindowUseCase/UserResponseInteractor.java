package UserResponseWindowUseCase;

import screens.Presenter;

public class UserResponseInteractor {
    private Presenter presenter;
    public UserResponseInteractor(Presenter presenter){
        this.presenter = presenter;
    }

    /**
     * The interactor points to the presenter to perform the showPreviousScreen method
     */
    public void goBack(){
        presenter.showPreviousScreen();
    }
}
