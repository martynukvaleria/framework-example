package pages.elements;

import config.LocatorReader;
import org.openqa.selenium.WebDriver;
import pages.elements.forms.Label;

public class CommonPageElements {
    LocatorReader reader = new LocatorReader("src/test/resources/locators/commonPage.xml");

    private Label projectRow;
    public CommonPageElements(WebDriver webDriver){
        projectRow = new Label("Project row", reader.getLocator("//commonPage/projectRow"), webDriver);
    }

    public Label getProjectRow() {
        return projectRow;
    }
}
