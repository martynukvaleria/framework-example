package pages.elements.forms;

import core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {
    DriverWrapper driver = getDriverWrapper();

    public Button(String name, String locator, WebDriver webDriver) {
        super(name, locator, webDriver);
    }

    public void click() {
        driver.waitForElementToBeVisible(locator);
        driver.waitForElementToBeClickable(locator);
        driver.click(locator);
    }
}
