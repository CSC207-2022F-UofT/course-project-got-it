package MakeRequestUseCase;

import APIGateway.APIGateway;
import DatabaseGateway.DatabaseGateway;
import RegisterUseCase.RegisterDBRequest;
import entities.Request;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.Presenter;

import java.util.HashMap;

class RequestInteractorTest {
    String item = ("laptop");
    String description = "13 inch MacBook Pro in room 2200";
    double[] itemAddress = {43.65998888952553, -79.3974562110199};
    double[] deliveryAddress = {43.65240111263872, -79.39230166779534};
    String deliveryNotes = "Leave at the door.";
    double[] homeAddress = {43.65891059985348, -79.3830646246287};
    double[] address2 = {123.456, 654.321};
    User requester = new User(homeAddress, "roger@gmail.com", "Password", "Roger Smith");
    APIGateway gateway = new APIGateway() {
        @Override
        public double[] getGeocode(String address) {
            return new double[0];
        }
    };
    DatabaseGateway dbGateway = new DatabaseGateway() {
        @Override
        public boolean validateAndLogin(String email, String password) {
            return false;
        }

        @Override
        public boolean exists(String email) {
            return false;
        }

        @Override
        public void save(RegisterDBRequest request) {

        }

        @Override
        public String storeRequestInfo(Request requestRequest) {
            return null;
        }

        @Override
        public boolean assignClosestDriver(String requestID) {
            return false;
        }

        @Override
        public HashMap<String, Object> getLoggedInUser() {
            return null;
        }
    };
    Presenter presenter = new Presenter();

    @Test
    void TestRequest_PresenterSignalsFail() {
        Presenter presenter = new Presenter();
        RequestRequest requestObj = new RequestRequest(item, itemAddress, deliveryAddress, description, deliveryNotes,
                requester);
        RequestInteractor interactor = new RequestInteractor(gateway, dbGateway, presenter);
        Assertions.assertEquals(presenter.currentScreen,"requestMade");
    }
}

