package PastRequestUseCase;

import DatabaseGateway.DatabaseGateway;
import entities.Request;
import entities.User;
import screens.Presenter;

import java.util.ArrayList;

public class PastRequestInteractor implements PastRequestInputBoundary {
    private final DatabaseGateway dbGateway;
    private User user;
    private final Presenter presenter;
    public PastRequestInteractor(DatabaseGateway dbGateway, Presenter presenter, User currentUser) {
        this.dbGateway = dbGateway;
        this.presenter = presenter;
        this.user = currentUser;
    }

    @Override
    public void pastRequests(PastRequestRequest pastRequests) {
        ArrayList<Request> pastRequestList = dbGateway.getPastRequests(user);
        if (pastRequestList.isEmpty())
            this.presenter.noPastRequests();
        else
            this.presenter.showPastRequests(pastRequestList);



    }

    }