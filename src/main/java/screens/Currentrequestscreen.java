package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * JFrame for current request screen where the app shows the current request made by the user to the user
 */
public class Currentrequestscreen extends JFrame implements ActionListener, Backable, Screen{
    private UserResponseController backController;
    private DeliveryController controller;
    private final Canvas Background;
    private final JLayeredPane LP;
    private final JTextField Item_Name;
    private final JTextField Item_Description;
    private final JTextField Item_Location;
    private final JTextField Delivery_Location;
    private final JTextField Driver;
    private final JButton Deliverytime;
    private final JButton Back;
    public void f0(){
        // Please ignore this method. #PC_01.
        this.Background.setBackground(Color.BLACK);
        this.LP.setBackground(Color.WHITE);
        this.Item_Name.setBackground(Color.black);
        this.Item_Description.setBackground(Color.BLACK);
        this.Item_Location.setBackground(Color.BLACK);
        this.Delivery_Location.setBackground(Color.black);
        this.Driver.setBackground(Color.pink);
        this.Back.setBackground(Color.BLUE);
        this.Deliverytime.setBackground(Color.BLUE);
    }

    public Currentrequestscreen(String Item_Name_0, String Item_description_0
            , String Item_Location_0, String Delivery_Location_0, String Driver_0){
        this.Background = new Canvas(){
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 29));
                g.drawString("Item Name:", 29, 60);
                g.drawString("Item Description:", 29, 120);
                g.drawString("Item Location:", 29, 180);
                g.drawString("Delivery Location:", 29, 240);
                g.drawString("Driver:", 29, 300);

            }
        };
        Background.setBackground(Color.pink);
        Background.setSize(600, 550);
        this.Item_Name = new JTextField();
        Item_Name.setBounds(210, 32, 290, 39);
        Item_Name.setOpaque(true);
        Item_Name.setEditable(false);
        this.Item_Description = new JTextField();
        Item_Description.setBounds(330, 90, 260, 39);
        Item_Description.setOpaque(true);
        Item_Description.setEditable(false);
        this.Item_Location = new JTextField();
        Item_Location.setBounds(280, 150, 280, 39);
        Item_Location.setOpaque(true);
        Item_Location.setEditable(false);
        this.Delivery_Location = new JTextField();
        Delivery_Location.setBounds(340, 210, 250, 39);
        Delivery_Location.setOpaque(true);
        Delivery_Location.setEditable(false);
        this.Driver = new JTextField();
        Driver.setBounds(155, 270, 250, 39);
        Driver.setOpaque(true);
        Driver.setEditable(false);
        this.Back = new JButton("Back");
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        Back.setBounds(260, 400, 90, 41);
        this.Back.setActionCommand("back");
        this.Deliverytime = new JButton("Time of Delivery");
        Deliverytime.setOpaque(true);
        Deliverytime.setBackground(Color.pink);
        Deliverytime.setBounds(210, 350, 200, 41);
        this.Deliverytime.setActionCommand("time");
        this.LP = new JLayeredPane();
        this.LP.setSize(600, 600);
        Delivery_Location.setText(Delivery_Location_0);
        Driver.setText(Driver_0);
        Item_Name.setText(Item_Name_0);
        Item_Description.setText(Item_description_0);
        Item_Location.setText(Item_Location_0);
        LP.add(Back);
        LP.add(Deliverytime);
        LP.add(Driver, Integer.valueOf(0));
        LP.add(Delivery_Location, Integer.valueOf(0));
        LP.add(Item_Location, Integer.valueOf(0));
        LP.add(Item_Name, Integer.valueOf(0));
        LP.add(Item_Description, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,550);
        this.add(LP);
//        LP.add();

        this.setVisible(true);
        Back.addActionListener(this);
        Deliverytime.addActionListener(this);
    }



    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "time")) {
            this.controller.request();
        }
        if(Objects.equals(e.getActionCommand(), "back")) {
            this.backController.goBack();
        }
    }
    @Override
    public void setBackController(UserResponseController backController){
        this.backController = backController;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (DeliveryController) controller;

    }
}