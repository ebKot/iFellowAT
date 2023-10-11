package Methods;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIMethods {
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

    public Response POSTMethod(String uri, ContentType type, String json, String endpoint, int code) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(uri)
                .contentType(type)
                .body(json)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(code)
                .extract().response();
    }
}
