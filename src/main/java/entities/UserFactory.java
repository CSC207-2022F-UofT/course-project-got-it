package entities;

public class UserFactory {
    public User create(int[] coords, String userEmail, String password, String name, String uid){
        return new User(coords, userEmail, password, name, uid, false);
    }
}
