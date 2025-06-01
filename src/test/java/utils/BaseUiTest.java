package utils;

import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectPage;
import readers.ConfigReader;
import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUiTest {
    protected ConfigReader configReader;
    protected String loginUrl;

    protected LoginPage loginPage;
    protected CommonPage commonPage;
    protected ProjectPage projectPage;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader("src/test/resources/config.properties");
        loginUrl = configReader.get("base_url") + "/login";

        String browserType = configReader.get("browser");
        DriverFactory.createDriver(browserType);
        loginPage = new LoginPage(getDriver());
        commonPage = new CommonPage(getDriver());
        projectPage = new ProjectPage(getDriver());
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}