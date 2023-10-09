package Steps;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class API2Steps {
    private static final String uri2 = "https://reqres.in/";
    private static final int code2 = 201;
    public static JSONObject bodyJson;

    public static void createUserFunc() throws IOException {
        bodyJson = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFile.json"))));
        bodyJson.put("name", "Tomato");
        bodyJson.put("job", "Eat maket");

        given()
                .header("Content-type", "application/json")
                .baseUri(uri2)
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().body()
                .assertThat()
                .statusCode(code2)
                .body(matchesJsonSchemaInClasspath("jsonSchema.json")) // валидируем полученный response через json схему
                .extract().response();
    }
}