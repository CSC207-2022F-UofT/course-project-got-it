package screens;

import RegisterUseCase.RegisterRequest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JPanel implements ActionListener {

    private RegisterController controller;

    JTextField nameField;

    JTextField longitudeField;
    JTextField latitudeField;

    JTextField emailField;
    JTextField passwordField;
    JTextField repeatpasswordField;

    public RegisterScreen(RegisterController controller) {
        this.controller = controller;

        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nameLabel = new JLabel("Name");
        this.nameField = new JTextField(15);
        JLabel longitudeLabel = new JLabel("Address Longitude");
        this.longitudeField = new JTextField(15);
        JLabel latitudeLabel = new JLabel("Address Latitude");
        this.latitudeField = new JTextField(15);

        JLabel emailLabel = new JLabel("Email");
        this.emailField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password");
        this.passwordField = new JTextField(15);
        JLabel repeatpasswordLabel = new JLabel("Repeat Password");
        this.repeatpasswordField = new JTextField(15);
        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        JPanel longitudePanel = new JPanel();
        longitudePanel.add(longitudeLabel);
        longitudePanel.add(longitudeField);
        JPanel latitudePanel = new JPanel();
        latitudePanel.add(latitudeLabel);
        latitudePanel.add(latitudeField);
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
        this.add(namePanel);
        this.add(longitudePanel);
        this.add(latitudePanel);
        this.add(emailPanel);
        this.add(passwordPanel);
        this.add(repeatpasswordPanel);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double[] coords = {Integer.parseInt(this.longitudeField.getText()), Integer.parseInt(this.latitudeField.getText())};
            this.controller.create(this.nameField.getText(), coords,this.emailField.getText(), this.passwordField.getText(), this.repeatpasswordField.getText());
            JOptionPane.showMessageDialog(this, this.emailField.getText() + "created");
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}
