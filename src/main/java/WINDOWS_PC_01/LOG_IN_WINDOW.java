package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LOG_IN_WINDOW extends JFrame implements ActionListener {
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final JButton Sign_Up;
    private final JButton Log_In;
    private final JLayeredPane LP;
    private final Canvas BackGround;
    private final JTextField Email;
    private final JPasswordField Password;
    public final GI_Server Server;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.Log_In.setOpaque(true);
        this.LP.setOpaque(true);
        this.BackGround.setSize(0, 0);
        this.Email.setOpaque(true);
        this.Password.setOpaque(true);
    }
    public LOG_IN_WINDOW(GI_Server S){
        this.Server = S;
        this.setTitle("Log_In_Window");
        this.setSize(450, 450);
        this.setResizable(false);
//        this.setLocationRelativeTo(null);
        this.setLocation(630, 300);
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
                g.drawString("Email", 70, 130);
                g.drawString("Password", 70, 220);
            }
        };
        BackGround.setBackground(Color.pink);
        BackGround.setBounds(0, 0, 450, 450);
        this.Email = new JTextField();
        this.Password = new JPasswordField();
        this.LP = new JLayeredPane();
        this.Sign_Up = new JButton("Sign_Up");
        this.Sign_Up.addActionListener(this);
        this.Log_In = new JButton("Log_In");
        this.Log_In.addActionListener(this);
        Email.setBounds(70, 140, 290, 35);
        Email.setOpaque(true);
        Email.setBackground(Color.WHITE);
        Password.setBounds(70, 230, 290, 35);
        Password.setOpaque(true);
        Password.setBackground(Color.WHITE);
        Sign_Up.setBounds(55, 320, 90, 25);
        Sign_Up.setOpaque(true);
        Sign_Up.setBackground(Color.pink);
        Log_In.setBounds(165, 300, 135, 45);
        Log_In.setOpaque(true);
        Log_In.setBackground(Color.pink);
        LP.add(Email, Integer.valueOf(0));
        LP.add(Password, Integer.valueOf(0));
        LP.add(Sign_Up, Integer.valueOf(0));
        LP.add(Log_In, Integer.valueOf(0));
        LP.add(BackGround, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
//    Uncomment codes above and run it to see the window. #PC_01.
    @Override
    public void actionPerformed(ActionEvent e){
        // TODO: Implement this method so buttons can work correctly. #PC_01.
        if(e.getSource() == this.Log_In){
            String ID = this.Email.getText();
            String PASS = String.valueOf(this.Password.getPassword());
            if(this.Server.V0(ID, PASS)){
                this.setVisible(false);
                new HOME_WINDOW(this.Server, Server.r_User(ID, PASS));
            }else{
                new ERROR_WINDOW_NO_INFO();
            }
        }else if(e.getSource() == this.Sign_Up){
            this.setVisible(false);
            new REGISTER_WINDOW(this.Server);
        }
    }
    public static void main(String[] P0) {
        GI_Server S0 = new GI_Server();
        Driver d0 = new Driver("Bob", 10, 30, 48);
        Driver d1 = new Driver("Sam", 90, 320, 90);
        Driver d2 = new Driver("Bob", 3, -210, 82);
        Driver d3 = new Driver("Bob", 399, 210, 72);
        Driver d4 = new Driver("Bob", 20, 563, 57);
        S0.add_Driver(d0);
        S0.add_Driver(d1);
        S0.add_Driver(d2);
        S0.add_Driver(d3);
        S0.add_Driver(d4);
        new LOG_IN_WINDOW(S0);
    }
}