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

@Listeners(TestListener.class)
public class CreateProjectWithValidInputTest extends BaseApiTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createProjectTest() {
        PostRequest postRequest = new PostRequest();
        ProjectApiService projectApiService = new ProjectApiService(configReader);
        Response response = projectApiService.createProject(postRequest);

        response.then().statusCode(200);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("status"), "true");
    }
}