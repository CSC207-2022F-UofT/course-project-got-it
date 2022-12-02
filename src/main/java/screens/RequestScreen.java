package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestScreen extends JPanel implements ActionListener {
    /**
     * Array of items entered by the user
     */
    JTextField[] items = new JTextField[10];
    /**
     * Any details/notes for the items entered by the user
     */
    JTextField itemNotes = new JTextField();
    /**
     * The delivery address entered by the user
     */
    JTextField deliveryAddress = new JTextField();
    /**
     * Any delivery requests/notes entered by the user
     */
    JTextField deliveryNotes = new JTextField();

    /**
     * A window with a title and a JButton
     */
    public RequestScreen() {
        JLabel title = new JLabel("Delivery Request");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel itemsInfo = new JLabel("Enter items for delivery");
        this.items = new JTextField[10];
        JLabel itemNotesInfo = new JLabel("Enter any item details/notes");
        this.itemNotes = new JTextField();
        JLabel deliveryAddressInfo = new JLabel("Enter delivery address");
        this.deliveryAddress = new JTextField();
        JLabel deliveryNotesInfo = new JLabel("Enter any delivery requests/notes");
        this.deliveryNotes = new JTextField();

        JButton submit = new JButton("Submit Request");
        JButton cancel = new JButton("Cancel Request");

        JPanel buttons = new JPanel();
        buttons.add(submit);
        buttons.add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(itemsInfo);
        this.add(itemNotesInfo);
        this.add(deliveryAddressInfo);
        this.add(deliveryNotesInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
