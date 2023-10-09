import Hooks.Hooks;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static Steps.API2Steps.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Углубление в API")
public class API2Test extends Hooks {

    @Test
    @Order(1)
    @DisplayName("Проверить, что получили ответ 200.")
    public void sendBodyTest() throws IOException {
        createJSONFunc();
        sendBodyFunc();
    }

    @Test
    @Order(2)
    @DisplayName("Свериться, что полученный response имеет \"name\": \"Tomato\"")
    public void assertNameTest() throws IOException {
        createJSONFunc();
        assertNameFunc();
    }

    @Test
    @Order(3)
    @DisplayName("Свериться, что полученный response имеет \"job\": \"Eat maket\"")
    public void assertJobTest() throws IOException {
        createJSONFunc();
        assertJobFunc();
    }

    @Test
    @Order(4)
    @DisplayName("Свериться, что полученный response имеет \"id\": \"325\"")
    public void assertIdTest() throws IOException {
        createJSONFunc();
        assertIdFunc();
    }

    @Test
    @Order(5)
    @DisplayName("Свериться, что полученный response имеет \"createdAt\": \"2021-08-03T10:22:44.071Z\"")
    public void assertCreatedAtTest() throws IOException {
        createJSONFunc();
        assertCreatedAtFunc();
    }
}