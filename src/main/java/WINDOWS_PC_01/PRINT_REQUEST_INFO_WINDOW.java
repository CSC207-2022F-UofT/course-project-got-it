package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PRINT_REQUEST_INFO_WINDOW extends JFrame implements ActionListener {
    private JTextField Item_Location;
    private JTextField Item_Description;
    private JTextField Item_Delivery_Location;
    private JTextField Driver_Info;
    private JLayeredPane LP;
    public PRINT_REQUEST_INFO_WINDOW(){
        this.LP = new JLayeredPane();
        this.LP.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.add(LP);
//        LP.add();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
