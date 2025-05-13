package api.tests;

import api.models.PatchProjectRequestBody;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseApiTest;

public class EditProjectTitleTest extends BaseApiTest {
    @Test
    public void createProjectTest() {
        PatchProjectRequestBody patchProjectRequestBody = createPatchProjectRequestBody
                ("Test1", "TEST", "");
        Response response = projectApiService.editProject(patchProjectRequestBody, "TEST");

        response.then().statusCode(200);
    }
}

//ui те же тесты + cucumber + logging + allure
