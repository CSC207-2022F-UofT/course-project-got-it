package MakeRequestUseCase;

import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import entities.Request;
import screens.Presenter;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

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
        double[] itemGeoCode = this.apiGateway.getGeocode(requestRequest.getItem_loc());
        double[] deliveryGeoCode = this.apiGateway.getGeocode(requestRequest.getReq_loc());
        Request requestObj = new Request(requestRequest.getItemName(), requestRequest.getDescription(),
                itemGeoCode, deliveryGeoCode, requestRequest.getDeliveryNotes(), requestRequest.getRequester());
        requestObj.setStartTime(LocalTime.now());

        String requestID = dbGateway.storeRequestInfo(requestObj);
        requestObj.setRequestId(requestID);

        if(checkForAnyEmptyField(requestObj.getDetails()) && itemGeoCode.length > 1 && deliveryGeoCode.length > 1 &&
                !Objects.equals(requestID, "save_failed")){
            if(this.dbGateway.assignClosestDriver(requestID)){
                this.presenter.showMakeRequestSuccess();
            }
            else{
                this.presenter.showMakeRequestFail();
            }
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