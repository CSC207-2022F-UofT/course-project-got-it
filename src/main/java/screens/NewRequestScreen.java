package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * JFrame for the new request screen where the user can make a request for an item
 */
public class NewRequestScreen extends JFrame implements ActionListener, Screen, Backable{
    private RequestController controller;
    private UserResponseController backController;

    private final Canvas Background;
    private final JTextField Item_Name;
    private final JTextField Item_Location;
    private final JTextField Delivery_Location;
    private final JTextField Item_Description;
    private final JTextField Delivery_Description;
    private final JButton Back;
    private final JButton Create;
    private final JLayeredPane LP;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Item_Description.setOpaque(true);
        this.Item_Location.setOpaque(true);
        this.Item_Name.setOpaque(true);
        this.Back.setOpaque(true);
        this.Create.setOpaque(true);
        this.Delivery_Location.setOpaque(true);
        this.Delivery_Description.setOpaque(true);
    }
    public NewRequestScreen() {
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 30));
                g.setColor(Color.BLACK);
                g.drawString("New Request. ", 9, 35);
                g.setFont(new Font("Monaco", Font.BOLD, 20));
                g.drawString("Item Name", 30, 65);
                g.drawString("Item Location", 30, 129);
                g.drawString("Delivery Location", 30, 194);
                g.drawString("Delivery Description", 30, 259);
                g.drawString("Item Description", 30, 347);
            }
        };
        Background.setBounds(0, 0, 300, 600);
        Background.setBackground(Color.pink);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 600);
        this.setTitle("New_Request.");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.requestFocus(true);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 300, 600);
        this.Item_Name = new JTextField();
        Item_Name.setBounds(30, 75, 241, 30);
        Item_Name.setOpaque(true);
        Item_Name.setBackground(Color.white);
        this.Item_Location = new JTextField();
        Item_Location.setBounds(30, 140, 241, 30);
        Item_Location.setOpaque(true);
        Item_Location.setBackground(Color.white);
        this.Delivery_Location = new JTextField();
        Delivery_Location.setBounds(30, 205, 241, 30);
        Delivery_Location.setOpaque(true);
        Delivery_Location.setBackground(Color.white);
        this.Delivery_Description = new JTextField();
        Delivery_Description.setBounds(30, 270, 241, 60);
        Delivery_Description.setOpaque(true);
        Delivery_Description.setBackground(Color.white);
        this.Item_Description = new JTextField();
        Item_Description.setBounds(30, 355, 241, 60);
        Item_Description.setOpaque(true);
        Item_Description.setBackground(Color.white);
        this.Back = new JButton("Back");
        this.Back.setActionCommand("back");
        Back.setBounds(10, 435, 75, 25);
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        this.Create = new JButton("Create");
        this.Create.setActionCommand("create");
        Create.setBounds(215, 435, 75, 25);
        Create.setOpaque(true);
        Create.setBackground(Color.pink);
        LP.add(Create, Integer.valueOf(0));
        LP.add(Back, Integer.valueOf(0));
        LP.add(Item_Description, Integer.valueOf(0));
        LP.add(Delivery_Location, Integer.valueOf(0));
        LP.add(Delivery_Description, Integer.valueOf(0));
        LP.add(Item_Location, Integer.valueOf(0));
        LP.add(Item_Name, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);

        Create.addActionListener(this);
        Back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(Objects.equals(e.getActionCommand(), "create")){
                this.controller.request(this.Item_Name.getText(), this.Delivery_Location.getText(), this.Item_Location.getText(),
                        this.Item_Description.getText(), this.Delivery_Description.getText());
            }
            if(Objects.equals(e.getActionCommand(), "back")) {
                this.backController.goBack();
            }

    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RequestController) controller;
    }

    @Override
    public void setBackController(UserResponseController backController){
        this.backController = backController;
    }
}