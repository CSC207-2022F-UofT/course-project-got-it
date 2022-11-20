import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                MainWindow window = new MainWindow();
                window.showLogin();
            }
        });
    }
}
