package entities;

public class UserFactory {
    public User create(String Address, String userEmail, String password, String name){
        return new User(Address, userEmail, password, name);
    }
}
