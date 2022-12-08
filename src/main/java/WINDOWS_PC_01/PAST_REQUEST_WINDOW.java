package WINDOWS_PC_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PAST_REQUEST_WINDOW extends JFrame implements ActionListener {
    //Uncomment the main method and run it to visualize this window. #PC_01.
    private final Canvas Background;
    private final JLayeredPane LP;
    private final JButton Past_Request_0;
    private final JButton Past_Request_1;
    private final JButton Past_Request_2;
    private final JButton Back;
    private final GI_Server Server;
    private final User U;
    private final ArrayList<Request> l0;
    public void f0(){
        this.Background.setBackground(Color.BLACK);
        this.LP.setOpaque(true);
        this.Past_Request_0.setOpaque(false);
        this.Past_Request_1.setOpaque(false);
        this.Past_Request_2.setOpaque(false);
        this.Back.setOpaque(false);
    }
    public PAST_REQUEST_WINDOW(GI_Server S0, User U, ArrayList<Request> l0){
    // I assume all three past_request_information will be passed as parameters in order to display
    // such info in the window. #PC_01.
        this.Server = S0;
        this.U = U;
        this.l0 = l0;
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
        this.Past_Request_0 = new JButton();
        Past_Request_0.setOpaque(true);
        Past_Request_0.setBackground(Color.pink);
        Past_Request_0.setBounds(20, 81, 261, 45);
        Past_Request_0.addActionListener(this);
        this.Past_Request_1 = new JButton();
        Past_Request_1.setOpaque(true);
        Past_Request_1.setBackground(Color.pink);
        Past_Request_1.setBounds(20, 171, 261, 45);
        Past_Request_1.addActionListener(this);
        this.Past_Request_2 = new JButton();
        Past_Request_2.setOpaque(true);
        Past_Request_2.setBackground(Color.pink);
        Past_Request_2.setBounds(20, 261, 261, 45);
        Past_Request_2.addActionListener(this);
        if(l0.size() == 0){
            this.Past_Request_0.setText("Nothing yet");
            this.Past_Request_1.setText("Nothing yet");
            this.Past_Request_2.setText("Nothing yet");
        }else if(l0.size() == 1){
            Request r0 = l0.get(0);
            this.Past_Request_0.setText("Lost A " + r0.getItem_Name() + " at " + r0.getItem_Location() );
            this.Past_Request_1.setText("Nothing yet");
            this.Past_Request_2.setText("Nothing yet");
        }else if(l0.size() == 2){
            Request r0 = l0.get(l0.size() - 1);
            Request r1 = l0.get(0);
            this.Past_Request_0.setText("Lost A " + r0.getItem_Name() + " at " + r0.getItem_Location() );
            this.Past_Request_1.setText("Lost A " + r1.getItem_Name() + " at " + r1.getItem_Location() );
            this.Past_Request_2.setText("Nothing yet");

        } else{
            Request r0 = l0.get(l0.size() - 1);
            Request r1 = l0.get(l0.size() - 2);
            Request r2 = l0.get(0);
            this.Past_Request_0.setText("Lost A" + r0.getItem_Name() + "at" + r0.getItem_Location() );
            this.Past_Request_1.setText("Lost A" + r1.getItem_Name() + "at" + r1.getItem_Location() );
            this.Past_Request_2.setText("Lost A" + r2.getItem_Name() + "at" + r2.getItem_Location() );
        }
        Background.setBounds(0, 0, 300, 400);
        Background.setBackground(Color.pink);
        this.Back = new JButton("Back");
        this.Back.setOpaque(true);
        this.Back.setBackground(Color.pink);
        this.Back.setBounds(201, 331, 81, 30);
        this.Back.addActionListener(this);
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
        if(e.getSource() == this.Back){
            this.setVisible(false);
            new HOME_WINDOW(this.Server, this.U);
        }else if(e.getSource() == this.Past_Request_0 && !this.Past_Request_0.getText().equals("Nothing yet")){
            this.setVisible(false);
            new PRINT_REQUEST_INFO_WINDOW(this.Server, this.U, l0.get(l0.size() - 1));
        }else if(e.getSource() == this.Past_Request_1 && !this.Past_Request_1.getText().equals("Nothing yet")){
            this.setVisible(false);
            new PRINT_REQUEST_INFO_WINDOW(this.Server, this.U, l0.get(l0.size() - 2));
        }else if(e.getSource() == this.Past_Request_2 && !this.Past_Request_2.getText().equals("Nothing yet")){
            this.setVisible(false);
            new PRINT_REQUEST_INFO_WINDOW(this.Server, this.U, l0.get(l0.size() - 3));
        }
    }
//    public static void main(String[] P0) {
//
//    }
//    Uncomment codes above and run the main method to see this window. #PC_01.
}
