package screens;

import entities.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RegisterFailed extends JFrame implements ActionListener, Screen{

    private UserResponseController controller;

    public RegisterFailed() {
        JLabel title = new JLabel("Login Failed");
        JLabel loggedIn = new JLabel("Not Logged In");
        JButton back = new JButton("back");
        back.setActionCommand("back");
        back.addActionListener(this);
        this.add(title);
        this.add(loggedIn);
        this.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(Objects.equals(e.getActionCommand(), "back")){
            this.controller.goBack();

        }
        System.out.println("click");
    }

    @Override
    public void setController(Controller controller) {

    }
}
