package utils;

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

    @BeforeMethod
    public void setup() {
        configReader = new ConfigReader("src/test/resources/config.properties");
        loginUrl = configReader.get("base_url") + "/login";

        String browserType = configReader.get("browserType");
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