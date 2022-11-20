import javax.swing.*;
import java.awt.*;

public class MainWindow{
    private JFrame window;
    public MainWindow(){
        window = new JFrame();
        window.setTitle("Got It!");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
    }

    public void showLogin(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,  10, 5));
        panel.setBackground(Color.BLACK);
        window.add(panel, BorderLayout.CENTER);
        show();
    }

    public void show(){
        window.setVisible(true);
    }
}
