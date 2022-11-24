package RegisterUseCase;

public class RegisterDBRequest {
    private final String email;
    private String password;

    public RegisterDBRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
