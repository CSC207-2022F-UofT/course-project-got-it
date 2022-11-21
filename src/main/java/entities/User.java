package entities;

public class User {
    private int homeLongitude;
    private int homeLatitude;

    private String email;
    private String name;
    private int uid;
    public User(int[] coords, String userEmail, String name, int uid){
        this.homeLatitude = coords[0];
        this.homeLongitude = coords[1];
        this.email = userEmail;
        this.name = name;
        this.uid = uid;
    }

    public int[] getHomeCoordinates() {
        return new int[]{this.homeLatitude, this.homeLongitude};
    }

    public void setHomeCoordinates(int[] homeCoordinates) {
        this.homeLatitude = homeCoordinates[0];
        this.homeLongitude = homeCoordinates[1];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
