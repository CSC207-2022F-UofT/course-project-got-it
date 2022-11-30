package screens;

import LoginUseCase.LoginPresenter;
import LoginUseCase.LoginResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedInScreen extends JPanel implements ActionListener, Screen{

    public LoggedInScreen(LoginResponse userData) {
        JLabel title = new JLabel("Got It");
        JLabel loggedIn = new JLabel("Logged In");
        this.add(title);
        this.add(loggedIn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
    }
}
