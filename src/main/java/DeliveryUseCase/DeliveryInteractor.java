package DeliveryUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.User;
import entities.Request;
import screens.Presenter;

import java.util.*;
import java.lang.*;

public class DeliveryInteractor implements DeliveryInputBoundary{

    private final DatabaseGateway gateway;
    private final long startTime;
    private final Presenter presenter;
    final int AVG_SPEED = 60;

    public DeliveryInteractor(DatabaseGateway dbGateway, Presenter presenter){
        this.gateway = dbGateway;
        this.presenter = presenter;
        this.startTime = System.nanoTime();
    }

    // add presenter methods
    @Override
    public void status(DeliveryRequest deliveryRequest){ //check if delivery completed
        // getting locations (get using currentUser and db)
        User user = deliveryRequest.getUser();
        double[] userLocation = user.getHomeCoordinates();
        Request[] requestInfo = gateway.getRequests(user);  // DB function

        HashMap<String, Integer> requestTimes = new HashMap<>();
        for (Request request : requestInfo) {
            // calculating time
            double[] driverLocation = gateway.getDriverLocation(request.getId()); // DB function
            double[] itemLocation = request.getItemAddress();

            double distance = distance_km(driverLocation, itemLocation) +
                    distance_km(itemLocation, userLocation);
            long nanoToMin = 60000000000L;
            double time = (distance / AVG_SPEED) * nanoToMin * 60;

            double remaining = (time - (System.nanoTime() - this.startTime)) / nanoToMin;

            if (remaining <= 0)
                gateway.completeRequest(request.getId());
            else
                requestTimes.put(request.getItemName(), (int)Math.floor(remaining));
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
