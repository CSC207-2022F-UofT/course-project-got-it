import LoginUseCase.LoginDBGateway;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginInteractor;
import screens.LoginController;
import screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class App {

    private final String mongoURI;
    private CardLayout cardLayout;
    public JPanel screens;

    public App(){
        this.mongoURI = System.getenv("MONGOURI");
        this.cardLayout = new CardLayout();
        this.screens = new JPanel(cardLayout);
    }
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Got It");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        App application = new App();
        application.showLogin();
        mainFrame.add(application.screens);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void showLogin(){
        LoginDBGateway dbGateway = new DatabaseUser(mongoURI);
        LoginInputBoundary inputBoundary = new LoginInteractor(dbGateway);
        LoginController loginController = new LoginController(inputBoundary);
        LoginScreen login = new LoginScreen(loginController);
        this.screens.add(login, "login");
        this.cardLayout.show(screens, "login");
    }
}
