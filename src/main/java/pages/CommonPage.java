package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import pages.elements.CommonPageElements;

import java.util.UUID;

public class CommonPage extends BasePage {
    CommonPageElements commonPageElements;

    public CommonPage(WebDriver driver) {
        super(driver);
        commonPageElements = new CommonPageElements(driver);
    }

    public void verifyPageLoaded() {
        commonPageElements.getProjectRow().waitForElementToBeVisible();
    }

    public String projectName() {
        return "Test_" + UUID.randomUUID();
    }

    public void createProject(String name, String code, String accessType) {
        commonPageElements.getCreateNewProject().click();
        commonPageElements.getName().sendKeys(name);
        commonPageElements.getCode().sendKeys(code);
        if (accessType.equals("public")) {
            commonPageElements.getAccess("public").select();
        }
        commonPageElements.getCreate().click();
    }

    public void goBackToCommonPage() {
        try {
            commonPageElements.getProjects().click();
        } catch (Exception e) {
            e.printStackTrace();
            driverWrapper.refreshPage();
            commonPageElements.getProjects().click();
        }
    }

    public void deleteProject(String name) {
        commonPageElements.getOpenActionsMenu(name).click();
        commonPageElements.getRemove().click();
        commonPageElements.getOkForDelete().click();
    }

    public void checkAlert(String message) {
        commonPageElements.getAlertTxt().waitForElementToBeVisible();
        Assert.assertTrue(commonPageElements.getAlertTxt().getText().contains(message));
        commonPageElements.getCloseAlert().click();
    }

    public void verifyProjectIsDeleted(String name) {
        driverWrapper.refreshPage();
        commonPageElements.getProjectRow().waitForElementToBeVisible();
        int projectsNum = commonPageElements.getProjectRow().getAllElements().size();
        Assert.assertEquals(projectsNum, 1);
    }
}
