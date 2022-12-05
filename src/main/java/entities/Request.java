package entities;

// Entity layer

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Request {

    private final String itemName;
    private final String itemDescription;
    private final Double[] itemAddress;
    private final Double[] deliveryAddress;
    private final String deliveryNotes;

    public Request(String itemName, String itemDescription, Double[] itemAddress, Double[] deliveryAddress,
            String deliveryNotes) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemAddress = itemAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryNotes = deliveryNotes;
    }

    public Object[] getDetails(){
        return new Object[]{this.itemName, this.itemDescription, this.itemAddress, this.deliveryAddress, this.deliveryNotes};
    }

    public String getItemName() {
        return itemName;
    }
    public String getitemDescription() { return itemDescription; }
    public Double[] getItemAddress() { return itemAddress; }
    public Double[] getDeliveryAddress() { return deliveryAddress; }
    public String getDeliveryNotes() {
        return deliveryNotes;
    }

}
