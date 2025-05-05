package utils;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    protected ConfigReader configReader;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader("src/test/resources/config.properties");
        RestAssured.baseURI = configReader.get("base_url");
        RestAssured.useRelaxedHTTPSValidation();
    }
}
