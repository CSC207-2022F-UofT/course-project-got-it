package entities;

/**
 * Entity later for user factory that contains the new user information that is being created
 */
public class UserFactory {
    public User create(double longitude, double latitude, String userEmail, String password, String name){
        return new User(longitude,latitude, userEmail, password, name);
    }
}
