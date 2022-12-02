import dbGateway.DatabaseGateway;
import LoginUseCase.LoginInputBoundary;
import LoginUseCase.LoginInteractor;
import screens.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class App implements PresenterObserver {

    private final Presenter presenter;
    private final CardLayout cardLayout;
    public JPanel screens;
    private final DatabaseGateway dbGateway;
    private final HashMap<String, Controller> screenMap;

    public App(Presenter presenter){
        String mongoURI = System.getenv("MONGOURI");
        this.presenter = presenter;
        this.cardLayout = new CardLayout();
        this.screens = new JPanel(cardLayout);
        this.dbGateway = new DatabaseUser(mongoURI);
        this.screenMap = new HashMap<>();
        this.screenMap.put("login", new LoginController(
                (LoginInputBoundary)new LoginInteractor(this.dbGateway, this.presenter)));
    }
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Got It");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Presenter presenter = new Presenter();
        App application = new App(presenter);
        presenter.addObserver(application);
        presenter.start();
        mainFrame.add(application.screens);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void updateScreen(String screenName, Screen screen) {
        screen.setController(this.screenMap.get(screenName));
        this.screens.add((JPanel)screen, "new");
        this.cardLayout.show(this.screens, "new");
    }
}
