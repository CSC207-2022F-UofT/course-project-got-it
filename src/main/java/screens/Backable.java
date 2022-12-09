package screens;

/**
 * Interface to implement backable screens which have more than one buttons so that the user can move to the previous screen
 */
public interface Backable {
    public void setBackController(UserResponseController userResponseController);
}
