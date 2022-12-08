package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class REGISTER_WINDOW extends JFrame implements ActionListener {
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final Canvas Background;
    private final JTextField Email;
    private final JPasswordField Password_0;
    private final JPasswordField Password_1;
    private final JButton Sign_Up;
    private final JLayeredPane LP;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Email.setOpaque(true);
        this.Password_0.setOpaque(true);
        this.Password_1.setOpaque(true);
    }
    public REGISTER_WINDOW(){
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                Graphics2D G = (Graphics2D) g;
                g.setFont(new Font("Monaco", Font.BOLD, 40));
                g.drawString("Register", 5, 50);
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Email", 80, 100);
                g.drawString("Password", 80, 170);
                g.drawString("Re-Enter Password", 80, 240);
            }
        };
        Background.setBackground(new Color(255,192,203));
        Background.setBounds(0, 0, 450, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 450, 400);
        LP.setOpaque(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.requestFocus(true);
        this.setSize(450, 400);
        this.Email = new JTextField();
        Email.setBounds(80, 110, 265, 30);
        Email.setOpaque(true);
        Email.setBackground(new Color(255, 255, 255));
        this.Password_0 = new JPasswordField();
        Password_0.setBounds(80, 180, 265, 30);
        Password_0.setOpaque(true);
        Password_0.setBackground(new Color(255, 255, 255));
        this.Password_1 = new JPasswordField();
        Password_1.setBounds(80, 250, 265, 30);
        Password_1.setOpaque(true);
        Password_1.setBackground(new Color(255, 255, 255));
        this.Sign_Up = new JButton("Sign Up");
        Sign_Up.setOpaque(true);
        Sign_Up.setBackground(new Color(255,192,203));
        Sign_Up.setBounds(300, 300, 90, 40);
        LP.add(Sign_Up ,Integer.valueOf(0));
        LP.add(Password_1, Integer.valueOf(0));
        LP.add(Password_0, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
    public static void main(String[] P0) {
        new REGISTER_WINDOW();
    }
//    Uncomment codes above and run it to see the window. #PC_01.
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement this method so buttons can work correctly. #PC_01.
    }
}
