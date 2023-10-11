import Hooks.APIHooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static Steps.API1Steps.*;
import static Steps.API2Steps.createUserFunc;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Курс по автоматизированному тестированию iFellow")
@Feature("Изучение API с Rest Assured")
@DisplayName("Лекция №5. API")
@Owner("ebKot")
public class APITest extends APIHooks {

    @Test
    @Order(1)
    @DisplayName("Погружение в API")
    public void API1Test() {
        gettingCharInfoFunc("2");
        gettingLastEpFunc();
        gettingLastCharFunc();
        assertSpecFunc();
        assertLocFunc();
    }

    @Test
    @Order(2)
    @DisplayName("Углубление в API")
    public void sendBodyTest() throws IOException {
        createUserFunc();
    }
}