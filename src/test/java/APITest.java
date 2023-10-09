import org.junit.jupiter.api.*;

import java.io.IOException;

import static Steps.API1Steps.*;
import static Steps.API2Steps.createUserFunc;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Лекция №5. API")
public class APITest {

    @Test
    @Order(1)
    @DisplayName("Погружение в API")
    public void API1Test() {
        gettingCharInfoFunc("2");
        gettingLastEpFunc();
        gettingLastCharFunc();
        assertLocFunc();
        assertSpecFunc();
    }

    @Test
    @Order(2)
    @DisplayName("Углубление в API")
    public void sendBodyTest() throws IOException {
        createUserFunc();
    }
}