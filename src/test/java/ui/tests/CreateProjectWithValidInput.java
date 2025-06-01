package ui.tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseUiTest;

public class CreateProjectWithValidInput extends BaseUiTest {
    String name;

    @BeforeMethod
    public void setUp() {
        loginPage.logIn(loginUrl, configReader.get("email"), configReader.get("password"));
        name = commonPage.projectName();
    }
    @Epic("Project CRUD")
    @Feature("Create Project")
    @Story("Create project with valid input")
    @Owner("your_name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "ui", description = "Verify project can be created")
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
