package MakeRequestUseCase;
// KEEP AZIZS
import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import DeliveryUseCase.DeliveryInteractor;
import DeliveryUseCase.DeliveryRequest;
import entities.Request;
import entities.User;
import screens.DeliveryController;
import screens.Presenter;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

/**
 * Interactor for request that stores the new request information to the database
 */
public class RequestInteractor implements RequestInputBoundary{

    private final DatabaseGateway dbGateway;
    private final APIGateway apiGateway;
    private final Presenter presenter;
    private final User currentuser;
    public RequestInteractor(APIGateway apiGateway, DatabaseGateway dbGateway, Presenter presenter, User currentUser){
        this.apiGateway = apiGateway;
        this.currentuser = currentUser;
        this.dbGateway = dbGateway;
        this.presenter = presenter;
    }
    @Override
    public void request(RequestRequest requestRequest) {
        double[] itemGeoCode = this.apiGateway.getGeocode(requestRequest.getItem_loc());
        double[] deliveryGeoCode = this.apiGateway.getGeocode(requestRequest.getReq_loc());
        Request requestObj = new Request(requestRequest.getItemName(), requestRequest.getDescription(),
                itemGeoCode, deliveryGeoCode, requestRequest.getDeliveryNotes(), requestRequest.getRequester());
        LocalTime currentTime = LocalTime.now();
        requestObj.setStartTime(addZeroIfNeeded(String.valueOf(currentTime.getHour())) + ":" +
                addZeroIfNeeded(String.valueOf(currentTime.getMinute())) + ":"
                                + addZeroIfNeeded(String.valueOf(currentTime.getSecond())));
        String requestID = dbGateway.storeRequestInfo(requestObj);
        System.out.println(requestID);
        requestObj.setRequestId(requestID);
        if(checkForAnyEmptyField(requestObj.getDetails()) && itemGeoCode.length > 1 && deliveryGeoCode.length > 1 &&
                !Objects.equals(requestID, "save_failed")){
            if(this.dbGateway.assignClosestDriver(requestID)){
                //DeliveryInteractor deliveryInteractor = new DeliveryInteractor(this.dbGateway, this.presenter);
                //DeliveryController deliveryController = new DeliveryController(deliveryInteractor);
                //deliveryController.request(this.currentuser);
                this.presenter.showPreviousScreen();
            }
            else{
                this.presenter.showMakeRequestFail();
            }
        }
        else{
            this.presenter.showMakeRequestFail();
        }
    }

    private String addZeroIfNeeded(String time){
        if(time.length() != 2){
            return "0" + time;
        }
        return time;
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