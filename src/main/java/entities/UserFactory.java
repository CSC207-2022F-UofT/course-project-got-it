package entities;

public class UserFactory {
    public User create(double[] coords, String userEmail, String password, String name){
        return new User(coords, userEmail, password, name);
    }
}
