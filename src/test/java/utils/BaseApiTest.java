package utils;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("base_url");
        RestAssured.useRelaxedHTTPSValidation();
    }
}
