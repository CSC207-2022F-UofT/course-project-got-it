package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * JFrame for request failed screen which shows that the request cannot be made
 */
public class RequestFailedScreen extends JFrame implements Screen, ActionListener {

    private UserResponseController controller;
    public RequestFailedScreen(){
        JLabel title = new JLabel("Request Cannot Be Made");
        JLabel loggedIn = new JLabel("Request Not Made");
        JButton confirmBtn = new JButton("Ok");
        JButton back = new JButton("back");
        back.setActionCommand("back");
        back.addActionListener(this);
        this.add(title);
        this.add(loggedIn);
        this.add(confirmBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(Objects.equals(e.getActionCommand(), "back")){
            this.controller.goBack();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (UserResponseController) controller;
    }
}
