package APIGateway;
//KEEP

/**
 * Interface for API Gateway for the PositionStack API that converts geocodes to addresses and vice-versa
 */
public interface APIGateway {
    public double[] getGeocode(String address);

    public String getAddress(double[] geocode);
}
