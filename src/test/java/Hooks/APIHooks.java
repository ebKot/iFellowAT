package Hooks;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class APIHooks {
    @BeforeAll
    public static void setup() {
        RestAssured.filters(new AllureRestAssured());
    }
}
