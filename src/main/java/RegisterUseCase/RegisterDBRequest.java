package RegisterUseCase;

public class RegisterDBRequest {
    private final String email;
    private String password;
    private double longitude;
    private String name;
    private double latitude;
    public RegisterDBRequest(double[] coords, String email, String password, String name){
        this.email = email;
        this.password = password;
        this.longitude = coords[0];
        this.latitude = coords[1];
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
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
