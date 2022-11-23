import LoginUseCase.LoginDBGateway;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginInteractor;
import screens.LoginController;
import screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){
        String mongoURI = System.getenv("MONGOURI");
        JFrame application = new JFrame("Got It");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginDBGateway dbGateway = new DatabaseUser(mongoURI);
        LoginInputBoundary inputBoundary = new LoginInteractor(dbGateway);
        LoginController loginController = new LoginController(inputBoundary);
        LoginScreen login = new LoginScreen(loginController);
        screens.add(login, "login");
        cardLayout.show(screens, "login");
        application.add(screens);
        application.pack();
        application.setVisible(true);
    }
}
