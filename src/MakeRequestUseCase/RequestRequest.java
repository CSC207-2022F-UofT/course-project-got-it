package MakeRequestUseCase;

public class RequestRequest {

    private String req_loc, item_loc, description, requester;
    public RequestRequest(String req_loc, String item_loc, String description, String requester){
        this.req_loc = req_loc;
        this.item_loc = item_loc;
        this.description = description;
        this.requester = requester;
    }

    public List[String] inputs(){
        return [req_loc, requester, item_loc, description]
    }

    public void setRequester(String requester) {
        this.req_loc = requester;
    }

    public String getRequester() {
        return requester;
    }

    public String setItem_loc(String item_loc) {
        return item_loc;
    }

    public void getItem_loc() {
        this.item_loc = item_loc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return email;
    }

    public void setReq_loc(String req_loc) {
        this.req_loc = req_loc;
    }

    public String getReq_loc() {
        return req_loc;
    }
}