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
    public DeliveryController(DeliveryInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void request(User currentUser){
        DeliveryRequest request = new DeliveryRequest(currentUser);
        inputBoundary.status(request);
    }
}