package screens;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestRequest;
import MakeRequestUseCase.RequestResponse;
import entities.User;

/**
 * The request controller has a request method which allows the user to create a request
 */
public class RequestController implements Controller {

    final RequestInputBoundary inputBoundary;
    private final User currentUser;
    public RequestController(RequestInputBoundary inputBoundary, User currentUser){
        this.inputBoundary = inputBoundary;
        this.currentUser = currentUser;
    }

    public void request(String itemName, String req_loc, String item_loc, String description, String deliveryNotes){
        RequestRequest request = new RequestRequest(itemName, req_loc, item_loc, description, deliveryNotes, currentUser);
        inputBoundary.request(request);
    }
}
