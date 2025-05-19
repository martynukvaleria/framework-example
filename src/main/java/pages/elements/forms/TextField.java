package pages.elements.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField extends BaseElement{

    public TextField(String name, String locator, WebDriver webDriver) {
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
