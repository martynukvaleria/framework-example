package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseApiTest;
import config.ConfigReader;

@Listeners(TestListener.class)
public class DeleteProjectTest extends BaseApiTest {
    @Test
    public void deleteProjectTest() {

        Response response = RestAssured.given().log().all()
                .header("Token", ConfigReader.get("api_token"))
                .contentType("application/json")
                .when()
                .delete(ConfigReader.get("base_uri") + "/TEST");

        response.then().statusCode(200);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("status"), "true");
    }
}
