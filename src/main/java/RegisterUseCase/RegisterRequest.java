package RegisterUseCase;

public class RegisterRequest {

    private String name;

    private double[] coords;
    private String email;
    private String password;
    private String repeatPassword;

    public RegisterRequest(String name, double[] coords, String email, String password, String repeatPassword) {
        this.name = name;
        this.coords = coords;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getCoords() {
        return coords;
    }

    public void setCoords(double[] coords){
        this.coords = coords;
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
