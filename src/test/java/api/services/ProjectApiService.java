package api.services;

import api.models.PatchRequest;
import api.models.PostRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import config.ConfigReader;

public class ProjectApiService {
    private final ConfigReader config;
    Dotenv dotenv = Dotenv.load();

    public ProjectApiService(ConfigReader config) {
        this.config = config;
    }

    public Response createProject(PostRequest postRequest) {
        return RestAssured.given().log().all()
                .header("Token", config.get("api_token"))
                .contentType("application/json")
                .body(postRequest)
                .when()
                .post(config.get("base_uri"));
    }
    public Response deleteProject(){
        return RestAssured.given().log().all()
                .header("Token", config.get("api_token"))
                .contentType("application/json")
                .when()
                .delete(config.get("base_uri") + "/TEST");
    }
    public Response editProject(PatchRequest patchRequest){
        return RestAssured.given().log().all()
                .header("Token", config.get("api_token"))
                .contentType("application/json")
                .body(patchRequest)
                .when()
                .patch(config.get("base_uri"));
    }
}
