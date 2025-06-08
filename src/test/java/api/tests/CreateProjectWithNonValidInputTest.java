package api.tests;

import api.models.PostProjectRequestBody;
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

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = "api")
    public void createProjectTest() {
        String access = null;
        String accessType = "public";
        String code = "Test_" + UUID.randomUUID();
        String description = "";
        Integer group = null;
        String title = "t";

        PostProjectRequestBody postRequest = createPostProjectRequestBody(access, accessType, code, description, group, title);
        Response response = projectApiService.createProject(postRequest);

        response.then().statusCode(400);
        Assert.assertTrue(response.jsonPath().getString("errorFields.error").contains("Project code can contain only latin alphabet symbols."));
    }
}
