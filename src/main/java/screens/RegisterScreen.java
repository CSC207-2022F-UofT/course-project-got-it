package screens;

import RegisterUseCase.RegisterRequest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Objects;

/**
 * JFrame for register screen which displays registration for user to complete
 */
public class RegisterScreen extends JFrame implements ActionListener, Screen, Backable {

    private RegisterController controller;
    private UserResponseController backController;

    private final Canvas Background;
    private final JTextField Email;
    private final JTextField Name;
    private final JTextField Address;
    private final JPasswordField Password_0;
    private final JPasswordField Password_1;
    private final JButton Sign_Up;
    private final JButton Back;
    private final JLayeredPane LP;
    public void f0(){
        // Ignore this method. #PC_01.
        this.Sign_Up.setOpaque(true);
        this.Back.setOpaque(true);
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Name.setOpaque(true);
        this.Address.setOpaque(true);
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
                g.drawString("Address", 80, 170);
                g.drawString("Username", 80, 240);
                g.drawString("Password", 80, 310);
                g.drawString("Re-Enter Password", 80, 380);
            }
        };
        Background.setBackground(new Color(255,192,203));
        Background.setBounds(0, 0, 450, 600);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 450, 600);
        LP.setOpaque(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.requestFocus(true);
        this.setSize(450, 600);
        this.Name = new JTextField();
        Name.setBounds(80, 110, 265, 30);
        Name.setOpaque(true);
        Name.setBackground(new Color(255, 255, 255));
        this.Address = new JTextField();
        Address.setBounds(80, 180, 265, 30);
        Address.setOpaque(true);
        Address.setBackground(new Color(255, 255, 255));
        this.Email = new JTextField();
        Email.setBounds(80, 250, 265, 30);
        Email.setOpaque(true);
        Email.setBackground(new Color(255, 255, 255));
        this.Password_0 = new JPasswordField();
        Password_0.setBounds(80, 320, 265, 30);
        Password_0.setOpaque(true);
        Password_0.setBackground(new Color(255, 255, 255));
        this.Password_1 = new JPasswordField();
        Password_1.setBounds(80, 390, 265, 30);
        Password_1.setOpaque(true);
        Password_1.setBackground(new Color(255, 255, 255));


        this.Sign_Up = new JButton("Sign Up");
        this.Sign_Up.setActionCommand("signup");
        Sign_Up.setOpaque(true);
        Sign_Up.setBackground(new Color(255,192,203));
        Sign_Up.setBounds(300, 460, 90, 40);

        this.Back = new JButton("Back");
        this.Back.setActionCommand("back");
        Back.setOpaque(true);
        Back.setBackground(new Color(255,192,203));
        Back.setBounds(180, 460, 90, 40);
        LP.add(Sign_Up ,Integer.valueOf(0));
        LP.add(Back ,Integer.valueOf(0));
        LP.add(Password_1, Integer.valueOf(0));
        LP.add(Password_0, Integer.valueOf(0));
        LP.add(Email, Integer.valueOf(0));
        LP.add(Name, Integer.valueOf(0));
        LP.add(Address, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);

        Sign_Up.addActionListener(this);
        Back.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        try {
            if(Objects.equals(e.getActionCommand(), "signup")){
                this.controller.create(this.Name.getText(),this.Address.getText(), this.Email.getText(), Arrays.toString(this.Password_0.getPassword()), Arrays.toString(this.Password_1.getPassword()));
            }
            if(Objects.equals(e.getActionCommand(), "back")) {
                this.backController.goBack();
            }



        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RegisterController) controller;
    }

    @Override
    public void setBackController(UserResponseController backController){
        this.backController = backController;
    }
}
