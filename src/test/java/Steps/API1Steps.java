package Steps;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class API1Steps {
    private static final String uri1 = "https://rickandmortyapi.com/api";
    private static final int code1 = 200;
    public static String charId, charName, charLoc, charSpec, charLastEp, lastCharId, lastCharName, lastCharLoc, lastCharSpec;


    public Response GETMethod(String uri, String endpoint, int code) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(uri)
                .when()
                .get(endpoint)
                .then()
                .statusCode(code)
                .extract()
                .response();
    }


    //    Найти информацию по персонажу Морти Смит.
    public static void gettingCharInfoFunc(String id) {
        Response gettingCharInfo = new API1Steps().GETMethod(uri1, "/character/" + id, code1);
        charId = new JSONObject(gettingCharInfo.getBody().asString()).get("id").toString();
        charName = new JSONObject(gettingCharInfo.getBody().asString()).get("name").toString();
        charLoc = new JSONObject(gettingCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpec = new JSONObject(gettingCharInfo.getBody().asString()).get("species").toString();
        gettingCharInfo.then().log().body();
    }

    //    Выбрать из ответа последний эпизод, где появлялся Морти.
    public static void gettingLastEpFunc() {
        Response gettingLastEp = new API1Steps().GETMethod(uri1, "/character/" + charId, code1);
        int episode = (new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").length() - 1);
        charLastEp = new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
    }

    //    Получить из списка последнего эпизода последнего персонажа. Получить данные по местонахождению и расе этого персонажа.
    public static void gettingLastCharFunc() {
        Response gettingLastCharId = new API1Steps().GETMethod(uri1, "/episode/" + charLastEp, code1);
        int character = (new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharId = new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");

        Response gettingLastCharInfo = new API1Steps().GETMethod(uri1, "/character/" + lastCharId, code1);
        lastCharName = new JSONObject(gettingLastCharInfo.getBody().asString()).get("name").toString();
        lastCharLoc = new JSONObject(gettingLastCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        lastCharSpec = new JSONObject(gettingLastCharInfo.getBody().asString()).get("species").toString();
        gettingLastCharInfo.then().log().body();
    }

    //    Проверить, этот персонаж той же расы и находится там же где и Морти?
    public static void assertLocFunc() {
        try {
            Assertions.assertEquals(charLoc, lastCharLoc, "Местоположение персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assertSpecFunc() {
        try {
            Assertions.assertEquals(charSpec, lastCharSpec, "Разновидность персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}