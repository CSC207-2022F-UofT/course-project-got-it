package entities;

/**
 * Entity later for user that includes longitude, latitude, user email, password, and name
 */
public class User {
    private double longitude;
    private double latitude;
    private String email;
    private boolean loggedIn;

    private String password;
    private String name;
    private String uid;
    public User(double longitude, double latitude, String userEmail, String password, String name){
        this.password = password;
        this.longitude = longitude;
        this.latitude = latitude;
        this.email = userEmail;
        this.name = name;
        this.loggedIn = true;
    }

    public User(){
        this.loggedIn = false;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double[] getHomeCoordinates(){
        return new double[]{this.latitude, this.longitude};
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid(){
        if(this.loggedIn){
            return this.uid;
        }
        return "NOT_LOGGED_IN";
    }

    public void setLoggedIn() {
        if(this.password.length() >= 1 && this.email.length() >= 1 && this.name.length() >= 1){
            this.loggedIn = true;
        }
        else{
            this.loggedIn = false;
        }
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        if(this.loggedIn){
            return password;
        }
        return "NOT_LOGGED_IN";
    }

    public String getEmail() {
        if(this.loggedIn){
            return email;
        }
        return "NOT_LOGGED_IN";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        if(this.loggedIn){
            return name;
        }
        return "NOT_LOGGED_IN";
    }

    public void setName(String name) {
        this.name = name;
    }
}
