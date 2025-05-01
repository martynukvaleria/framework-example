package api.clients;

import io.restassured.response.Response;
import config.ConfigReader;

import static io.restassured.RestAssured.given;

public class UserClient {

    private final String token = ConfigReader.get("api_token");
    private final String baseUri = ConfigReader.get("base_url");

    public Response getProjects() {
        return given().log().all()
                .baseUri(baseUri)
                .header("Token", token)
                .header("Accept", "application/json")
                .when()
                .get("/projects?limit=10&offset=0");
    }
}
