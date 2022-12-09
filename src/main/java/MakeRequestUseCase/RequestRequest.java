package MakeRequestUseCase;
// keep
import entities.User;

/**
 * Request to interactor to make a new request
 */
public class RequestRequest {

    private String req_loc, item_loc, description, deliveryNotes, itemName;
    private User requester;
    public RequestRequest(String itemName, String req_loc, String item_loc, String description,
                          String deliveryNotes, User requester){
        this.req_loc = req_loc;
        this.itemName = itemName;
        this.item_loc = item_loc;
        this.description = description;
        this.requester = requester;
        this.deliveryNotes = deliveryNotes;
    }

    public void setItemName(String name){
        this.itemName = name;
    }

    public String getItemName(){
        return this.itemName;
    }
    public void setRequester(String requester) {
        this.req_loc = requester;
    }

    public User getRequester() {
        return requester;
    }

    public String getItem_loc() {
        return item_loc;
    }

    public void setItem_loc(String item_loc) {
        this.item_loc = item_loc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setReq_loc(String req_loc) {
        this.req_loc = req_loc;
    }

    public String getReq_loc() {
        return req_loc;
    }

    public String getDeliveryNotes(){
        return this.deliveryNotes;
    }

    public void setDeliveryNotes(String newNotes){
        this.deliveryNotes = newNotes;
    }
}