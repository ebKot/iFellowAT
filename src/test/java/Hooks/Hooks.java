package Hooks;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class Hooks {
    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }
}