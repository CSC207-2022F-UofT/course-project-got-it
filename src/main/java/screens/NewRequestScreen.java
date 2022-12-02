package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRequestScreen extends JPanel implements ActionListener, Screen{
    private RequestController controller;

    JTextField items;
    JTextField itemNotes;
    JTextField deliveryAddress;
    JTextField deliveryNotes;

    public NewRequestScreen() {
        JLabel title = new JLabel("Request Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel itemsLabel = new JLabel("Items");
        this.items = new JTextField(15);
        JLabel itemNotesLabel = new JLabel("Item Note");
        this.itemNotes = new JTextField(15);
        JLabel deliveryAddressLabel = new JLabel("Delivery Address");
        this.deliveryAddress = new JTextField(15);
        JLabel deliveryNotesLabel = new JLabel("Delivery Notes");
        this.deliveryNotes = new JTextField(15);
        JPanel itemsPanel = new JPanel();
        itemsPanel.add(itemsLabel);
        itemsPanel.add(items);
        JPanel itemNotesPanel = new JPanel();
        itemNotesPanel.add(itemNotesLabel);
        itemNotesPanel.add(itemNotes);
        JPanel deliveryAddressPanel = new JPanel();
        deliveryAddressPanel.add(deliveryAddressLabel);
        deliveryAddressPanel.add(deliveryAddress);
        JPanel deliveryNotesPanel = new JPanel();
        deliveryNotesPanel.add(deliveryNotesLabel);
        deliveryNotesPanel.add(deliveryNotes);


        JButton back = new JButton("Back");
        JButton create = new JButton("Create");

        JPanel buttons = new JPanel();
        buttons.add(back);
        buttons.add(create);

        back.addActionListener(this);
        create.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(itemsPanel);
        this.add(itemNotesPanel);
        this.add(deliveryAddressPanel);
        this.add(deliveryNotesPanel);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RequestController) controller;
    }
}