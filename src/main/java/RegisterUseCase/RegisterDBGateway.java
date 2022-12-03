package RegisterUseCase;

public interface RegisterDBGateway {
        boolean exists(String identifier);
        void save(RegisterDBRequest request);
}

