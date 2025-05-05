package api.clients;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import config.ConfigReader;

import static io.restassured.RestAssured.given;

public class UserClient {
    ConfigReader configReader = new ConfigReader("config.properties");
    Dotenv dotenv = Dotenv.load();

    private final String token = configReader.get("api_token");
    private final String baseUri = configReader.get("base_url");

    public Response getProjects() {
        return given().log().all()
                .baseUri(baseUri)
                .header("Token", token)
                .header("Accept", "application/json")
                .when()
                .get("/projects?limit=10&offset=0");
    }
}
