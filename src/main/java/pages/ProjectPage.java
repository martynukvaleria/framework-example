package pages;

import core.DriverWrapper;
import org.openqa.selenium.WebDriver;
import pages.elements.ProjectPageElements;

public class ProjectPage {
    ProjectPageElements projectPageElements;
    DriverWrapper driver;

    public ProjectPage(WebDriver webDriver){
        projectPageElements = new ProjectPageElements(webDriver);
        driver = new DriverWrapper(webDriver);
    }

    public void verifyProjectIsCreated() {
        projectPageElements.getRepositoryName().waitForElementToBeVisible();
    }
}
