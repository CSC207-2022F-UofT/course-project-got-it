package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FINDING_A_DRIVER_WINDOW extends JFrame{
    // Uncomment the main method and run it to visualize the window. #PC_01.
    private final Canvas Background;
    private final JLayeredPane LP;
    public void f0(){
        // Please ignore this method. #PC_01.
        this.Background.setBackground(Color.BLACK);
        this.LP.setOpaque(false);
    }
    public FINDING_A_DRIVER_WINDOW(){
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 35));
                g.drawString("Finding a driver.", 29, 75);
            }
        };
        Background.setBounds(0, 0, 390, 170);
        Background.setBackground(Color.pink);
        this.setTitle("Finding_A_Driver.");
        this.setResizable(false);
        this.setSize(390, 170);
        this.setLocationRelativeTo(null);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 390, 170);
        LP.add(Background,Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
    }
//    public static void main(String[] args) {
//        new FINDING_A_DRIVER_WINDOW();
//    }
//    Uncomment codes above and run it to see the window. #PC_01.
}
