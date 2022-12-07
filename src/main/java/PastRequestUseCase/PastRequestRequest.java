package PastRequestUseCase;

import entities.Request;
import entities.User;

import java.util.ArrayList;

public class PastRequestRequest {
    private User currentUser;
    public PastRequestRequest(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }
}

