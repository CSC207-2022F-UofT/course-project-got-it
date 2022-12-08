package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Profile_Window extends JFrame implements ActionListener {
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final Canvas Background;
    private final JTextField Name;
    private final JTextField Address;
    private final JTextField Email;
    private final JPasswordField Password;
    private final JButton Back;
    private final JButton Save;
    private final JLayeredPane LP;
    private final User U;
    private final GI_Server Server;
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
    public User_Profile_Window(String n0, String a0, String User_Email, String User_Password, User u, GI_Server S0){
        // For questions regarding constructor parameters please see below.
        assert User_Email != null;
        assert User_Password != null;
        // Since the user already logged in our program and had input their email and password
        // I assume that we keep track of the userEmail and password in order to show
        this.Server = S0;
        // such info on the screen. #PC_01.
        this.U = u;
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 35));
                g.setColor(Color.BLACK);
                g.drawString("User Profile", 23, 50);
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Name", 50, 100);
                g.drawString("Address", 50, 181);
                g.drawString("Email", 50, 261);
                g.drawString("Password", 50, 342);
            }
        };
        Background.setBounds(0, 0, 400, 500);
        Background.setBackground(Color.pink);
        this.setTitle("User_Profile.");
        this.setResizable(false);
//        this.setLocationRelativeTo(null);
        this.setLocation(630, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.requestFocus(true);
        this.setSize(400, 500);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 400, 500);
        this.Name = new JTextField();
        Name.setBounds(50, 115, 300, 35);
        Name.setOpaque(true);
        Name.setBackground(Color.WHITE);
        this.Address = new JTextField();
        Address.setBounds(50, 196, 300, 35);
        Address.setOpaque(true);
        Address.setBackground(Color.WHITE);
        this.Email = new JTextField();
        Email.setBounds(50, 277, 300, 35);
        Email.setOpaque(true);
        Email.setBackground(Color.WHITE);
        this.Password = new JPasswordField();
        Password.setBounds(50, 358, 300, 35);
        Password.setOpaque(true);
        Password.setBackground(Color.WHITE);
        this.Back = new JButton("Back");
        Back.setBounds(31, 421, 71, 41);
        Back.setOpaque(true);
        Back.setBackground(Color.pink);
        Back.addActionListener(this);
        LP.add(Back, Integer.valueOf(0));
        this.Save = new JButton("Save");
        Save.setBounds(300, 421, 71, 41);
        Save.setOpaque(true);
        Save.setBackground(Color.pink);
        Save.addActionListener(this);
        LP.add(Save, Integer.valueOf(0));
        LP.add(Password, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Address, Integer.valueOf(0));
        LP.add(Name, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        Name.setText(n0);
        Address.setText(a0);
        Email.setText(User_Email);
        Password.setText(User_Password);
        this.add(LP);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        // TODO: Implement this method so buttons can work correctly. #PC_01.
        if(e.getSource() == this.Save){
            String new_Name = this.Name.getText();
            String new_Address = this.Address.getText();
            String new_GI_KEY = this.Email.getText();
            String new_PASS = String.valueOf(this.Password.getPassword());
            U.setName(new_Name);
            U.setAddress(new_Address);
            U.set_GI_KEY(new_GI_KEY);
            U.setGI_PASSWORD(new_PASS);
            this.Name.setText(U.getName());
            this.Address.setText(U.getAddress());
            this.Email.setText(U.getGI_KEY());
            this.Password.setText(U.getGI_PASSWORD());
        }else{
            assert e.getSource() == this.Back;
            this.setVisible(false);
            new HOME_WINDOW(this.Server, this.U);
        }
    }
//    public static void main(String[] args) {
//        new User_Profile_Window("PC_TEXT_01.", "User_Password", "", "");
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
}
