package APIGateway;

/**
 * Interface for API Gateway to convert address to coordinates
 */
public interface APIGateway {
    public double[] getGeocode(String address);

    public String getAddress(double[] geocode);
}
