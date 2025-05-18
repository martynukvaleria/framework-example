package pages;

import core.DriverWrapper;
import org.openqa.selenium.WebDriver;
import pages.elements.CommonPageElements;

public class CommonPage {
    CommonPageElements commonPageElements;
    DriverWrapper driver;

    public CommonPage(WebDriver webDriver){
        commonPageElements = new CommonPageElements(webDriver);
        driver = new DriverWrapper(webDriver);
    }
    public void verifyPageLoaded(){
        commonPageElements.getProjectRow().waitForElementToBeVisible();
    }
}
