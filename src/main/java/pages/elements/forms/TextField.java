package pages.elements.forms;

import core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField extends BaseElement{
    DriverWrapper driver = getDriverWrapper();

    public TextField(String name, By locator, WebDriver webDriver) {
        super(name, locator, webDriver);
    }

    public void click() {
        driver.waitForElementToBeVisible(locator);
        driver.waitForElementToBeClickable(locator);
        driver.click(locator);
    }

    public void sendKeys(String text){
        driver.sendKeys(locator, text);
    }
}
