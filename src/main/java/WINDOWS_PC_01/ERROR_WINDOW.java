package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//GOod morning.0011
public class ERROR_WINDOW extends JFrame implements ActionListener {
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final JLayeredPane LP;
    private final Canvas Background;
    private final JButton Try_Again;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Try_Again.setOpaque(true);
    }
    public ERROR_WINDOW(){
        this.setTitle("Error_00");
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 25));
                g.drawString("Sorry, your account could", 9, 40);
                g.drawString("not be created. ", 85, 90);
            }
        };
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.Background.setBounds(0, 0, 400, 190);
        Background.setBackground(new Color(255, 255, 255));
        this.setSize(400, 190);
        this.setResizable(false);
//        this.setLocation(new Point(x, y));
        this.setLocationRelativeTo(null);
        this.requestFocus(true);
        this.setLocationRelativeTo(null);
        this.Try_Again = new JButton("Try Again. ");
        Try_Again.setBounds(140, 115, 120, 30);
        Try_Again.setOpaque(true);
        Try_Again.setBackground(new Color(255, 255, 255));
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 400, 190);
        LP.add(Try_Again, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
//    public static void main(String[] args) {
//        new ERROR_WINDOW();
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement this method so buttons can work correctly. #PC_01.
    }
}
