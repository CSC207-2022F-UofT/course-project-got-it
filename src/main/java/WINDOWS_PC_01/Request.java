package WINDOWS_PC_01;

import javax.swing.*;

public class Request {
    private User u;
    private Driver d;
    private String Item_Name;
    private String Item_Location;
    private String Delivery_Location;
    private String Item_Description;
    private int Time;
    boolean Arrived;
    boolean Empty;
    public Request(User x, Driver y, String I_Name, String I_Location,
                   String Delivery_Location, String Item_Description,int T, boolean A){
        this.u = x;
        this.d = y;
        this.Item_Name = I_Name;
        this.Item_Location = I_Location;
        this.Delivery_Location = Delivery_Location;
        this.Item_Description = Item_Description;
        this.Time = T;
        this.Arrived = A;
    }
    public Request(){
        this.Empty = false;
    }
    public User get_User(){
        return this.u;
    }
    public Driver get_Driver(){
        return this.d;
    }
    public String getItem_Name(){
        return this.Item_Name;
    }
    public String getItem_Location(){
        return this.Item_Location;
    }
    public String getItem_Description(){
        return this.Item_Description;
    }
    public int getTime(){
        return this.Time;
    }
    public String getDelivery_Location(){
        return this.Delivery_Location;
    }
    public boolean is_Arrived(){
        return this.Arrived;
    }
    public void setArrived(boolean x){
        this.Arrived = x;
    }
}
