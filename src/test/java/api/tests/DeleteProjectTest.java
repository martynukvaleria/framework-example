package api.tests;

import api.services.ProjectApiService;
import io.restassured.response.Response;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseApiTest;

@Listeners(TestListener.class)
public class DeleteProjectTest extends BaseApiTest {
    @Test
    public void deleteProjectTest() {
        ProjectApiService projectApiService = new ProjectApiService(configReader);
        Response response = projectApiService.deleteProject();

        response.then().statusCode(200);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("status"), "true");
    }
}
