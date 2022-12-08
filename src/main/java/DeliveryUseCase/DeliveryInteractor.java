package DeliveryUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.Request;
import screens.Presenter;
import java.time.LocalTime;
import java.util.*;
import java.lang.*;
import geocode.geocodeDistanceHelper;

public class DeliveryInteractor implements DeliveryInputBoundary{

    private final DatabaseGateway gateway;
    private final Presenter presenter;
    final double AVG_SPEED = 1.6666667e-11;

    public DeliveryInteractor(DatabaseGateway dbGateway, Presenter presenter){
        this.gateway = dbGateway;
        this.presenter = presenter;
    }

    @Override
    public void status(DeliveryRequest deliveryRequest){ //check if delivery completed
        // getting locations (get using currentUser and db)
        User user = deliveryRequest.getUser();
        double[] userLocation = user.getHomeCoordinates();
        ArrayList<Request> requestInfo = gateway.getRequests(user);  // DB function
        geocodeDistanceHelper helper = new geocodeDistanceHelper();
        HashMap<String, String> requestTimes = new HashMap<>();
        for (Request request : requestInfo) {
            // calculating time
            double[] driverLocation = gateway.getDriverLocation(request.getRequestId()); // DB function
            double[] itemLocation = request.getItemAddress();

            long distance = ((long) helper.getDistance(driverLocation[0], driverLocation[1], itemLocation[0],
                    itemLocation[1]) +
                    (long) helper.getDistance(itemLocation[0], itemLocation[1], userLocation[0], userLocation[1]))/1000;
            long totalTime = (long) (distance / AVG_SPEED); // should be nano
            LocalTime estimatedArrival = LocalTime.parse(request.getStartTime()).plusNanos(totalTime);
            String arrivalFinal = estimatedArrival.getHour() + ":" + estimatedArrival.getMinute();
            //long startNano = request.getStartTime().values().toArray(a)[0].get;
            if (LocalTime.now().isAfter(estimatedArrival)) {
                gateway.completeRequest(request.getRequestId());
                // gateway.driverAvailable()
            } else {
                requestTimes.put(request.getItemName(), arrivalFinal);
            }
        }
        if (requestTimes.isEmpty()){
            //presenter.deliveryError();
        }
        else{
            //presenter.showDeliveryTime(requestTimes);
        }
    }
}
