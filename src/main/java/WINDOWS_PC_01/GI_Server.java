package WINDOWS_PC_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GI_Server {
    public ArrayList<User> Info = new ArrayList<User>();
    public ArrayList<Driver> Drivers = new ArrayList<Driver>();
    public boolean V0(String ID, String PASS){
        if (Info.size() == 0){
            return false;
        };
        for(User u: Info){
            if(u.getGI_KEY().equals(ID) && u.getGI_PASSWORD().equals(PASS)){
                return true;
            }
        }
        return false;
    }
    public void addUser(String ID, String PASS){
        this.Info.add(new User(ID, PASS));
    }
    public User r_User(String ID, String PASS){
        for (User u: Info){
            if(u.getGI_KEY().equals(ID) && u.getGI_PASSWORD().equals(PASS)){
                return u;
            }
        }
        return null;
    }
    public void add_Driver(Driver d){
        this.Drivers.add(d);
    }
    public Driver find_Cloest_Driver(User u){
        int User_x = u.getX();
        int User_y = u.getY();
        int r0 = 0;
        Driver r1 = null;
        for(Driver d: Drivers){
            int Driver_x = d.getX();
            int Driver_y = d.getY();
            if(r0 == 0){
                r0 = ((int)Math.pow(Driver_x - User_x, 2)) + ((int)Math.pow(Driver_y - User_y, 2));
                r1 = d;
            }else{
                int distance = ((int)Math.pow(Driver_x - User_x, 2)) + ((int)Math.pow(Driver_y - User_y, 2));
                if(distance < r0){
                    r0 = distance;
                    r1 = d;
                }
            }
        }
        return r1;
    }
    public int find_Time(User U, Driver D){
        int Driver_x = D.getX();
        int Driver_y = D.getY();
        int User_x = U.getX();
        int User_y = U.getY();
        int distance = (int)(Math.sqrt(Math.pow(Driver_x - User_x, 2))
                + Math.pow(Driver_y - User_y, 2));
        return distance / D.getSpeed();
    }

}
