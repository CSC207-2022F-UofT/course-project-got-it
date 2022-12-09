package screens;

/**
 * JFrame for Homescreen
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Homescreen extends JFrame implements ActionListener, Screen {

    private HomescreenController controller;
    private final Canvas Background;
    private final JButton Profile;
    private final JButton New_Request;
    private final JButton Past_Request;
    private final JButton Current_Request;
    private final JLayeredPane LP;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Profile.setOpaque(true);
        this.New_Request.setOpaque(true);
        this.Past_Request.setOpaque(true);
        this.Current_Request.setOpaque(true);
    }
    public Homescreen() {
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 30));
                g.setColor(Color.BLACK);
                g.drawString("Welcome to Got It. ", 20, 40);
            }
        };
        this.Background.setBounds(0, 0, 620, 350);
        this.Background.setBackground(Color.pink);
        this.setTitle("GOT_IT.");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.requestFocus(true);
        this.setSize(620, 350);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 500, 300);
        this.Profile = new JButton("Profile");
        Profile.setBounds(50, 85, 130, 130);
        Profile.setOpaque(true);
        Profile.setBackground(Color.pink);
        Profile.setActionCommand("navigateProfile");
        this.New_Request = new JButton("New Request");
        New_Request.setBounds(180, 85, 130, 130);
        New_Request.setOpaque(true);
        New_Request.setBackground(Color.pink);
        New_Request.setActionCommand("navigateNewrequest");
        this.Past_Request = new JButton("Past Requests");
        Past_Request.setBounds(310, 85, 130, 130);
        Past_Request.setOpaque(true);
        Past_Request.setBackground(Color.pink);
        Past_Request.setActionCommand("navigatePastrequests");
        this.Current_Request = new JButton("Current Request");
        Current_Request.setBounds(440, 85, 130, 130);
        Current_Request.setOpaque(true);
        Current_Request.setBackground(Color.pink);
        Current_Request.setActionCommand("navigateCurrentrequests");

        LP.add(Current_Request, Integer.valueOf(0));
        LP.add(Past_Request, Integer.valueOf(0));
        LP.add(New_Request, Integer.valueOf(0));
        LP.add(Profile, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);


        Profile.addActionListener(this);
        New_Request.addActionListener(this);
        Past_Request.addActionListener(this);
        Current_Request.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.navigate(e.getActionCommand());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (HomescreenController) controller;
    }



}

