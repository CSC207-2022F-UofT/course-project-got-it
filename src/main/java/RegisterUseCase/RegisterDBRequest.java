package RegisterUseCase;

public class RegisterDBRequest {
    private final String email;
    private String password;
    private String address;
    private String name;

    public RegisterDBRequest(String address, String email, String password, String name){
        this.email = email;
        this.password = password;
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getName(){
        return this.name;
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
