package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestFailedScreen extends JPanel implements Screen, ActionListener {

    public RequestFailedScreen(){
        JLabel title = new JLabel("Request Cannot Be Made");
        JLabel loggedIn = new JLabel("Request Not Made");
        JButton confirmBtn = new JButton("Ok");
        this.add(title);
        this.add(loggedIn);
        this.add(confirmBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void setController(Controller controller) {

    }
}
