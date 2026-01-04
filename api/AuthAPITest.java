package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthAPITest {

    @Test
    public void testLogin() {
        RestAssured.baseURI = "https://example.com/api";

        Response res = given()
            .header("Content-Type", "application/json")
            .body("{\"username\":\"rohit\",\"password\":\"12345\"}")
            .when()
            .post("/login")
            .then()
            .statusCode(200)
            .extract().response();

        String token = res.jsonPath().getString("token");
        System.out.println("Auth Token: " + token);
    }
}
