package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NEW_REQUEST_WINDOW extends JFrame implements ActionListener {
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final Canvas Background;
    private final JTextField Item_Name;
    private final JTextField Item_Location;
    private final JTextField Delivery_Location;
    private final JTextField Item_Description;
    private final JTextField User_X;
    private final JTextField User_Y;
    private final JButton Back;
    private final JButton Create;
    private final JLayeredPane LP;
    private final GI_Server Server;
    private final User U;
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
    }
    public NEW_REQUEST_WINDOW(GI_Server S0, User u){
        this.Server = S0;
        this.U = u;
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 30));
                g.setColor(Color.BLACK);
                g.drawString("New Request. ", 9, 35);
                g.setFont(new Font("Monaco", Font.BOLD, 20));
                g.drawString("Item Name.", 30, 65);
                g.drawString("X:", 161, 65);
                g.drawString("Y:", 225, 65);
                g.drawString("Item Name", 30, 65);
                g.drawString("Item Location", 30, 129);
                g.drawString("Delivery Location", 30, 194);
                g.drawString("Item Description", 30, 259);
            }
        };
        Background.setBounds(0, 0, 300, 400);
        Background.setBackground(Color.pink);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setTitle("New_Request.");
        this.setResizable(false);
        this.setLocation(630, 300);
        this.requestFocus(true);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 300, 400);
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
        this.Item_Description = new JTextField();
        Item_Description.setBounds(30, 270, 241, 60);
        Item_Description.setOpaque(true);
        Item_Description.setBackground(Color.white);
        this.User_X = new JTextField();
        User_X.setBounds(185, 41, 30, 30);
        User_X.setOpaque(true);
        User_X.setBackground(Color.white);
        this.User_Y = new JTextField();
        User_Y.setBounds(249, 41, 30, 30);
        User_Y.setOpaque(true);
        User_Y.setBackground(Color.white);
        this.Back = new JButton("Back");
        Back.setBounds(10, 340, 75, 25);
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        Back.addActionListener(this);
        this.Create = new JButton("Create");
        Create.setBounds(215, 340, 75, 25);
        Create.setOpaque(true);
        Create.setBackground(Color.pink);
        Create.addActionListener(this);
        LP.add(User_X, Integer.valueOf(0));
        LP.add(User_Y, Integer.valueOf(0));
        LP.add(Create, Integer.valueOf(0));
        LP.add(Back, Integer.valueOf(0));
        LP.add(Item_Description, Integer.valueOf(0));
        LP.add(Delivery_Location, Integer.valueOf(0));
        LP.add(Item_Location, Integer.valueOf(0));
        LP.add(Item_Name, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.Back){
            this.setVisible(false);
            new HOME_WINDOW(this.Server, this.U);
        }else{
            assert e.getSource() == this.Create;
            int x = Integer.parseInt(User_X.getText());
            int y = Integer.parseInt(User_Y.getText());
            this.U.setXY(x, y);
            Driver D = this.Server.find_Cloest_Driver(U);
            String I_Name = this.Item_Name.getText();
            String I_Location = this.Item_Location.getText();
            String Delivery_Location = this.Delivery_Location.getText();
            String I_Description = this.Item_Description.getText();
            int Time = this.Server.find_Time(U, D);
            Request R0 = new Request(U, D, I_Name, I_Location, Delivery_Location, I_Description, Time, false);
            this.U.addRequest(R0);
            this.setVisible(false);
            new PRINT_REQUEST_INFO_WINDOW(this.Server, this.U, R0);
        }
    }
//    public static void main(String[] P0) {
//        new NEW_REQUEST_WINDOW(new GI_Server(), new User("",""));
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
}
