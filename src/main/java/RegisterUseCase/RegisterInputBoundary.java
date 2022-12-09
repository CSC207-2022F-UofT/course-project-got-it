package RegisterUseCase;

/**
 * Input boundary interface for register interactor to minimize dependencies from higher level to lower level components
 */
public interface RegisterInputBoundary {
    void create(RegisterRequest registerRequest);
}
