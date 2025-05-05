package api.tests;

import api.models.PostRequest;
import api.services.ProjectApiService;
import io.restassured.response.Response;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseApiTest;

import java.util.UUID;

@Listeners(TestListener.class)
public class CreateProjectWithNonValidInputTest extends BaseApiTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createProjectTest() {
        String access = "t";
        String accessType = "public";
        String code = "Test_" + UUID.randomUUID();
        String description = "";
        Integer group = 0;
        String tittle = null;

        PostRequest postRequest = new PostRequest(access, accessType, code, description, group, tittle);
        ProjectApiService projectApiService = new ProjectApiService(configReader);
        Response response = projectApiService.createProject(postRequest);

        response.then().statusCode(400);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("errorMessage"), "Expected error message in response.");
        Assert.assertFalse(response.jsonPath().getBoolean("status"), "Expected status=false for invalid request.");
    }
}
