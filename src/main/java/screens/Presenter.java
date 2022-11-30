package screens;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

//Decides what screen to show, initially will be register
public class Presenter{

    private final ArrayList<PresenterObserver> screenObservers;
    private final ArrayList<Screen> screens;
    private Screen currentScreen;

    public Presenter(){
        this.screenObservers = new ArrayList<PresenterObserver>();
        this.screens = new ArrayList<Screen>();
    }
    public void addObserver(PresenterObserver observer){
        this.screenObservers.add(observer);
    }
    private void notifyObservers(){
        for (PresenterObserver screenObserver : this.screenObservers) {
            screenObserver.updateScreen(this.currentScreen);
        }
    }

    public void addScreen(Screen screen){
        this.currentScreen = screen;
        this.screens.add(screen);
        notifyObservers();
    }
}
