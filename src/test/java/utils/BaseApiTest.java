package utils;

import api.models.PatchProjectRequestBody;
import api.models.PostProjectRequestBody;
import api.services.ProjectApiService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import readers.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static core.DriverFactory.getDriver;

public class BaseApiTest {
    protected ConfigReader configReader;
    protected ProjectApiService projectApiService;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader("src/test/resources/config.properties");
        projectApiService = new ProjectApiService(configReader);
        RestAssured.baseURI = configReader.get("base_url");
        RestAssured.useRelaxedHTTPSValidation();
    }
    protected PostProjectRequestBody createPostProjectRequestBody(String access, String access_type, String code, String description, Integer group, String title) {
        return new PostProjectRequestBody(access, access_type, code, description, group, title);
    }

    protected PatchProjectRequestBody createPatchProjectRequestBody(String title, String code, String description) {
        return new PatchProjectRequestBody(title, code, description);
    }
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
}
