import APIGateway.APIGateway;
import DeliveryUseCase.DeliveryInputBoundary;
import DeliveryUseCase.DeliveryInteractor;
import MakeRequestUseCase.RequestInputBoundary;
import MakeRequestUseCase.RequestInteractor;
import DatabaseGateway.DatabaseGateway;
import LoginUseCase.LoginInteractor;
import ProfilescreenUseCase.ProfilescreenInteractor;
import RegisterUseCase.RegisterInteractor;
import UserResponseWindowUseCase.UserResponseInteractor;
import entities.User;
import entities.UserFactory;
import HomescreenUseCase.HomescreenInteractor;
import screens.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Observes the presenter. Creates a screen hashmap that stores the screen, controller and interactor for all the components
 * When notified by presenter, changes the screen to the screen name mentioned in the screen hashmap
 * Also sets up external functionalities such as PositionStackAPI and MongoDB API
 */
public class App implements PresenterObserver {

    private final Presenter presenter;
    public JPanel screens;
    private final APIGateway apiGateway;
    private final DatabaseGateway dbGateway;
    private final HashMap<String, Controller> screenMap;
    private User currentUser;
    private JFrame window;

    public App(Presenter presenter){
        this.window = new JFrame("Got It");
        String mongoURI = System.getenv("MONGOURI");
        String apiKey = System.getenv("APIKEY");
        this.currentUser = new User();
        this.presenter = presenter;
        this.dbGateway = new DatabaseUser(mongoURI);
        this.apiGateway = new PositionStackAPI(apiKey);
        this.screenMap = new HashMap<>();
        this.screenMap.put(
                "deliveryTime", new UserResponseController(new UserResponseInteractor(this.presenter)));
        this.screenMap.put("currenttrequests",
                new DeliveryController((DeliveryInputBoundary) new DeliveryInteractor(this.dbGateway, this.presenter),
                        this.currentUser));
        this.screenMap.put(
                "requestFailed", new UserResponseController(new UserResponseInteractor(this.presenter)));
        this.screenMap.put(
                "noRequests", new UserResponseController(new UserResponseInteractor(this.presenter)));
        this.screenMap.put(
                "login", new LoginController(new LoginInteractor(this.dbGateway, this.apiGateway, this.presenter, this.currentUser)));
        this.screenMap.put(
                "register", new RegisterController(new RegisterInteractor(this.dbGateway, this.apiGateway, new UserFactory(), this.presenter)));
        this.screenMap.put("homescreen", new screens.HomescreenController(new HomescreenInteractor(this.presenter, this.currentUser, this.apiGateway, this.dbGateway)));
        this.screenMap.put("profilescreen", new screens.ProfilescreenController(new ProfilescreenInteractor(this.dbGateway,
                this.currentUser, this.presenter)));
        this.screenMap.put("makeRequest", new RequestController(
                (RequestInputBoundary) new RequestInteractor(this.apiGateway, this.dbGateway, this.presenter, this.currentUser), this.currentUser));
        this.screenMap.put("loginFailed", new UserResponseController(new UserResponseInteractor(this.presenter)));
        this.screenMap.put("deliveryTimeFailed", new UserResponseController(new UserResponseInteractor(this.presenter)));
        this.screenMap.put("registerFailed", new UserResponseController(new UserResponseInteractor(this.presenter)));
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
    }

    @Override
    public void updateScreen(String screenName, Screen screen) {
        this.window.setVisible(false);
        setWindow((JFrame)screen);
        screen.setController(this.screenMap.get(screenName));
        if(screen instanceof Backable){
            ((Backable) screen).setBackController(new UserResponseController(new UserResponseInteractor(this.presenter)));
        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }
}
