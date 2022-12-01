package screens;

import RegisterUseCase.RegisterRequest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JPanel implements ActionListener, Screen {

    private RegisterController controller;

    JTextField emailField;
    JTextField passwordField;
    JTextField repeatpasswordField;

    public RegisterScreen() {
        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel emailLabel = new JLabel("Email");
        this.emailField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password");
        this.passwordField = new JTextField(15);
        JLabel repeatpasswordLabel = new JLabel("Repeat Password");
        this.repeatpasswordField = new JTextField(15);
        JPanel emailPanel = new JPanel();
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        JPanel repeatpasswordPanel = new JPanel();
        repeatpasswordPanel.add(repeatpasswordLabel);
        repeatpasswordPanel.add(repeatpasswordField);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(emailPanel);
        this.add(passwordPanel);
        this.add(repeatpasswordPanel);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.controller.create(this.emailField.getText(), this.passwordField.getText(), this.repeatpasswordField.getText());
            JOptionPane.showMessageDialog(this, this.emailField.getText() + "created");
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RegisterController) controller;
    }
}
