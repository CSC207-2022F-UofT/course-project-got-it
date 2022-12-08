package LoginUseCase;

/**
 * Response to user entering correct credentials
 */
public class LoginResponse {

    private boolean loggedIn;
    private String email;
    private String password;
    public LoginResponse(boolean loggedIn, String email, String password){
        this.loggedIn = loggedIn;
        this.email = email;
        this.password = password;
    }

    public LoginResponse(boolean isLoggedIn){
        this.loggedIn = isLoggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
