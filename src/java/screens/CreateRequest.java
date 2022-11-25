package screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

class CreateRequest extends JFrame implements ActionListener
{
    JButton b1, b2;
    JPanel newPanel;
    JLabel itemLabel, itemNotesLabel, deliveryLabel, deliveryNotesLabel;
    JTextField  itemField, itemNotesField, deliveryField, deliveryNotesField;

    CreateRequest()
    {
        itemLabel = new JLabel();
        itemLabel.setText("Item: ");

        itemField = new JTextField();

        itemNotesLabel = new JLabel();
        itemNotesLabel.setText("Enter any item details here: ");

        itemNotesField = new JTextField();

        deliveryLabel = new JLabel();
        deliveryLabel.setText("Delivery Address: ");

        deliveryField = new JTextField();

        deliveryNotesLabel = new JLabel();
        deliveryNotesLabel.setText("Enter any delivery notes here: ");

        deliveryNotesField = new JTextField();

        b1 = new JButton("Submit Request");
        b2 = new JButton("Cancel Request");

        newPanel = new JPanel(new GridLayout(5, 1));
        newPanel.add(itemLabel);
        newPanel.add(itemField);
        newPanel.add(itemNotesLabel);
        newPanel.add(itemNotesField);
        newPanel.add(deliveryLabel);
        newPanel.add(deliveryField);
        newPanel.add(deliveryNotesLabel);
        newPanel.add(deliveryNotesField);
        newPanel.add(b1);
        newPanel.add(b2);

        add(newPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        setTitle("Delivery Request");
    }

    public void actionPerformed(ActionEvent ae)
    {
        String itemValue = itemField.getText();
        String deliveryValue = deliveryField.getText();

        NewPage page = new NewPage();

        page.setVisible(true);

        JLabel complete_label = new JLabel("You're delivery request for " + itemValue + " is now " +
                "being delivered to " + deliveryValue + ".");
        page.getContentPane().add(complete_label);

    }
}
class RequestDemo
{
    public static void main(String arg[])
    {
        try
        {
            CreateRequest form = new CreateRequest();
            form.setSize(300,100);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}