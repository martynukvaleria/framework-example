package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import utils.BaseUiTest;

public class LoginTest extends BaseUiTest {

    LoginPage loginPage;
    CommonPage commonPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        commonPage = new CommonPage(getDriver());
    }

    @Test(groups = "ui")
    public void testLoginButtonVisible() {
        loginPage.logIn(loginUrl, configReader.get("email"), configReader.get("password"));
        commonPage.verifyPageLoaded();
    }

    @AfterMethod
    public void afterMethod() {
    }
}
