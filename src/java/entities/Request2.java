package entities;

import java.awt.*;
import java.util.ArrayList;
public class Request2 {

    private ArrayList<String> items;
    private Point address;

    Request2(ArrayList<String> items, Point address) {
        this.items = items;
        this.address = address;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public Point getAddress() {
        return address;
    }
}