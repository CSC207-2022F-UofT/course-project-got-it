package screens;

import LoginUseCase.LoginPresenter;
import LoginUseCase.LoginResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedInScreen extends JPanel implements ActionListener {

    public LoggedInScreen(LoginResponse response) {
        JLabel title = new JLabel("Got It");
        JLabel loggedIn;
        if(response.isLoggedIn()){
            loggedIn = new JLabel("Logged In");
        }
        else{
            loggedIn = new JLabel("Not Logged In");
        }
        this.add(title);
        this.add(loggedIn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
    }
}
