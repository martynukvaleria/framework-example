package pages.elements.forms;

import core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Label extends BaseElement{
    DriverWrapper driver = getDriverWrapper();
    public Label(String name, By locator, WebDriver webDriver) {
        super(name, locator, webDriver);
    }
}
