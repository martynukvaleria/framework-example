package ui.tests;

import org.testng.annotations.Test;
import utils.BaseUiTest;

public class LoginTest extends BaseUiTest {

    @Test(groups = "ui", description = "Verify user can log in with valid credentials")
    public void loginTest() {
        loginPage.logIn(loginUrl, configReader.get("email"), configReader.get("password"));
        commonPage.verifyPageLoaded();
    }
}
