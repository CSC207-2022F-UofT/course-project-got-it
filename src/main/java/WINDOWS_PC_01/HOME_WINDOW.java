package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HOME_WINDOW extends JFrame implements ActionListener{
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final Canvas Background;
    private final JButton Profile;
    private final JButton New_Request;
    private final JButton Past_Request;
    private final JLayeredPane LP;
    private final GI_Server Server;
    private final User U;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Profile.setOpaque(true);
        this.New_Request.setOpaque(true);
        this.Past_Request.setOpaque(true);
    }
    public HOME_WINDOW(GI_Server S0, User u){
        this.U = u;
        this.Server = S0;
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 30));
                g.setColor(Color.BLACK);
                g.drawString("Welcome to Got It. ", 20, 40);
            }
        };
        this.Background.setBounds(0, 0, 500, 300);
        this.Background.setBackground(Color.pink);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("GOT_IT.");
        this.setLocationRelativeTo(null);
        this.setLocation(630, 300);
        this.setResizable(false);
        this.requestFocus(true);
        this.setSize(500, 300);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 500, 300);
        this.Profile = new JButton("Profile");
        Profile.setBounds(50, 85, 130, 130);
        Profile.setOpaque(true);
        Profile.setBackground(Color.pink);
        Profile.addActionListener(this);
        this.New_Request = new JButton("New Request");
        New_Request.setBounds(180, 85, 130, 130);
        New_Request.setOpaque(true);
        New_Request.setBackground(Color.pink);
        New_Request.addActionListener(this);
        this.Past_Request = new JButton("Past Request");
        Past_Request.setBounds(310, 85, 130, 130);
        Past_Request.setOpaque(true);
        Past_Request.setBackground(Color.pink);
        Past_Request.addActionListener(this);
        LP.add(Past_Request, Integer.valueOf(0));
        LP.add(New_Request, Integer.valueOf(0));
        LP.add(Profile, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement this method so buttons can work correctly. #PC_01.
        if(e.getSource() == this.Profile){
            this.setVisible(false);
            String Name = this.U.getName();
            String Address = this.U.getAddress();
            String Email = this.U.getGI_KEY();
            String Pass = this.U.getGI_PASSWORD();
            new User_Profile_Window(Name, Address, Email, Pass, this.U, this.Server);
        }else if(e.getSource() == this.New_Request){
            this.setVisible(false);
            new NEW_REQUEST_WINDOW(this.Server, this.U);
        }else{
            assert e.getSource() == this.Past_Request;
            ArrayList<Request> l0 = this.U.get_Three_Past_Requests();
            this.setVisible(false);
            new PAST_REQUEST_WINDOW(this.Server, this.U, l0);
        }
    }
//    public static void main(String[] args) {
//        new HOME_WINDOW();
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
}
