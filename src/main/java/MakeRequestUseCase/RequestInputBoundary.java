package MakeRequestUseCase;

/**
 * Input boundary interface for request interactor to minimize dependencies from higher level to lower level components
 */
public interface RequestInputBoundary {
    void request(RequestRequest requestRequest);
}
