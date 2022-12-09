package MakeRequestUseCase;
//KEEP MINE
public class RequestResponse {

    private boolean validInput;

    public RequestResponse(boolean validInput){
        this.validInput = validInput;
    }

    public boolean isValidInput() {
        return validInput;
    }

    public void setValidInput(boolean validInput) {
        this.validInput = validInput;
    }

}
