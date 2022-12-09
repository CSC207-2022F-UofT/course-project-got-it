package screens;
/**
 * JFrame for login screen where the user can login
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginScreen extends JFrame implements ActionListener, Screen {

    private LoginController controller;
    private final JButton Sign_Up;
    private final JButton Log_In;
    private final JLayeredPane LP;
    private final Canvas BackGround;
    private final JTextField Email;
    private final JPasswordField Password;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.Log_In.setOpaque(true);
        this.LP.setOpaque(true);
        this.BackGround.setSize(0, 0);
        this.Email.setOpaque(true);
        this.Password.setOpaque(true);
    }
    public LoginScreen(){
        this.setTitle("Log_In_Screen");
        this.setSize(450, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.BackGround = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 40));
                g.setColor(Color.BLACK);
                g.drawString("Welcome to Got It.", 20, 60);
                Graphics2D G = (Graphics2D) g;
                G.setStroke(new BasicStroke(5));
                G.drawRect(25, 100, 400, 270);
                g.setFont(new Font("Monaco", Font.BOLD, 20));
                g.drawString("Username", 70, 130);
                g.drawString("Password", 70, 220);
            }
        };
        BackGround.setBackground(Color.pink);
        BackGround.setBounds(0, 0, 450, 450);
        this.Email = new JTextField();
        this.Password = new JPasswordField();
        this.LP = new JLayeredPane();
        this.Sign_Up = new JButton("Sign Up");
        this.Sign_Up.setActionCommand("signup");
        this.Log_In = new JButton("Log In");
        this.Log_In.setActionCommand("login");
        Email.setBounds(70, 140, 290, 35);
        Email.setOpaque(true);
        Email.setBackground(Color.WHITE);
        Password.setBounds(70, 230, 290, 35);
        Password.setOpaque(true);
        Password.setBackground(Color.WHITE);
        Sign_Up.setBounds(55, 320, 90, 25);
        Sign_Up.setOpaque(true);
        Sign_Up.setBackground(Color.pink);
        Log_In.setBounds(265, 320, 90, 25);
        Log_In.setOpaque(true);
        Log_In.setBackground(Color.pink);
        LP.add(Email, Integer.valueOf(0));
        LP.add(Password, Integer.valueOf(0));
        LP.add(Sign_Up, Integer.valueOf(0));
        LP.add(Log_In, Integer.valueOf(0));
        LP.add(BackGround, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);

        Sign_Up.addActionListener(this);
        Log_In.addActionListener(this);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (LoginController) controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getActionCommand() == "login"){
                this.controller.login(this.Email.getText(), Arrays.toString(this.Password.getPassword()));
            }
            if(e.getActionCommand() == "signup"){
                this.controller.navigateSignup();
            }
        }catch(Exception loginException){
            JOptionPane.showMessageDialog(this, loginException.getMessage());
        }
    }

}
