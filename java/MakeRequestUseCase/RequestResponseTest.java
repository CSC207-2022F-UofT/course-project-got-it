package MakeRequestUseCase;

import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.Test;

public abstract class RequestResponseTest {

    @Test
    public void TestRequestResponse_True() {
        boolean validInput = true;
        Assertions.assertTrue(new RequestResponse(validInput).isValidInput());
    }

//    @Test
//    public void TestValidRequest_True() {
//        Assertions.assertTrue(new RequestResponse());
//    }



}
