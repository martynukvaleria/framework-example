package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectPage;
import utils.BaseUiTest;

public class CreateProjectWithValidInput extends BaseUiTest {

    LoginPage loginPage;
    CommonPage commonPage;
    ProjectPage projectPage;
    String name;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        commonPage = new CommonPage(getDriver());
        projectPage = new ProjectPage(getDriver());
        loginPage.logIn(loginUrl, configReader.get("email"), configReader.get("password"));
        name = commonPage.projectName();
    }

    @Test(groups = "ui")
    public void createProjectWithValidInput() {
        String code = "TEST";
        String accessType = "public";

        commonPage.verifyPageLoaded();
        commonPage.createProject(name, code, accessType);
        projectPage.verifyProjectIsCreated();
        commonPage.goBackToCommonPage();
    }

    @AfterMethod
    public void afterMethod() {
        commonPage.deleteProject(name);
    }
}
