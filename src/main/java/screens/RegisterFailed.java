package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * JFrame for register failed screen which notifies user that registration failed
 */
public class RegisterFailed extends JFrame implements ActionListener, Screen{

    private UserResponseController controller;
    private final JLayeredPane LP;
    private final Canvas Background;
    private final JButton Try_Again;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Try_Again.setOpaque(true);
    }
    public RegisterFailed(){
        this.setTitle("Error_00");
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Sorry, your account could", 9, 40);
                g.drawString("not be created. ", 85, 90);
            }
        };
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.Background.setBounds(0, 0, 400, 190);
        Background.setBackground(new Color(255, 255, 255));
        this.setSize(400, 190);
        this.setResizable(false);
        //        this.setLocation(new Point(x, y));
        //        You can manipulate the location of this window by using line 15. #PC_01.
        this.setLocationRelativeTo(null);
        this.requestFocus(true);
        this.setLocationRelativeTo(null);
        this.Try_Again = new JButton("Try Again");
        Try_Again.setBounds(140, 115, 120, 30);
        Try_Again.setOpaque(true);
        Try_Again.setBackground(new Color(255, 255, 255));
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 400, 190);
        LP.add(Try_Again, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
        Try_Again.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.goBack();
    }
    @Override
    public void setController(Controller controller) {
        this.controller = (UserResponseController) controller;
    }


}
