package geocode;
/**
 * Helper method to calculate the distance between two different coordinates
 */
public class geocodeDistanceHelper {
    public double getDistance(double longA, double latA, double longB, double latB){
        double longitudeARadians = Math.toRadians(longA);
        double latitudeARadians = Math.toRadians(latA);
        double longitudeBRadians = Math.toRadians(longB);
        double latitudeBRadians = Math.toRadians(latB);
        double longitudeDifference = longitudeARadians - longitudeBRadians;
        double latitudeDifference = latitudeARadians - latitudeBRadians;
        return ((2 * Math.asin(Math.sqrt(Math.pow(Math.sin(latitudeDifference/2), 2) +
                (Math.cos(latitudeARadians) * Math.cos(latitudeBRadians)) *
                        Math.pow(Math.sin(longitudeDifference/2), 2)))) * 6371) * 1.609344;
    }
}
