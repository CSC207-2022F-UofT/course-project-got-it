package screens;

/**
 * Interface for observer pattern. Only implemented by the app
 */
public interface PresenterObserver {
    public void updateScreen(String screenName, Screen newScreen);
}
