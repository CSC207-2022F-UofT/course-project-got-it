package entities;

public class User {
    private int homeLongitude;
    private int homeLatitude;

    private String email;
    private boolean loggedIn;

    private String password;
    private String name;
    private String uid;
    public User(int[] coords, String userEmail, String password, String name, String uid, boolean loggedIn){
        this.password = password;
        this.homeLatitude = coords[0];
        this.homeLongitude = coords[1];
        this.email = userEmail;
        this.name = name;
        this.uid = uid;
        this.loggedIn = loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public int[] getHomeCoordinates() {
        return new int[]{this.homeLatitude, this.homeLongitude};
    }

    public void setHomeCoordinates(int[] homeCoordinates) {
        this.homeLatitude = homeCoordinates[0];
        this.homeLongitude = homeCoordinates[1];
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
