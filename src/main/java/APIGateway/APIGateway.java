package APIGateway;
//KEEP

public interface APIGateway {
    public double[] getGeocode(String address);

    public String getAddress(double[] geocode);
}
