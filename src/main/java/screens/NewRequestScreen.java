package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class NewRequestScreen extends JPanel implements ActionListener, Screen{
    private RequestController controller;

    JTextField items;
    JTextField itemDescription;
    JTextField deliveryAddress;
    JTextField deliveryDescription;
    JTextField itemLocation;

    public NewRequestScreen() {
        JLabel title = new JLabel("Request Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel itemsLabel = new JLabel("Items");
        this.items = new JTextField(15);
        JLabel itemDescriptionLabel = new JLabel("Item Note");
        this.itemDescription = new JTextField(15);
        JLabel deliveryAddressLabel = new JLabel("Delivery Address");
        this.deliveryAddress = new JTextField(15);
        this.itemLocation = new JTextField(15);
        JLabel itemLocationLabel = new JLabel("Item Location");
        JLabel deliveryDescriptionLabel = new JLabel("Delivery Description");
        this.deliveryDescription = new JTextField(15);
        JPanel itemsPanel = new JPanel();
        itemsPanel.add(itemsLabel);
        itemsPanel.add(items);
        JPanel itemDescriptionPanel = new JPanel();
        itemDescriptionPanel.add(itemDescriptionLabel);
        itemDescriptionPanel.add(itemDescription);
        JPanel deliveryAddressPanel = new JPanel();
        deliveryAddressPanel.add(deliveryAddressLabel);
        deliveryAddressPanel.add(deliveryAddress);
        JPanel deliveryDescriptionPanel = new JPanel();
        deliveryDescriptionPanel.add(deliveryDescriptionLabel);
        deliveryDescriptionPanel.add(deliveryDescription);
        JPanel itemLocationPanel = new JPanel();
        itemLocationPanel.add(itemLocationLabel);
        itemLocationPanel.add(itemLocation);

        JButton back = new JButton("Back");
        back.setActionCommand("back");
        back.addActionListener(this);
        JButton create = new JButton("Create");

        JPanel buttons = new JPanel();
        buttons.add(back);
        buttons.add(create);

        create.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(itemsPanel);
        this.add(itemDescriptionPanel);
        this.add(itemLocationPanel);
        this.add(deliveryAddressPanel);
        this.add(deliveryDescriptionPanel);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "back")){
            this.controller.goBack();

        }
        this.controller.request(this.deliveryAddress.getText(), this.itemLocation.getText(),
                this.itemDescription.getText(), "abc", this.deliveryDescription.getText());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (RequestController) controller;
    }
}