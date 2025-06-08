package ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUiTest;

public class CreateProjectWithNonValidInput extends BaseUiTest {
    String name;

    @BeforeMethod
    public void setUp() {
        loginPage.logIn(loginUrl, configReader.get("email"), configReader.get("password"));
        name = commonPage.projectName();
    }

    @Test(groups = "ui", description = "Verify project with non valid can not be created")
    public void createProjectWithNonValidInput() {
        String code = "T";
        String accessType = "public";
        String message = "Data is invalid";

        commonPage.verifyPageLoaded();
        commonPage.createProject(name, code, accessType);
        commonPage.checkAlert(message);
    }
}
