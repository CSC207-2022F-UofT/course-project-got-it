package screens;

import MakeRequestUseCase.RequestResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame for request made which shows that the request has been made
 */
public class RequestMadeScreen extends JFrame implements ActionListener, Screen {

    public RequestMadeScreen(){
        JLabel title = new JLabel("Request Has Been Made!");
        JLabel loggedIn = new JLabel("Request Made");
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
