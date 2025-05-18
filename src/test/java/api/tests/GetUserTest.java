package api.tests;

import api.models.PostProjectRequestBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseApiTest;

public class GetUserTest extends BaseApiTest {

    @BeforeMethod
    public void setUp() {
        PostProjectRequestBody project = createPostProjectRequestBody
                (null, "public", "DEMO", " ", null, "DEMO");
        projectApiService.createProject(project).then().statusCode(200);
    }

    @Test(groups = "api")
    public void getProjectsShouldReturn200() {
        Response response = projectApiService.getProjects(10, 0);

        int count = response.jsonPath().getInt("result.count");
        Assert.assertEquals(count, 2, "Projects amount non equals 2");
    }

    @AfterMethod
    public void afterMethod() {
        projectApiService.deleteProject("DEMO").then().statusCode(200);
    }

}
