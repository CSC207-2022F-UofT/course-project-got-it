package screens;
import DeliveryUseCase.DeliveryInputBoundary;
import DeliveryUseCase.DeliveryRequest;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestRequest;
import MakeRequestUseCase.RequestResponse;
import entities.User;
import screens.Controller;

public class DeliveryController implements Controller {

    final DeliveryInputBoundary inputBoundary;
    private final User currentUser;
    public DeliveryController(DeliveryInputBoundary inputBoundary, User currentUser){
        this.inputBoundary = inputBoundary;
        this.currentUser = currentUser;
    }

    public void request(){
        DeliveryRequest request = new DeliveryRequest(currentUser);
        inputBoundary.status(request);
    }
}