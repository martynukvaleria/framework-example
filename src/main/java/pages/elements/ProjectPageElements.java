package pages.elements;

import config.LocatorReader;
import org.openqa.selenium.WebDriver;
import pages.elements.forms.Button;
import pages.elements.forms.Label;
import pages.elements.forms.TextField;

public class ProjectPageElements {
    LocatorReader reader = new LocatorReader("src/test/resources/locators/projectPage.xml");

    private Label repositoryName;

    public ProjectPageElements(WebDriver webDriver){
        repositoryName = new Label("Repository name", reader.getLocator("//projectPage/repositoryName"), webDriver);
    }

    public Label getRepositoryName() {
        return repositoryName;
    }
}
