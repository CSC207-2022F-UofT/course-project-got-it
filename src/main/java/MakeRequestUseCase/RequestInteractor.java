package MakeRequestUseCase;

import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import entities.Request;
import entities.User;
import screens.Presenter;

import java.util.List;

public class RequestInteractor implements RequestInputBoundary{

    private final DatabaseGateway dbGateway;
    private final APIGateway apiGateway;
    private final Presenter presenter;
    public RequestInteractor(APIGateway apiGateway, DatabaseGateway dbGateway, Presenter presenter){
        this.apiGateway = apiGateway;
        this.dbGateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public void request(RequestRequest requestRequest) {
        Object[] itemGeoCode = this.apiGateway.getGeocode(requestRequest.getItem_loc());
        Object[] deliveryGeoCode = this.apiGateway.getGeocode(requestRequest.getReq_loc());
        Request requestObj = new Request(requestRequest.getItemName(), requestRequest.getDescription(), (Double[]) itemGeoCode, (Double[]) deliveryGeoCode, requestRequest.getDeliveryNotes());
        if(checkForAnyEmptyField(requestObj.getDetails()) && dbGateway.storeRequestInfo(requestRequest)){
            this.presenter.showMakeRequestSuccess();
        }
        else{
            this.presenter.showMakeRequestFail();
        }
    }

    public boolean checkForAnyEmptyField(Object[] inputs){
        for (Object input : inputs) {
            if (input == ""){
                return false;
            }
        }
        return true;
    }
}
