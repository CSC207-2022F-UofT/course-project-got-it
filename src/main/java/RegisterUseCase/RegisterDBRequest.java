package RegisterUseCase;

public class RegisterDBRequest {
    private final String email;
    private String password;
    private int longitude;
    private String name;
    private int latitude;
    public RegisterDBRequest(int[] coords, String email, String password, String name){
        this.email = email;
        this.password = password;
        this.longitude = coords[0];
        this.latitude = coords[1];
        this.name = name;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
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
