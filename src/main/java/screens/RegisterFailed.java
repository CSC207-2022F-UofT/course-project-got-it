package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFailed extends JFrame implements ActionListener, Screen{

    private Controller controller;

    public RegisterFailed() {
        JLabel title = new JLabel("Login Failed");
        JLabel loggedIn = new JLabel("Not Logged In");
        JButton back = new JButton("back");
        this.add(title);
        this.add(loggedIn);
        this.add(back);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
    }
}
