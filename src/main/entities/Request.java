package entities;

// Entity layer

public class Request {

    private final String[] items;
    private final String itemNotes;
    private final String itemAddress;
    private final String deliveryAddress;
    private final String deliveryNotes;

    Request(String[] items, String itemNotes, String itemAddress, String deliveryAddress,
            String deliveryNotes) {
        this.items = items;
        this.itemNotes = itemNotes;
        this.itemAddress = itemAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryNotes = deliveryNotes;
    }

    public String[] getItems() {
        return items;
    }
    public String getItemNotes() { return itemNotes; }
    public String getItemAddress() { return itemAddress; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public String getDeliveryNotes() {
        return deliveryNotes;
    }

}
