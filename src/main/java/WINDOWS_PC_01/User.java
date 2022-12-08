package WINDOWS_PC_01;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private int x;
    private int y;
    private String GI_KEY;
    private String GI_PASSWORD;
    private String Name;
    private String Address;
    private ArrayList<Request> Requests = new ArrayList<Request>();
    public User(String ID, String Pass){
        this.GI_KEY = ID;
        this.GI_PASSWORD = Pass;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void addRequest(Request x){
        this.Requests.add(x);
    }
    public void setName(String name){
        this.Name = name;
    }
    public void setAddress(String x){
        this.Address = x;
    }
    public String getName(){
        return Objects.requireNonNullElse(this.Name, "Currently Empty.");
    }
    public String getAddress(){
        return Objects.requireNonNullElse(this.Address, "Currently Empty.");
    }
    public String getGI_PASSWORD(){
        return this.GI_PASSWORD;
    }
    public String getGI_KEY(){
        return this.GI_KEY;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void set_GI_KEY(String x){
        this.GI_KEY = x;
    }
    public void setGI_PASSWORD(String x){
        this.GI_PASSWORD = x;
    }
    public ArrayList<Request> get_Three_Past_Requests(){

        ArrayList<Request> l0 = new ArrayList<Request>();
        if(this.Requests.size() == 1){
            l0.add(this.Requests.get(0));
        }else if(this.Requests.size() == 2){
            l0.add(this.Requests.get(0));
            l0.add(this.Requests.get(1));
        }else if (this.Requests.size() == 3){
            l0.add(this.Requests.get(0));
            l0.add(this.Requests.get(1));
            l0.add(this.Requests.get(2));
        }
        return l0;
    }


}
