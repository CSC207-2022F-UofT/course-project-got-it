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
    final double AVG_SPEED = 5.5555556e-11;
    private String itemName;

    public DeliveryInteractor(DatabaseGateway dbGateway, Presenter presenter){
        this.gateway = dbGateway;
        this.presenter = presenter;
        this.itemName = "";
    }

    @Override
    public void status(DeliveryRequest deliveryRequest){ //check if delivery completed
        // getting locations (get using currentUser and db)
        User user = deliveryRequest.getUser();
        double[] userLocation = user.getHomeCoordinates();
        ArrayList<Request> requestInfo = gateway.getRequests(user);  // DB function
        geocodeDistanceHelper helper = new geocodeDistanceHelper();
        HashMap<String, String> requestTimes = new HashMap<>();
        String itemName;
        for (Request request : requestInfo) {
            // calculating time
            System.out.println("REQUEST: " + request.getRequestId());
            double[] driverLocation = gateway.getDriverLocation(request.getRequestId()); // DB function
            double[] itemLocation = request.getItemAddress();

            long distance = (long) helper.getDistance(driverLocation[0], driverLocation[1], itemLocation[0],
                    itemLocation[1]) +
                    (long) helper.getDistance(itemLocation[0], itemLocation[1], userLocation[0], userLocation[1]);
            long totalTime = (long) (distance / AVG_SPEED); // should be nano
            LocalTime estimatedArrival = LocalTime.parse(request.getStartTime()).plusNanos(totalTime);
            String arrivalFinal = estimatedArrival.getHour() + ":" + estimatedArrival.getMinute();

            //long startNano = request.getStartTime().values().toArray(a)[0].get;
            if (LocalTime.now().isAfter(estimatedArrival)) {
                gateway.completeRequest(request.getRequestId());
                // gateway.driverAvailable()
            } else {
                this.itemName = request.getItemName();
                requestTimes.put(request.getItemName(), arrivalFinal);
            }
        }
        if (requestTimes.isEmpty()){
            presenter.showDeliveryTimeFailed();
        }
        else{
            presenter.showDeliveryTime(requestTimes.get(this.itemName));
        }
    }
}
