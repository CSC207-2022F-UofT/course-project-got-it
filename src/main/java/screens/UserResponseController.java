package screens;

/**
 * User Response controller that has the goBack method to let the interactor know that the back button has been pressed
 */

import UserResponseWindowUseCase.UserResponseInteractor;

public class UserResponseController implements Controller{
    private UserResponseInteractor interactor;

    public UserResponseController(UserResponseInteractor interactor) {
        this.interactor = interactor;
    }

    public void goBack(){
        System.out.println("\n\n\n\n\n\n called \n\n\n\n\n");
        this.interactor.goBack();
    }
}
