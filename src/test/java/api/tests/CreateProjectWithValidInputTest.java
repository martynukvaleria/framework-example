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
public class CreateProjectWithValidInputTest extends BaseApiTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createProjectTest() {
        PostRequest postRequest = new PostRequest();

        Response response = RestAssured.given().log().all()
                .header("Token", ConfigReader.get("api_token"))
                .contentType("application/json")
                .body(postRequest)
                .when()
                .post(ConfigReader.get("base_uri"));

        response.then().statusCode(200);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("status"), "true");
    }
}