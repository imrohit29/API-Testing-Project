package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CartCheckoutAPITest {

    @Test
    public void testAddToCart() {
        String token = "<use_token_from_login>";

        RestAssured.baseURI = "https://example.com/api";

        given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"productId\":\"123\", \"quantity\":2}")
        .when()
            .post("/cart/add")
        .then()
            .statusCode(200);
    }

    @Test
    public void testCheckout() {
        String token = "<use_token_from_login>";

        RestAssured.baseURI = "https://example.com/api";

        given()
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .body("{\"paymentMethod\":\"card\", \"address\":\"123 Street, City\"}")
        .when()
            .post("/checkout")
        .then()
            .statusCode(200);
    }
}
