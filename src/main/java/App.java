import APIGateway.APIGateway;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestInteractor;
import DatabaseGateway.DatabaseGateway;
import LoginUseCase.LoginInteractor;
import RegisterUseCase.RegisterInteractor;
import entities.User;
import entities.UserFactory;
import HomescreenUseCase.HomescreenInteractor;
import screens.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class App implements PresenterObserver {

    private final Presenter presenter;
    private final CardLayout cardLayout;
    public JPanel screens;
    private final APIGateway apiGateway;
    private final DatabaseGateway dbGateway;
    private final HashMap<String, Controller> screenMap;
    private User currentUser;

    public App(Presenter presenter){
        String mongoURI = System.getenv("MONGOURI");
        String apiKey = System.getenv("APIKEY");
        this.currentUser = new User();
        this.presenter = presenter;
        this.cardLayout = new CardLayout();
        this.screens = new JPanel(cardLayout);
        this.dbGateway = new DatabaseUser(mongoURI);
        this.apiGateway = new PositionStackAPI(apiKey);
        this.screenMap = new HashMap<>();
        this.screenMap.put(
                "login", new LoginController(new LoginInteractor(this.dbGateway, this.presenter, this.currentUser)));
        this.screenMap.put(
                "register", new RegisterController(new RegisterInteractor(this.dbGateway, new UserFactory(), this.presenter)));
        this.screenMap.put("homescreen", new screens.HomescreenController(new HomescreenInteractor(this.presenter)));
        this.screenMap.put("makeRequest", new RequestController(
                (RequestInputBoundary) new RequestInteractor(this.apiGateway, this.dbGateway, this.presenter), this.currentUser));
    }
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Got It");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Presenter presenter = new Presenter();
        App application = new App(presenter);
        presenter.addObserver(application);
        presenter.registerSuccessView();
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
