package DeliveryUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.Request;
import screens.Presenter;

import java.time.LocalTime;
import java.util.*;
import java.lang.*;

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
        Request[] requestInfo = gateway.getRequests(user.getUid());  // DB function

        HashMap<String, String> requestTimes = new HashMap<>();
        for (Request request : requestInfo) {
            // calculating time
            double[] driverLocation = gateway.getDriverLocation(request.getRequester()); // DB function
            double[] itemLocation = request.getItemAddress();

            long distance = (long)distance_km(driverLocation, itemLocation) +
                    (long)distance_km(itemLocation, userLocation);
            long totalTime = (long)(distance / AVG_SPEED); // should be nano

            LocalTime estimatedArrival = request.getStartTime().plusNanos(totalTime);
            String arrivalFinal = estimatedArrival.getHour() + ":" + estimatedArrival.getMinute();

            //long startNano = request.getStartTime().values().toArray(a)[0].get;
            if (LocalTime.now().isAfter(estimatedArrival)){
                gateway.completeRequest(request.getRequestId());
            }
            else
                requestTimes.put(request.getItemName(), arrivalFinal);
        }
        if (requestTimes.isEmpty())
            presenter.noRequests();
        else
            presenter.statusScreen(requestTimes);
    }

    public static double distance_km(double[] d1, double[] d2){
        double lat1 = Math.toRadians(d1[0]);
        double lat2 = Math.toRadians(d2[0]);
        double lon1 = Math.toRadians(d2[1]);
        double lon2 = Math.toRadians(d1[1]);

        double lon = lon2 - lon1;
        double lat = lat2 - lat1;
        double a = Math.pow(Math.sin(lat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(lon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        return(c * 6371);
    }
}
