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
    private final GI_Server Server;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Email.setOpaque(true);
        this.Password_0.setOpaque(true);
        this.Password_1.setOpaque(true);
    }
    public REGISTER_WINDOW(GI_Server S0){
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
        this.Server = S0;
        Background.setBackground(new Color(255,192,203));
        Background.setBounds(0, 0, 450, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 450, 400);
        LP.setOpaque(true);
//        this.setLocationRelativeTo(null);
        this.setLocation(630, 300);
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
        Sign_Up.addActionListener(this);
        LP.add(Sign_Up ,Integer.valueOf(0));
        LP.add(Password_1, Integer.valueOf(0));
        LP.add(Password_0, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
//    public static void main(String[] P0) {
//        new REGISTER_WINDOW(new GI_Server());
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement this method so buttons can work correctly. #PC_01.
        if(e.getSource() == this.Sign_Up){
            String ID = this.Email.getText();
            String Pass_0 = String.valueOf(this.Password_0.getPassword());
            String Pass_1 = String.valueOf(this.Password_1.getPassword());
            boolean is_Equal = Pass_0.equals(Pass_1);
            boolean is_Empty = ID.isEmpty() || Pass_0.isEmpty() || Pass_1.isEmpty();
            if(is_Equal && !is_Empty){
                this.Server.addUser(ID,Pass_0);
                this.setVisible(false);
                new LOG_IN_WINDOW(this.Server);
            }else{
                new ERROR_WINDOW();
            }
        }
    }
}
