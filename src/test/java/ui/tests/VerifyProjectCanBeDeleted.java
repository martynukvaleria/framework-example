package ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUiTest;

public class VerifyProjectCanBeDeleted extends BaseUiTest {
    String name;

    @BeforeMethod
    public void setUp() {
        loginPage.logIn(loginUrl, dotenv.get("EMAIL"), dotenv.get("PASSWORD"));
        name = commonPage.projectName();
    }

    @Test(groups = "ui", description = "Verify existing project can be deleted")
    public void verifyProjectCanBeDeleted() {
        String code = "TEST";
        String accessType = "public";

        commonPage.verifyPageLoaded();
        commonPage.createProject(name, code, accessType);
        projectPage.verifyProjectIsCreated();
        commonPage.goBackToCommonPage();
        commonPage.deleteProject(name);
        commonPage.verifyProjectIsDeleted(name);
    }
}
