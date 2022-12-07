package entities;

// Entity layer

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Request {

    private final String itemName;
    private final String itemDescription;
    private final double[] itemAddress;
    private final double[] deliveryAddress;
    private final String deliveryNotes;
    private User requester;

    public Request(String itemName, String itemDescription, double[] itemAddress, double[] deliveryAddress,
                   String deliveryNotes, User requester) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemAddress = itemAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryNotes = deliveryNotes;
        this.requester = requester;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester){
        this.requester = requester;
    }

    public Object[] getDetails(){
        return new Object[]{this.itemName, this.itemDescription, this.itemAddress, this.deliveryAddress, this.deliveryNotes};
    }

    public String getItemName() {
        return itemName;
    }
    public String getitemDescription() { return itemDescription; }
    public double[] getItemAddress() { return itemAddress; }
    public double[] getDeliveryAddress() { return deliveryAddress; }
    public String getDeliveryNotes() {
        return deliveryNotes;
    }

}
