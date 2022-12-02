package MakeRequestUseCase;

import dbGateway.DatabaseGateway;
import entities.User;
import screens.Presenter;

import java.util.List;

public class RequestInteractor implements RequestInputBoundary{

    private final DatabaseGateway gateway;
    private final Presenter presenter;
    public RequestInteractor(DatabaseGateway dbGateway, Presenter presenter){
        this.gateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public RequestResponse request(RequestRequest requestRequest) { //check response validitiy
        if(checkForAnyEmptyField(requestRequest.inputs())){ // checks if any field is empty
            gateway.storeRequestInfo(requestRequest); // store in DB (TO BE implemented)
            return new RequestResponse(true);
        }
        else{ // if any required field is blank
            return new RequestResponse(false);
        }
    }

    public boolean checkForAnyEmptyField(List inputs){
        for (Object input : inputs) {
            if (input == ""){
                return false;
            }
        }
        return true;
    }
}
