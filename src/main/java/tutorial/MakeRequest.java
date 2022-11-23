package useCases;

import entities.Request;

import java.util.ArrayList;

public class MakeRequest {

    Request request = new Request();

    public void makeRequest(ArrayList<String> items, String description) {
        request.setItems(items);
        request.setRequestDetails(description);
    }
}
