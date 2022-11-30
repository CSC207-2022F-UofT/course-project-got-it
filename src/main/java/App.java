import LoginUseCase.DatabaseGateway;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginInteractor;
import screens.*;

import javax.swing.*;
import java.awt.*;

public class App implements PresenterObserver {

    private Presenter presenter;
    private final CardLayout cardLayout;
    public JPanel screens;
    private final DatabaseGateway dbGateway;

    public App(Presenter presenter){
        String mongoURI = System.getenv("MONGOURI");
        this.presenter = presenter;
        this.cardLayout = new CardLayout();
        this.screens = new JPanel(cardLayout);
        this.dbGateway = new DatabaseUser(mongoURI);
    }
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Got It");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Presenter presenter = new Presenter();
        App application = new App(presenter);
        presenter.addObserver(application);
        application.showLogin();
        mainFrame.add(application.screens);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void showLogin(){
        LoginInputBoundary inputBoundary = new LoginInteractor(this.dbGateway);
        LoginController loginController = new LoginController(inputBoundary, this.presenter);
        LoginScreen login = new LoginScreen(loginController);
        this.presenter.addScreen(login);
    }

    public void showRegister(){}

    @Override
    public void updateScreen(Screen newScreen) {
        this.screens.add((JPanel)newScreen, "new");
        this.cardLayout.show(this.screens, "new");
    }
}
