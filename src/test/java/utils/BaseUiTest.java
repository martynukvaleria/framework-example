package utils;
import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectPage;
import readers.ConfigReader;
import core.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseUiTest {
    protected ConfigReader configReader;
    protected String loginUrl;

    protected LoginPage loginPage;
    protected CommonPage commonPage;
    protected ProjectPage projectPage;
    protected Dotenv dotenv;

    @BeforeMethod
    public void setup() {
        dotenv = Dotenv.load();
        configReader = new ConfigReader("src/test/resources/config.properties");
        loginUrl = dotenv.get("BASE_URL") + "/login";

        String browserType = dotenv.get("BROWSER");
        DriverFactory.createDriver(browserType);
        loginPage = new LoginPage(getDriver());
        commonPage = new CommonPage(getDriver());
        projectPage = new ProjectPage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
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