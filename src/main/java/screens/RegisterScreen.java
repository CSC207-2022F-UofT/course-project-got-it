package screens;

import RegisterUseCase.RegisterRequest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class RegisterScreen extends JFrame implements ActionListener, Screen {

    private RegisterController controller;

    private final Canvas Background;
    private final JTextField Email;
    private final JTextField Name;
    private final JTextField Longitude;
    private final JTextField Latitude;
    private final JPasswordField Password_0;
    private final JPasswordField Password_1;
    private final JButton Sign_Up;
    private final JLayeredPane LP;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Name.setOpaque(true);
        this.Latitude.setOpaque(true);
        this.Longitude.setOpaque(true);
        this.Email.setOpaque(true);
        this.Password_0.setOpaque(true);
        this.Password_1.setOpaque(true);
    }
    public RegisterScreen(){
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                Graphics2D G = (Graphics2D) g;
                g.setFont(new Font("Monaco", Font.BOLD, 40));
                g.drawString("Register", 5, 50);
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Name", 80, 100);
                g.drawString("Longitude", 80, 170);
                g.drawString("Latitude", 80, 240);
                g.drawString("Email", 80, 310);
                g.drawString("Password", 80, 380);
                g.drawString("Re-Enter Password", 80, 450);
            }
        };
        Background.setBackground(new Color(255,192,203));
        Background.setBounds(0, 0, 450, 400);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 450, 610);
        LP.setOpaque(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.requestFocus(true);
        this.setSize(450, 400);
        this.Name = new JTextField();
        Name.setBounds(80, 110, 265, 30);
        Name.setOpaque(true);
        Name.setBackground(new Color(255, 255, 255));
        this.Longitude = new JPasswordField();
        Longitude.setBounds(80, 180, 265, 30);
        Longitude.setOpaque(true);
        Longitude.setBackground(new Color(255, 255, 255));
        this.Latitude = new JPasswordField();
        Latitude.setBounds(80, 250, 265, 30);
        Latitude.setOpaque(true);
        Latitude.setBackground(new Color(255, 255, 255));
        this.Email = new JTextField();
        Email.setBounds(80, 320, 265, 30);
        Email.setOpaque(true);
        Email.setBackground(new Color(255, 255, 255));
        this.Password_0 = new JPasswordField();
        Password_0.setBounds(80, 390, 265, 30);
        Password_0.setOpaque(true);
        Password_0.setBackground(new Color(255, 255, 255));
        this.Password_1 = new JPasswordField();
        Password_1.setBounds(80, 460, 265, 30);
        Password_1.setOpaque(true);
        Password_1.setBackground(new Color(255, 255, 255));


        this.Sign_Up = new JButton("Sign Up");
        Sign_Up.setOpaque(true);
        Sign_Up.setBackground(new Color(255,192,203));
        Sign_Up.setBounds(300, 510, 90, 40);
        LP.add(Sign_Up ,Integer.valueOf(0));
        LP.add(Password_1, Integer.valueOf(0));
        LP.add(Password_0, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Name, Integer.valueOf(0));
        LP.add(Longitude, Integer.valueOf(0));
        LP.add(Latitude, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        try {
            double[] coords = {Integer.parseInt(this.Longitude.getText()), Integer.parseInt(this.Latitude.getText())};
            this.controller.create(this.Name.getText(),coords, this.Email.getText(), Arrays.toString(this.Password_0.getPassword()), Arrays.toString(this.Password_1.getPassword()));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RegisterController) controller;
    }
}
