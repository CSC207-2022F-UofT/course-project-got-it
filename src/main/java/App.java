import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestInteractor;
import DatabaseGateway.DatabaseGateway;
import LoginUseCase.LoginInteractor;
import ProfilescreenUseCase.ProfilescreenInteractor;
import RegisterUseCase.RegisterInteractor;
import entities.User;
import entities.UserFactory;
import HomescreenUseCase.HomescreenInteractor;
import screens.*;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class App implements PresenterObserver {

    private final Presenter presenter;
    public JPanel screens;
    private final DatabaseGateway dbGateway;
    private final HashMap<String, Controller> screenMap;
    private User currentUser;
    private JFrame window;

    public App(Presenter presenter){
        this.window = new JFrame("Got It");
        String mongoURI = System.getenv("MONGOURI");
        this.currentUser = new User();
        this.presenter = presenter;
        this.dbGateway = new DatabaseUser(mongoURI);
        this.screenMap = new HashMap<>();
        this.screenMap.put(
                "login", new LoginController(new LoginInteractor(this.dbGateway, this.presenter, this.currentUser)));
        this.screenMap.put(
                "register", new RegisterController(new RegisterInteractor(this.dbGateway, new UserFactory(), this.presenter)));
        this.screenMap.put("homescreen", new screens.HomescreenController(new HomescreenInteractor(this.presenter, this.currentUser)));
        this.screenMap.put("profilescreen", new screens.ProfilescreenController(new ProfilescreenInteractor(this.dbGateway,this.currentUser, this.presenter)));
        this.screenMap.put("makeRequest", new RequestController(
                (RequestInputBoundary) new RequestInteractor(this.dbGateway, this.presenter)));
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public JFrame getWindow(){
        return this.window;
    }
    public static void main(String[] args){
        Presenter presenter = new Presenter();
        App application = new App(presenter);
        presenter.addObserver(application);
        presenter.registerSuccessView();
        JFrame window = application.getWindow();
        window.add(application.screens);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    @Override
    public void updateScreen(String screenName, Screen screen) {
        this.window.setVisible(false);
        screen.setController(this.screenMap.get(screenName));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        this.window = (JFrame)screen;
        this.window.setVisible(true);
    }
}
