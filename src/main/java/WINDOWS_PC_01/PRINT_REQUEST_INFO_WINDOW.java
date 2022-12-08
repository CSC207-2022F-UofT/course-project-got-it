package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PRINT_REQUEST_INFO_WINDOW extends JFrame implements ActionListener {
    private final Canvas Background;
    private final JLayeredPane LP;
    private final JTextField Item_Name;
    private final JTextField Item_Description;
    private final JTextField Item_Location;
    private final JTextField Delivery_Location;
    private final JTextField Driver;
    private final JTextField Delivery_Status;
    private final JTextField Time_Of_Delivery;
    private final JButton Back;
    private final GI_Server Server;
    private final User U;
    private final Request R0;
    private final JButton Received;
    public void f0(){
        // Please ignore this method. #PC_01.
        this.Background.setBackground(Color.BLACK);
        this.LP.setBackground(Color.WHITE);
        this.Item_Name.setBackground(Color.black);
        this.Item_Description.setBackground(Color.BLACK);
        this.Item_Location.setBackground(Color.BLACK);
        this.Delivery_Location.setBackground(Color.black);
        this.Driver.setBackground(Color.pink);
        this.Delivery_Status.setBackground(Color.BLACK);
        this.Time_Of_Delivery.setBackground(Color.BLUE);
        this.Back.setBackground(Color.BLUE);
    }
    //TODO: Pass parameters in the order below so the window can display the info.
    public PRINT_REQUEST_INFO_WINDOW(GI_Server S0, User U, Request r0){
        this.Server = S0;
        this.U = U;
        this.R0 = r0;
        this.Background = new Canvas(){
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 29));
                g.drawString("Item Name:", 29, 60);
                g.drawString("Item Description:", 29, 120);
                g.drawString("Item Location:", 29, 180);
                g.drawString("Delivery Location:", 29, 240);
                g.drawString("Driver:", 29, 300);
                g.drawString("Delivery Status:", 29, 360);
                g.drawString("Time of Delivery:", 29, 420);
            }
        };
        this.setLocation(630, 300);
        Background.setBackground(Color.pink);
        Background.setSize(600, 600);
        this.Item_Name = new JTextField();
        Item_Name.setBounds(210, 32, 290, 39);
        Item_Name.setOpaque(true);
        this.Item_Description = new JTextField();
        Item_Description.setBounds(330, 90, 260, 39);
        Item_Description.setOpaque(true);
        this.Item_Location = new JTextField();
        Item_Location.setBounds(280, 150, 280, 39);
        Item_Location.setOpaque(true);
        this.Delivery_Location = new JTextField();
        Delivery_Location.setBounds(340, 210, 250, 39);
        Delivery_Location.setOpaque(true);
        this.Driver = new JTextField();
        Driver.setBounds(155, 270, 250, 39);
        Driver.setOpaque(true);
        this.Delivery_Status = new JTextField();
        Delivery_Status.setBounds(305, 330, 280, 39);
        Delivery_Status.setOpaque(true);
        this.Back = new JButton("Back");
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        Back.setBounds(260, 500, 90, 41);
        Back.addActionListener(this);
        this.LP = new JLayeredPane();
        this.LP.setSize(600, 600);
        this.Time_Of_Delivery = new JTextField();
        Time_Of_Delivery.setBounds(320, 390, 270, 39);
        Time_Of_Delivery.setOpaque(true);
        this.Received = new JButton("I receive it. ");
        if(!R0.Arrived){
            Received.setOpaque(true);
            Received.setBackground(Color.pink);
            Received.setBounds(430, 500, 90, 41);
            Received.addActionListener(this);
            LP.add(Received, Integer.valueOf(0));
        }
        LP.add(Back);
        LP.add(Time_Of_Delivery);
        LP.add(Delivery_Status, Integer.valueOf(0));
        LP.add(Driver, Integer.valueOf(0));
        LP.add(Delivery_Location, Integer.valueOf(0));
        LP.add(Item_Location, Integer.valueOf(0));
        LP.add(Item_Name, Integer.valueOf(0));
        LP.add(Item_Description, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.add(LP);
//        LP.add();
        Delivery_Location.setText(R0.getDelivery_Location());
        Delivery_Location.setEnabled(false);
        Driver.setText(R0.get_Driver().getName());
        Driver.setEnabled(false);
        if(R0.Arrived){
            Delivery_Status.setText("Arrived.");
        }else{
            Delivery_Status.setText("Delivering.");
        }
        Delivery_Status.setEnabled(false);
        Item_Name.setText(R0.getItem_Name());
        Item_Name.setEnabled(false);
        Item_Description.setText(R0.getItem_Description());
        Item_Description.setEnabled(false);
        Item_Location.setText(R0.getItem_Location());
        Item_Location.setEnabled(false);
        Time_Of_Delivery.setText(R0.getTime() + " minute(s)");
        Time_Of_Delivery.setEnabled(false);
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Implement this method so buttons would work.
        if(e.getSource() == this.Back){
            this.setVisible(false);
            new HOME_WINDOW(this.Server, this.U);
        }else {
            assert e.getSource() == this.Received;
            this.R0.setArrived(true);
            this.setVisible(false);
            new HOME_WINDOW(this.Server, this.U);
        }
    }
}
