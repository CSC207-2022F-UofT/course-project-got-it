package RegisterUseCase;

public class RegisterRequest {
    private double longitude;

    private String name;

    private double latitude;
    private String email;
    private String password;
    private String repeatPassword;

    public RegisterRequest(String name, double[] coords, String email, String password, String repeatPassword) {
        this.name = name;
        this.longitude = coords[0];
        this.latitude = coords[1];
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
