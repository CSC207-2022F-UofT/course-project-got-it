package PastrequestsUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.Request;
import entities.User;
import screens.Presenter;

import java.util.ArrayList;

public class PastrequestsInteractor {
    private final DatabaseGateway dbGateway;

    public User user;
    private final Presenter presenter;

    public PastrequestsInteractor(DatabaseGateway dbGateway, User user, Presenter presenter) {
        this.dbGateway = dbGateway;
        this.user = user;
        this.presenter = presenter;
    }
    public ArrayList<Request> getPassedRequests(){
        return this.dbGateway.getPassedRequests(this.user);
    }
}
