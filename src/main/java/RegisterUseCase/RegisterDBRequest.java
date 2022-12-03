package RegisterUseCase;

public class RegisterDBRequest {
    private String email;
    private String password;

    private Double homeLongitude;
    private Double homeLatitude;

    private String name;

    public RegisterDBRequest(String name, String email, String password, Double[] coords){
        this.name = name;
        this.email = email;
        this.password = password;
        this.homeLongitude = coords[0];
        this.homeLatitude = coords[1];
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getHomeCoordinates() {
        return new Double[]{this.homeLatitude, this.homeLongitude};
    }

    public void setHomeCoordinates(Double[] homeCoordinates) {
        this.homeLatitude = homeCoordinates[0];
        this.homeLongitude = homeCoordinates[1];
    }
    public String getName() {
        return name;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
