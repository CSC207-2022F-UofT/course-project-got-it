package entities;

import org.junit.jupiter.api.Test;

import java.util.Objects;

class RequestUnitTest {

    @Test
    void createNewRequest_withSingleItemList() {
        String[] items = new String[]{"laptop"};
        Request request = new Request(items, "13 inch MacBook Pro in room 2200",
            "40 St George St.", "3359 Mississauga Rd.",
            "Leave at the door.");

        assert request.getItems() == items;
        assert Objects.equals(request.getItemNotes(), "13 inch MacBook Pro in room 2200");
        assert Objects.equals(request.getItemAddress(), "40 St George St.");
        assert Objects.equals(request.getDeliveryAddress(), "3359 Mississauga Rd.");
        assert Objects.equals(request.getDeliveryNotes(), "Leave at the door.");

    }
    @Test
    void createNewRequest_withMultiItemList() {
        String[] items = new String[]{"laptop", "notebook", "calculator"};
        Request itemsRequest = new Request(items, "13 inch MacBook Pro in room 2200, blue notebook, and black " +
                "scientific calculator", "40 St George St.", "3359 Mississauga Rd.",
                "Leave all items at the door.");

        assert itemsRequest.getItems() == items;
        assert Objects.equals(itemsRequest.getItemNotes(), "13 inch MacBook Pro in room 2200, blue notebook, and black scientific " +
                "calculator");
        assert Objects.equals(itemsRequest.getItemAddress(), "40 St George St.");
        assert Objects.equals(itemsRequest.getDeliveryAddress(), "3359 Mississauga Rd.");
        assert Objects.equals(itemsRequest.getDeliveryNotes(), "Leave all items at the door.");


    }
}