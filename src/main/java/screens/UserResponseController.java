package screens;

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
