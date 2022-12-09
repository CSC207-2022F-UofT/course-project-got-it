package DeliveryUseCase;

import entities.User;

public class DeliveryRequest {

    private final User user;

    public DeliveryRequest(User currentUser){
        this.user = currentUser;
    }

    public User getUser(){
        return this.user;
    }

}