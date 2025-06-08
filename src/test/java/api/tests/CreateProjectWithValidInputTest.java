package api.tests;

import api.models.PostProjectRequestBody;
import io.restassured.response.Response;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseApiTest;

@Listeners(TestListener.class)
public class CreateProjectWithValidInputTest extends BaseApiTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = "api")
    public void createProjectTest() {
        PostProjectRequestBody postRequest = createPostProjectRequestBody
                (null, "public", "TEST", "", null, "Test");
        Response response = projectApiService.createProject(postRequest);

        response.then().statusCode(200);
    }
}