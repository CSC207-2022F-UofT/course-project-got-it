package screens;

import PastRequestUseCase.PastRequestInputBoundary;
import PastRequestUseCase.PastRequestRequest;
import entities.User;

public class PastRequestController implements Controller {
    final PastRequestInputBoundary inputBoundary;
    public PastRequestController(PastRequestInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary; }

    public void request(User currentUser) {
        PastRequestRequest request = new PastRequestRequest(currentUser);


    }
}
