package utils;

import config.ConfigReader;
import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUiTest {
    protected ConfigReader configReader;
    protected String loginUrl;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader("src/test/resources/config.properties");
        loginUrl = configReader.get("base_url") + "/login";

        String browserType = configReader.get("browser");
        DriverFactory.createDriver(browserType);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}