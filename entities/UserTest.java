package entities;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    double[] userAddress = {123.456, 654.321};
    String email = "rob@gmail.com";
    String password = "password";
    String name = "Rob Bert";
    User user1 = new User(userAddress, email, password, name);

    @Test
    void TestGetHomeCoordinates() {
        assert user1.getHomeCoordinates()[0] == userAddress[0];
        assert user1.getHomeCoordinates()[1] == userAddress[1];
    }

    @Test
    void TestSetUid() {
        user1.setUid("A1B2C3");
    }

    @Test
    void TestGetUid() {
        user1.setUid("LOLOL123");
        assert Objects.equals(user1.getUid(), "LOLOL123");
    }

    @Test
    void TestSetLoggedIn() {
        user1.setLoggedIn();
    }

    @Test
    void TestSetHomeCoordinates() {
        double[] newCoordinates = {41.669, 96.614};
        user1.setHomeCoordinates(newCoordinates);
        assert user1.getHomeCoordinates()[0] == newCoordinates[0];
        assert user1.getHomeCoordinates()[1] == newCoordinates[1];
    }

    @Test
    void TestGetPassword() {
        user1.setPassword("NewPassword");
        assert Objects.equals(user1.getPassword(), "NewPassword");
    }

    @Test
    void TestGetEmail() {
        assert Objects.equals(user1.getEmail(), "rob@rgmail.com");
    }

    @Test
    void TestSetEmail() {
        user1.setEmail("other@gmail.com");
        assert Objects.equals(user1.getEmail(), "other@gmail.com");
    }

    @Test
    void getName() {
        assert Objects.equals(user1.getName(), "Rob Bert");
    }

    @Test
    void TestSetName() {
        user1.setName("Paul Line");
        assert Objects.equals(user1.getName(), "Paul Line");
    }
}