package MakeRequestUseCase;

import entities.User;

public class RequestInteractor implements RequestInputBoundary{

    private final RequestDBGateway gateway;
    public RequestInteractor(RequestDBGateway dbGateway){
        this.gateway = dbGateway;
    }
    @Override
    public RequestResponse request(RequestRequest requestRequest) { //check response validitiy
        if(requestRequest.inputs().count('') == 0){ // checks if any field is empty
            gateway.storeRequestInfo(); // store in DB (TO BE implemented)
            return new RequestResponse(true);
        }
        else{ // if any required field is blank
            return new RequestResponse(false);
        }
    }
}
