package Steps;

import Methods.APIMethods;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class API1Steps {
    private static final String uri1 = "https://rickandmortyapi.com/api";
    private static final int code1 = 200;
    public static String charId, charName, charLoc, charSpec, charLastEp, lastCharId, lastCharName, lastCharLoc, lastCharSpec;


    @Step("Найти информацию по персонажу c id {id}.")
    public static void gettingCharInfoFunc(String id) {
        Response gettingCharInfo = new APIMethods().GETMethod(uri1, "/character/" + id, code1);
        charId = new JSONObject(gettingCharInfo.getBody().asString()).get("id").toString();
        charName = new JSONObject(gettingCharInfo.getBody().asString()).get("name").toString();
        charLoc = new JSONObject(gettingCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpec = new JSONObject(gettingCharInfo.getBody().asString()).get("species").toString();
        gettingCharInfo.then().log().body();
    }

    @Step("Выбрать из ответа последний эпизод, где появлялся первый персонаж.")
    public static void gettingLastEpFunc() {
        Response gettingLastEp = new APIMethods().GETMethod(uri1, "/character/" + charId, code1);
        int episode = (new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").length() - 1);
        charLastEp = new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
    }

    @Step("Получить из списка последнего эпизода последнего персонажа. Получить данные по местонахождению и расе второго персонажа.")
    public static void gettingLastCharFunc() {
        Response gettingLastCharId = new APIMethods().GETMethod(uri1, "/episode/" + charLastEp, code1);
        int character = (new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharId = new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");

        Response gettingLastCharInfo = new APIMethods().GETMethod(uri1, "/character/" + lastCharId, code1);
        lastCharName = new JSONObject(gettingLastCharInfo.getBody().asString()).get("name").toString();
        lastCharLoc = new JSONObject(gettingLastCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        lastCharSpec = new JSONObject(gettingLastCharInfo.getBody().asString()).get("species").toString();
        gettingLastCharInfo.then().log().body();
    }

    @Step("Проверить, второй персонаж той же расы как и первый?")
    public static void assertSpecFunc() {
        try {
            Assertions.assertEquals(charSpec, lastCharSpec, "Разновидность персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Проверить, второй персонаж находится там же где и первый?")
    public static void assertLocFunc() {
        try {
            Assertions.assertEquals(charLoc, lastCharLoc, "Местоположение персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}