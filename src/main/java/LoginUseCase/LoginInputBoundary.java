package LoginUseCase;

import screens.Presenter;

public interface LoginInputBoundary {
    void login(LoginRequest loginRequest);

    void navigateSignup();
}
