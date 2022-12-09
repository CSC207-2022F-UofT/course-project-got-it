package screens;

import entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * JFrame for profile screen which displays the user's name, address, password, and email, with the option to change information
 */
public class Profilescreen extends JFrame implements ActionListener, Screen, Backable{
    private ProfilescreenController controller;
    private UserResponseController backController;
    private final Canvas Background;
    private final JTextField Name;
    private final JTextField Address;
    private final JTextField Email;
    private final JPasswordField Password;
    private final JButton Back;
    private final JButton Save;
    private final JLayeredPane LP;
    public void f0(){
        // Please ignore this method. #PC_01.
        this.Background.setBackground(Color.BLACK);
        this.Name.setOpaque(true);
        this.Address.setOpaque(true);
        this.Email.setOpaque(true);
        this.Password.setOpaque(true);
        this.Back.setOpaque(true);
        this.Save.setOpaque(true);
        this.LP.setOpaque(true);
    }
    public Profilescreen(String userName, String address, String email, String password) {
        // For questions regarding constructor parameters please see below.
        //assert user != null;
        // Since the user already logged in our program and had input their email and password
        // I assume that we keep track of the userEmail and password in order to show
        // such info on the screen. #PC_01.
        this.Background = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.setFont(new Font("Monaco", Font.BOLD, 35));
                g.setColor(Color.BLACK);
                g.drawString("User Profile", 23, 50);
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Name", 50, 100);
                g.drawString("Username", 50, 181);
                g.drawString("Address", 50, 261);
                g.drawString("Password", 50, 342);
            }
        };
        Background.setBounds(0, 0, 400, 500);
        Background.setBackground(Color.pink);
        this.setTitle("User_Profile.");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.requestFocus(true);
        this.setSize(400, 500);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 400, 500);
        this.Name = new JTextField();
        Name.setBounds(50, 115, 300, 35);
        Name.setOpaque(true);
        Name.setBackground(Color.WHITE);
        this.Email = new JTextField();
        Email.setBounds(50, 196, 300, 35);
        Email.setOpaque(true);
        Email.setBackground(Color.WHITE);
        this.Address = new JTextField();
        Address.setBounds(50, 276, 300, 35);
        Address.setOpaque(true);
        Address.setBackground(Color.WHITE);
        this.Password = new JPasswordField();
        Password.setBounds(50, 358, 300, 35);
        Password.setOpaque(true);
        Password.setBackground(Color.WHITE);

        this.Back = new JButton("Back");
        Back.setBounds(31, 415, 71, 41);
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        this.Back.setActionCommand("back");
        this.Save = new JButton("Save");
        Save.setBounds(300, 415, 71, 41);
        Save.setOpaque(true);
        Save.setBackground(Color.pink);
        this.Save.setActionCommand("save");
        Name.setText(userName);
        Email.setText(email);
        Address.setText(address);

        LP.add(Back, Integer.valueOf(0));
        LP.add(Save, Integer.valueOf(0));
        LP.add(Address, Integer.valueOf(0));
        LP.add(Password, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Name, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
        Save.addActionListener(this);
        Back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "save")){
            String password = Arrays.toString(this.Password.getPassword());
            String email = this.Email.getText();
            String name = this.Name.getText();
            this.controller.change(name, email, password);
        }
        if(Objects.equals(e.getActionCommand(), "back")) {
            this.backController.goBack();
        }

    }

    @Override
    public void setController(Controller controller)  {
        this.controller = (ProfilescreenController) controller;
    }

    @Override
    public void setBackController(UserResponseController backController){
        this.backController = backController;
    }
}
