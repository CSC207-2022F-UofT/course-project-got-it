package screens;

import HomescreenUseCase.HomescreenInteractor;

import java.util.Objects;

public class HomescreenController implements Controller{

    private final HomescreenInteractor interactor;
    public HomescreenController(HomescreenInteractor interactor){
        this.interactor = interactor;
    }
    public void navigate(String source){
        System.out.println(source);
        if(Objects.equals(source, "navigateProfile")){
            System.out.println(source);
            interactor.navigateProfile();
        }
        if(Objects.equals(source, "navigateNewrequest")){
            System.out.println(source);
            interactor.navigateNewrequest();
        }

        if(Objects.equals(source, "navigatePastrequests")){
            System.out.println(source);
            interactor.navigatePastrequests();
        }
        if(Objects.equals(source, "navigateCurrentrequests")){
            System.out.println(source);
            interactor.navigateCurrentrequests();
        }
    }
}
