package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nocurrentrequestscreen extends JFrame implements ActionListener, Screen{
    private UserResponseController controller;
    private final JLayeredPane LP;
    private final Canvas Background;
    private final JButton Back;
    public void f0(){
        // Ignore this method. #PC_01.
        this.LP.setOpaque(true);
        this.Background.setSize(0, 0);
        this.Back.setOpaque(true);
    }
    public Nocurrentrequestscreen() {
        this.setTitle("Error_00");
        this.Background = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.setFont(new Font("Monaco", Font.BOLD, 15));
                g.drawString("Sorry", 178, 50);
                g.drawString("You have no ongoing request!", 82, 75);
            }
        };
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.Background.setBounds(0, 0, 400, 190);
        Background.setBackground(new Color(255, 255, 255));
        this.setSize(400, 190);
        this.setResizable(false);
        //        this.setLocation(new Point(x, y));
        //        You can manipulate the location of this window by using line 15. #PC_01.
        this.setLocationRelativeTo(null);
        this.requestFocus(true);
        this.setLocationRelativeTo(null);
        this.Back = new JButton("back");
        Back.setBounds(140, 115, 120, 30);
        Back.setOpaque(true);
        Back.setBackground(new Color(255, 255, 255));
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0, 400, 190);
        LP.add(Back, Integer.valueOf(0));
        LP.add(Background, Integer.valueOf(0));
        this.add(LP);
        this.setVisible(true);
        Back.addActionListener(this);
    }

    public static void main(String[] args){
        new Nocurrentrequestscreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.goBack();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (UserResponseController) controller;
    }
}
