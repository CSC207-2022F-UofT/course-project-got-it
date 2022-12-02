package screens;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Homescreen extends JPanel implements ActionListener, Screen {

    private HomescreenController controller;

    public Homescreen() {
        JLabel title = new JLabel("Home Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton profile = new JButton("My Profile");
        profile.setActionCommand("navigateProfile");
        JButton new_request = new JButton("New Request");
        new_request.setActionCommand("navigateNewrequest");
        JButton past_request = new JButton("Past Requests");
        past_request.setActionCommand("navigatePastrequests");
        JPanel buttons = new JPanel();
        buttons.add(profile);
        buttons.add(new_request);
        buttons.add(past_request);

        profile.addActionListener(this);
        new_request.addActionListener(this);
        past_request.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.navigate(e.getActionCommand());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (HomescreenController) controller;
    }
}

