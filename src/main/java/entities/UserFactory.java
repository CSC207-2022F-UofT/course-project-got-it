package entities;

public class UserFactory {
    public User create(double longitude, double latitude, String userEmail, String password, String name){
        return new User(longitude,latitude, userEmail, password, name);
    }
}
