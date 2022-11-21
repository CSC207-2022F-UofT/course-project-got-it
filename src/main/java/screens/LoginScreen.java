package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel implements ActionListener {

    private LoginController controller;
    JTextField usernameField;
    JTextField passwordField;

    public LoginScreen(LoginController controller){
        this.controller = controller;
        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel usernameLabel = new JLabel("Username");
        this.usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password");
        this.passwordField = new JTextField(15);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        JButton loginBtn = new JButton("login");
        loginBtn.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(loginBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        try{
            this.controller.login(this.usernameField.getText(), this.passwordField.getText());
            JOptionPane.showMessageDialog(this, this.usernameField.getText() + "logged in");
        }catch(Exception loginException){
            JOptionPane.showMessageDialog(this, loginException.getMessage());
        }
    }

}
