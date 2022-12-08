package screens;

import LoginUseCase.LoginResponse;
import entities.User;

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
    public void showHomescreen(){
        screens.Homescreen homescreen = new screens.Homescreen();
        this.currentScreen = "homescreen";
        addScreen(this.currentScreen, homescreen);
    }
    public void showProfile(String name, String address, String email, String password){
        System.out.println(name + " " + address + " " + email + " " + password);
        Profilescreen profilescreen = new Profilescreen(name, address, email, password);
        this.currentScreen = "profilescreen";
        addScreen(this.currentScreen, profilescreen);
    }
    public void showPastRequests(){
        Pastrequestsscreen pastrequestsscreen = new Pastrequestsscreen("","","");
        this.currentScreen = "pastrequests";
        addScreen(this.currentScreen, pastrequestsscreen);
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
    public void showMakeRequest(){
        NewRequestScreen makeRequestScreen = new NewRequestScreen();
        this.currentScreen = "makeRequest";
        addScreen(this.currentScreen, makeRequestScreen);
    }
    public void showMakeRequestSuccess(){
        RequestMadeScreen requestMadeScreen = new RequestMadeScreen();
        this.currentScreen = "requestMade";
        addScreen(this.currentScreen, requestMadeScreen);
    }
    public void showMakeRequestFail(){
        RequestFailedScreen requestFailedScreen = new RequestFailedScreen();
        this.currentScreen = "requestFailed";
        addScreen(this.currentScreen, requestFailedScreen);
    }
    public void start(){
        RegisterScreen registerScreen = new RegisterScreen();
        this.currentScreen = "register";
        addScreen(this.currentScreen, registerScreen);
    }

    public void addScreen(String screenName, Screen screen){
        System.out.println(screens.get(this.currentScreen));
        this.screens.put(screenName, screen);
        notifyObservers();
    }

    public void showPreviousScreen() {
        Object[] keys = screens.keySet().toArray();
        Object lastScreen = keys[keys.length - 1];
        Object secondLast = keys[keys.length - 2];
        screens.remove(lastScreen.toString());
        this.currentScreen = secondLast.toString();
        notifyObservers();
    }

    public void showCurrentrequest() {
        Currentrequestscreen currentrequestscreen = new Currentrequestscreen("","","","","","", "");
        this.currentScreen = "currenttrequests";
        addScreen(this.currentScreen, currentrequestscreen);
    }
}
