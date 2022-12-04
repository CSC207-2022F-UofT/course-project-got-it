package MakeRequestUseCase;

import java.util.ArrayList;
import java.util.List;

public class RequestRequest {

    private String req_loc, item_loc, description, requester, deliveryNotes, itemName;
    public RequestRequest(String itemName, String req_loc, String item_loc, String description, String requester, String deliveryNotes){
        this.req_loc = req_loc;
        this.itemName = itemName
        this.item_loc = item_loc;
        this.description = description;
        this.requester = requester;
        this.deliveryNotes = deliveryNotes;
    }

    public List<String> inputs(){
        List<String> inputs = new ArrayList<>();
        inputs.add(this.req_loc);
        inputs.add(this.item_loc);
        inputs.add(this.requester);
        inputs.add(this.description);
        return inputs;
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

    public String getRequester() {
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
