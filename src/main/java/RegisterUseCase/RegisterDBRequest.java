package RegisterUseCase;

/**
 * Contains RegisterDBRequest method which is a data transfer object from the interactor to the databse gateway
 */
public class RegisterDBRequest {
    private final String email;
    private String password;
    private double longitude;
    private double latitude;
    private String name;

    public RegisterDBRequest(double longitude, double latitude, String email, String password, String name){
        this.email = email;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
