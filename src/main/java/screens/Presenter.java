package screens;

import LoginUseCase.LoginResponse;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

//Decides what screen to show, initially will be register
public class Presenter{

    private final ArrayList<PresenterObserver> screenObservers;
    private final LinkedHashMap<String, Screen> screens;
    private String currentScreen;

    public Presenter(){
        this.screenObservers = new ArrayList<PresenterObserver>();
        this.screens = new LinkedHashMap<String, Screen>();
    }

    public void loginSuccess(LoginResponse response){
        LoggedInScreen loginSuccess = new LoggedInScreen(response.getEmail());
        this.currentScreen = "loginSuccess";
        this.addScreen(this.currentScreen, loginSuccess);
    }
    public void loginFailed(){
        LoginFailed failedScreen = new LoginFailed();
        this.currentScreen = "loginFailed";
        addScreen(this.currentScreen,failedScreen);
    }
    public void addObserver(PresenterObserver observer){
        this.screenObservers.add(observer);
    }
    private void notifyObservers(){
        for (PresenterObserver screenObserver : this.screenObservers) {
            screenObserver.updateScreen(this.currentScreen, this.screens.get(this.currentScreen));
        }
    }

    public void registerFailView(){
        RegisterFailed registerFailed = new RegisterFailed();
        this.currentScreen = "registerFailed";
        this.addScreen(this.currentScreen, registerFailed);

    }

    public void registerSuccessView(){
        LoginScreen loginScreen = new LoginScreen();
        this.currentScreen = "login";
        addScreen(this.currentScreen, loginScreen);
    }

    public void start(){
        RegisterScreen registerScreen = new RegisterScreen();
        this.currentScreen = "register";
        addScreen(this.currentScreen, registerScreen);
    }


    public void addScreen(String screenName, Screen screen){
        this.screens.put(screenName, screen);
        notifyObservers();
    }
}
