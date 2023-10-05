package Steps;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class API1Steps {
    public static String charId;
    public static String charName;
    public static String charLoc;
    public static String charSpec;
    public static String charLastEpisode;
    public static String lastCharacterId;
    public static String lastCharacterName;
    public static String lastCharacterLoc;
    public static String lastCharacterSpec;

    //    Найти информацию по персонажу Морти Смит.
    public static void gettingCharInfoFunc(String id) {
        Response gettingCharInfo = given()
                .when()
                .get("/character/" + id)
                .then()
                //.log().all()
                .statusCode(200)
                .extract()
                .response();
        charId = new JSONObject(gettingCharInfo.getBody().asString()).get("id").toString();
        charName = new JSONObject(gettingCharInfo.getBody().asString()).get("name").toString();
        charLoc = new JSONObject(gettingCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpec = new JSONObject(gettingCharInfo.getBody().asString()).get("species").toString();
    }

    //    Выбрать из ответа последний эпизод, где появлялся Морти.
    public static void gettingLastEpisodeFunc() {
        Response gettingLastEpisode = given()
                .when()
                .get("/character/" + charId)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int episode = (new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        charLastEpisode = new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
    }

    //    Получить из списка последнего эпизода последнего персонажа. Получить данные по местонахождению и расе этого персонажа.
    public static void gettingLastCharacterFunc() {
        Response gettingLastCharacterId = given()
                .when()
                .get("/episode/" + charLastEpisode)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int character = (new JSONObject(gettingLastCharacterId.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharacterId = new JSONObject(gettingLastCharacterId.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");

        Response gettingLastCharacterInfo = given()
                .when()
                .get("/character/" + lastCharacterId)
                .then()
                .statusCode(200)
                .extract()
                .response();
        lastCharacterName = new JSONObject(gettingLastCharacterInfo.getBody().asString()).get("name").toString();
        lastCharacterLoc = new JSONObject(gettingLastCharacterInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        lastCharacterSpec = new JSONObject(gettingLastCharacterInfo.getBody().asString()).get("species").toString();
    }

    //    Проверить, этот персонаж той же расы и находится там же где и Морти?
    public static void assertLocFunc() {
        Assertions.assertEquals(charLoc, lastCharacterLoc, "Местоположение персонажей различается");
        if (Objects.equals(charLoc, lastCharacterLoc)) {
            System.out.println("Эти персонажи находятся в одном месте");
        }
    }
    public static void assertSpecFunc() {
        Assertions.assertEquals(charSpec, lastCharacterSpec, "Разновидность персонажей различается");
        if (Objects.equals(charSpec, lastCharacterSpec)) {
            System.out.println("Эти персонажи одного вида");
        }
    }
}