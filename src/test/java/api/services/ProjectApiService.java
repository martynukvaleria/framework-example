package api.services;

import api.models.PatchProjectRequestBody;
import api.models.PostProjectRequestBody;
import io.restassured.response.Response;
import readers.ConfigReader;

import static io.restassured.RestAssured.given;

public class ProjectApiService {
    private final String token;
    private final String baseUri;


    public ProjectApiService(ConfigReader config) {
        this.token = config.get("api_token");
        this.baseUri = config.get("base_uri");
    }

    public Response createProject(PostProjectRequestBody postProjectRequestBody) {
        return given().log().all()
                .header("Token", token)
                .contentType("application/json")
                .body(postProjectRequestBody)
                .when()
                .post(baseUri);
    }

    public Response deleteProject(String code) {
        return given()
                .header("Token", token)
                .contentType("application/json")
                .when()
                .delete(baseUri + "/" + code);
    }

    public Response editProject(PatchProjectRequestBody projectRequestBody) {
        return given()
                .header("Token", token)
                .contentType("application/json")
                .body(projectRequestBody)
                .when()
                .patch(baseUri);
    }

    public Response getProjects(int limit, int offset) {
        return given()
                .baseUri(baseUri)
                .header("accept", "application/json")
                .header("Token", token)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .when()
                .get();
    }
}
