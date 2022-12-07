package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entities.Request;

public class Pastrequestsscreen extends JPanel implements ActionListener, Screen {

    private PastRequestController controller;
    public Pastrequestsscreen(ArrayList<Request>) {
        JLabel title = new JLabel("Requests");


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void setController(Controller controller) {

    }
}