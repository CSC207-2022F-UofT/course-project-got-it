package MakeRequestUseCase;

public interface RequestDBGateway {
    storeRequestInfo(String requester, String item_loq, String req_loc, String description);
}

@Override
public void storeRequestInfo(String email, String password) {
    // store to db (function to be added to DB User)
}