package api.tests;

import api.models.PostRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseApiTest;
import config.ConfigReader;

@Listeners(TestListener.class)
public class CreateProjectWithNonValidInputTest extends BaseApiTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createProjectTest() {
        PostRequest postRequest = new PostRequest(null, "public", "t", "", null, "Test");

        Response response = RestAssured.given().log().all()
                .header("Token", ConfigReader.get("api_token"))
                .contentType("application/json")
                .body(postRequest)
                .when()
                .post(ConfigReader.get("base_uri"));

        response.then().statusCode(400);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("errorMessage"), "Data is invalid.");
        Assert.assertFalse(response.jsonPath().getBoolean("status"), "Expected API to reject 1-character code");
    }
}
