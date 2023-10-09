package Steps;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class API2Steps {
    public static JSONObject bodyJson;

    public static void createJSONFunc() throws IOException {
        bodyJson = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFile.json"))));
        bodyJson.put("name", "Potato");
        bodyJson.put("name", "Tomato");
        bodyJson.put("job", "Eat maket");
    }

    public static void sendBodyFunc() {
        given()
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    public static void assertNameFunc() {
        given()
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .assertThat()
                .body("name", equalTo("Tomato"))
                .extract().response();
    }

    public static void assertJobFunc() {
        given()
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .assertThat()
                .body("job", equalTo("Eat maket"))
                .extract().response();
    }

    public static void assertIdFunc() {
        given()
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .assertThat()
                .body("id", equalTo("325"))
                .extract().response();
    }

    public static void assertCreatedAtFunc() {
        given()
                .contentType(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .assertThat()
                .body("createdAt", equalTo("2021-08-03T10:22:44.071Z"))
                .extract().response();
    }

}
