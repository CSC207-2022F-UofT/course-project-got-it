package LoginUseCase;

import screens.Presenter;

/**
 * Input boundary interface for login interactor to minimize dependencies from higher level to lower level components
 */
public interface LoginInputBoundary {
    void login(LoginRequest loginRequest);

    void navigateSignup();
}
