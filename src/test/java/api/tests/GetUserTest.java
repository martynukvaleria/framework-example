package api.tests;

import api.clients.UserClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetUserTest {

    UserClient userClient = new UserClient();

    @Test
    public void getProjectsShouldReturn200() {
        Response response = userClient.getProjects();

        response.then().statusCode(200);
    }
}
