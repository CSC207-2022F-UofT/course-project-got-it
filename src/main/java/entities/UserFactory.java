package entities;

public class UserFactory {
    public User create(int[] coords, String userEmail, String password, String name){
        return new User(coords, userEmail, password, name, false);
    }
}
