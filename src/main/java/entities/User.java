package entities;

public class User {
    private double homeLongitude;
    private double homeLatitude;

    private String email;
    private boolean loggedIn;

    private String password;
    private String name;
    private String uid;
    public User(double[] coords, String userEmail, String password, String name){
        this.password = password;
        this.homeLatitude = coords[0];
        this.homeLongitude = coords[1];
        this.email = userEmail;
        this.name = name;
        this.loggedIn = true;
    }

    public User(){
        this.loggedIn = false;
    }

    public double[] getHomeCoordinates() {
        return new double[]{this.homeLatitude, this.homeLongitude};
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

    public void setHomeCoordinates(double[] homeCoordinates) {
        this.homeLatitude = homeCoordinates[0];
        this.homeLongitude = homeCoordinates[1];
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
