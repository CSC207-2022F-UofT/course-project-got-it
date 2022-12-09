package screens;

import LoginUseCase.LoginResponse;
import entities.Request;
import entities.User;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Decides what screen to show, initially will be login screen
 * The presenter uses the observer design patten where the observer is the app and the presenter is observable
 * Whenever the hashmap changes, the app observes it
 */
public class Presenter{

    private final ArrayList<PresenterObserver> screenObservers;
    private final LinkedHashMap<String, Screen> screens;
    public String currentScreen;


    public Presenter(){
        this.screenObservers = new ArrayList<PresenterObserver>();
        this.screens = new LinkedHashMap<String, Screen>();
    }
    /**
     * Displays the login success view when the user successfully logs in
     * @param response when the user logs in
     */
    public void loginSuccess(LoginResponse response){
        LoggedInScreen loginSuccess = new LoggedInScreen(response.getEmail());
        this.currentScreen = "loginSuccess";
        this.addScreen(this.currentScreen, loginSuccess);
    }
    /**
     * Displays the login failed view when the user attempts to log in with the wrong credentials
     * and prompts the user to reenter the correct credentials
     */
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
    public void showPastRequests(ArrayList<Request> pastRequests){
        if(pastRequests.size() > 2){
            this.currentScreen = "pastrequests";
            this.addScreen(this.currentScreen, new Pastrequestsscreen(pastRequests.get(0).getItemName(),
                    pastRequests.get(1).getItemName(), pastRequests.get(2).getItemName()));
        } else if (pastRequests.size() == 2) {
            this.currentScreen = "pastrequests";
            this.addScreen(this.currentScreen, new Pastrequestsscreen(pastRequests.get(0).getItemName(),
                    pastRequests.get(1).getItemName(), ""));
        } else if (pastRequests.size() == 1) {
            this.currentScreen = "pastrequests";
            this.addScreen(this.currentScreen, new Pastrequestsscreen(
                    pastRequests.get(0).getItemName(), "", ""));
        }
        else {
            this.currentScreen = "noRequests";
            this.addScreen("noRequests", new Norequestscreen());
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
        RequestMakeFailed requestFailedScreen = new RequestMakeFailed();
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

    /**
     * Removes the current screen and replaces with previous screen
     */
    public void showPreviousScreen() {
        Object[] keys = screens.keySet().toArray();
        Object lastScreen = keys[keys.length - 1];
        Object secondLast = keys[keys.length - 2];
        screens.remove(lastScreen.toString());
        this.currentScreen = secondLast.toString();
        notifyObservers();
    }

    public void showDeliveryTime(String time){
        Deliverytimescreen deliverytimescreen = new Deliverytimescreen(time);
        this.currentScreen = "deliveryTime";
        addScreen(this.currentScreen, deliverytimescreen);
        notifyObservers();
    }

    public void showDeliveryTimeFailed(){
        DeliveryTimeFailed deliveryTimeFailed = new DeliveryTimeFailed();
        this.currentScreen = "deliveryTimeFailed";
        addScreen(this.currentScreen, deliveryTimeFailed);
    }
    public void showCurrentrequest(String itemName, String itemDescription, String itemLocation,
                                   String deliveryLocation, String driverName) {
        Currentrequestscreen currentrequestscreen = new Currentrequestscreen(itemName,itemDescription,itemLocation,deliveryLocation,driverName);
        this.currentScreen = "currenttrequests";
        addScreen(this.currentScreen, currentrequestscreen);
    }
}
