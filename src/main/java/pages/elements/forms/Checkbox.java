package pages.elements.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox extends BaseElement{
    public Checkbox(String name, String locator, WebDriver webDriver) {
        super(name, locator, webDriver);
    }

    public void select(){
        driver.select(locator);
    }
}
