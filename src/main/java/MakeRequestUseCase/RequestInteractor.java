package MakeRequestUseCase;

import DatabaseGateway.DatabaseGateway;
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
    public void request(RequestRequest requestRequest) { //check response validitiy
        if(checkForAnyEmptyField(requestRequest.inputs()) && gateway.storeRequestInfo(requestRequest)){ // checks if any field is empty
            this.presenter.showMakeRequestSuccess();
        }
        else{
            this.presenter.showMakeRequestFail();
        }
    }

    @Override
    public void goBack() {
        presenter.showPreviousScreen();
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
