package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProductSearchAPITest {

    @Test
    public void testSearchProduct() {
        String token = "<use_token_from_login>";  // Replace with actual token

        RestAssured.baseURI = "https://example.com/api";

        given()
            .header("Authorization", "Bearer " + token)
            .queryParam("search", "phone")
        .when()
            .get("/products")
        .then()
            .statusCode(200)
            .body("products[0].name", equalTo("iPhone"));
    }
}
