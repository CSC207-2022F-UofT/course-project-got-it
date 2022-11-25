package useCases;

import entities.Request;

import java.util.ArrayList;

public class GenerateNewRequest {
    Request request = new Request();

    /**
     * Holds the items within the string array
     * @param items
     */
    public void userItems(ArrayList<String> items) {
        request.setItems(items);
    }

    /**
     * Holds the user's address
     * @param address
     */
    public void userAddress(String address) {
        request.setDeliveryAddress(address);
    }

}
