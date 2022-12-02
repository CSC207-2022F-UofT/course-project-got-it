package deliveryScreens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryStatusScreen extends JFrame implements ActionListener {
    /**
     * Status of delivery
     */
    JTextField status = new JTextField();
    /**
     * A window with a title and a JButton
     */
    public DeliveryStatusScreen() {
        JLabel title = new JLabel("Delivery Status");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton cancel = new JButton("Dismiss");

        JPanel buttons = new JPanel();
        buttons.add(cancel);

        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(status);
        main.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

