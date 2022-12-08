package entities;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class RequestTest {
    String item = ("laptop");
    String description = "13 inch MacBook Pro in room 2200";
    double[] itemAddress = {43.65998888952553, -79.3974562110199};
    double[] deliveryAddress = {43.65240111263872, -79.39230166779534};
    String deliveryNotes = "Leave at the door.";
    double[] homeAddress = {43.65891059985348, -79.3830646246287};
    double[] address2 = {123.456, 654.321};
    User requester = new User(homeAddress, "roger@gmail.com", "Password", "Roger Smith");
    User requester2 = new User(address2, "dodger@yahoo.com", "password", "Dodger Bass");

    Request itemRequest = new Request(item, description, itemAddress, deliveryAddress, deliveryNotes, requester);

    @Test
    void getRequester() {
        assert itemRequest.getRequester() == requester;
    }

    @Test
    void setRequester() {
        itemRequest.setRequester(requester2);
        assert itemRequest.getRequester() == requester2;
    }

    @Test
    void getDetails() {
        assert itemRequest.getDetails()[0] == item;
        assert itemRequest.getDetails()[1] == description;
        assert itemRequest.getDetails()[2] == itemAddress;
        assert itemRequest.getDetails()[3] == deliveryAddress;
        assert itemRequest.getDetails()[4] == deliveryNotes;

    }

    @Test
    void getItemName() {
        assert Objects.equals(itemRequest.getItemName(), item);

    }

    @Test
    void getitemDescription() {
        assert Objects.equals(itemRequest.getitemDescription(), description);

    }

    @Test
    void getItemAddress() {
        assert Arrays.equals(itemRequest.getItemAddress(), itemAddress);
    }

    @Test
    void getDeliveryAddress() {
        assert Arrays.equals(itemRequest.getDeliveryAddress(), deliveryAddress);
    }

    @Test
    void getDeliveryNotes() {
        assert Objects.equals(itemRequest.getDeliveryNotes(), deliveryNotes);
    }
}