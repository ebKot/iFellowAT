package Steps;

import Methods.APIMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class API2Steps {
    private static final String uri2 = "https://reqres.in/";
    private static final int code2 = 201;
    public static JSONObject bodyJson;

    public static void createUserFunc() throws IOException {
        bodyJson = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFile.json"))));
        bodyJson.put("name", "Tomato");
        bodyJson.put("job", "Eat maket");

        Response createUser = new APIMethods().POSTMethod(uri2, ContentType.JSON, bodyJson.toString(), "/api/users", code2);

        createUser.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchema.json")); // валидируем полученный response через json схему
    }
}