package screens;

import ProfilescreenUseCase.ProfilescreenInteractor;
import entities.User;

import java.util.Arrays;
import java.util.Objects;

public class ProfilescreenController implements Controller{
    public  ProfilescreenInteractor interactor;
    public User user;

    public ProfilescreenController(ProfilescreenInteractor interactor) {
        this.interactor = interactor;
        this.user = interactor.user;
    }
    public void change(String name, String email, String password, double[] coords){
        if(!(Objects.equals(name, this.user.getName()))){
            interactor.changeName(name);
        }
        if(!(Objects.equals(password, this.user.getPassword()))){
            interactor.changePassword(password);
        }

        if(!(Objects.equals(email, this.user.getEmail()))){
            interactor.changeEmail(email);
            System.out.println(this.user.getEmail());
        }
        if(!(Arrays.equals(coords, this.user.getHomeCoordinates()))){
            interactor.changeAddress(coords);
        }

}}
