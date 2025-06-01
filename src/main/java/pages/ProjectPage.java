package pages;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.elements.ProjectPageElements;

public class ProjectPage extends BasePage {
    ProjectPageElements projectPageElements;

    public ProjectPage(WebDriver driver){
        super(driver);
        projectPageElements = new ProjectPageElements(driver);
    }

    public void verifyProjectIsCreated() {
        projectPageElements.getRepositoryName().waitForElementToBeVisible();
    }
}
