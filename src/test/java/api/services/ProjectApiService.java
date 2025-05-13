package api.services;

import api.models.PatchProjectRequestBody;
import api.models.PostProjectRequestBody;
import io.restassured.response.Response;
import config.ConfigReader;

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
        return given().log().all()
                .header("Token", token)
                .contentType("application/json")
                .when()
                .delete(baseUri + "/" + code);
    }

    public Response editProject(PatchProjectRequestBody projectRequestBody, String code) {
        return given().log().all()
                .header("Token", token)
                .contentType("application/json")
                .body(projectRequestBody)
                .when()
                .patch(baseUri + "/" + code);
    }

    public Response getProjects(int limit, int offset) {
        return given().log().all()
                .baseUri(baseUri)
                .header("accept", "application/json")
                .header("Token", token)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .when()
                .get();
    }
}
