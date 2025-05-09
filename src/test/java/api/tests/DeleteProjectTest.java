package api.tests;

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
        String code = "DEMO";

        Response response = projectApiService.deleteProject(code);
        response.then().statusCode(200);
    }
}
