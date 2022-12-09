package RegisterUseCase;

/**
 *Request to interactor to make a new user account
 */
public class RegisterRequest {
    private String address;

    private String name;

    private String email;
    private String password;
    private String repeatPassword;

    public RegisterRequest(String name, String address, String email, String password, String repeatPassword) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
