import screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){
        JFrame application = new JFrame("Got It");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginScreen login = new LoginScreen();
        screens.add(login, "login");
        cardLayout.show(screens, "login");
        application.add(screens);
        application.pack();
        application.setVisible(true);
        String mongoURI = System.getenv("MONGOURI");
        System.out.println(mongoURI);
    }
}
