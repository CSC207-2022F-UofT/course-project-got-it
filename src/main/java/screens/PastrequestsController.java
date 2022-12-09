package screens;

import PastrequestsUseCase.PastrequestsInteractor;
import ProfilescreenUseCase.ProfilescreenInteractor;
import entities.User;

public class PastrequestsController {
    public PastrequestsInteractor interactor;
    public User user;

    public PastrequestsController(PastrequestsInteractor interactor) {
        this.interactor = interactor;
        this.user = interactor.user;
    }
}
