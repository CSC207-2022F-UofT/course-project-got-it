package screens;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestRequest;
import MakeRequestUseCase.RequestResponse;

public class RequestController implements Controller {

    final RequestInputBoundary inputBoundary;
    public RequestController(RequestInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void request(String req_loc, String item_loc, String description, String requester, String deliveryNotes){
        RequestRequest request = new RequestRequest(req_loc, item_loc, description, requester, deliveryNotes);
        inputBoundary.request(request);
    }
}
