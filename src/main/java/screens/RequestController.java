package screens;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestRequest;
import MakeRequestUseCase.RequestResponse;

public class RequestController {

    final RequestInputBoundary inputBoundary;
    public RequestController(RequestInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    RequestMadeScreen request(String req_loc, String item_loc, String description, String requester){
        RequestRequest request = new RequestRequest(req_loc, item_loc, description, requester);
        RequestResponse response = inputBoundary.request(request);
        RequestMadeScreen updatedScreen = new RequestMadeScreen(response);
        return updatedScreen;
    }
}
