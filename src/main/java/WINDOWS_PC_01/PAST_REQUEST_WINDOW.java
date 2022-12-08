package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PAST_REQUEST_WINDOW extends JFrame implements ActionListener {
    //Uncomment the main method and run it to visualize this window. #PC_01.
    private final Canvas Background;
    private final JLayeredPane LP;
    private final JButton Past_Request_0;
    private final JButton Past_Request_1;
    private final JButton Past_Request_2;
    private final JButton Back;
    public void f0(){
        this.Background.setBackground(Color.BLACK);
        this.LP.setOpaque(true);
        this.Past_Request_0.setOpaque(false);
        this.Past_Request_1.setOpaque(false);
        this.Past_Request_2.setOpaque(false);
        this.Back.setOpaque(false);
    }
    public PAST_REQUEST_WINDOW(String Request_0, String Request_1, String Request_2){
    // I assume all three past_request_information will be passed as parameters in order to display
    // such info in the window. #PC_01.
        this.Background = new Canvas(){
            @Override
            public void paint(Graphics g){
                g.setFont(new Font("Monaco", Font.BOLD, 30));
                g.setColor(Color.BLACK);
                g.drawString("Past Request", 41, 50);
            }
        };
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.requestFocus(true);
        this.Past_Request_0 = new JButton(Request_0);
        Past_Request_0.setOpaque(true);
        Past_Request_0.setBackground(Color.pink);
        Past_Request_0.setBounds(20, 81, 261, 45);
        this.Past_Request_1 = new JButton(Request_1);
        Past_Request_1.setOpaque(true);
        Past_Request_1.setBackground(Color.pink);
        Past_Request_1.setBounds(20, 171, 261, 45);
        this.Past_Request_2 = new JButton(Request_2);
        Past_Request_2.setOpaque(true);
        Past_Request_2.setBackground(Color.pink);
        Past_Request_2.setBounds(20, 261, 261, 45);
        Background.setBounds(0, 0, 300, 400);
        Background.setBackground(Color.pink);
        this.Back = new JButton("Back");
        this.Back.setOpaque(true);
        this.Back.setBackground(Color.pink);
        this.Back.setBounds(201, 331, 81, 30);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 300, 400);
        LP.add(Back, Integer.valueOf(0));
        LP.add(Past_Request_0, Integer.valueOf(0));
        LP.add(Past_Request_1, Integer.valueOf(0));
        LP.add(Past_Request_2, Integer.valueOf(0));
        LP.add(Background);
        this.add(LP);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement this method so buttons can work correctly.
    }
//    public static void main(String[] P0) {
//        new PAST_REQUEST_WINDOW("PC_TEXT_0", "PC_TEXT_1", "PC_TEXT_2");
//    }
//    Uncomment codes above and run the main method to see this window. #PC_01.
}
