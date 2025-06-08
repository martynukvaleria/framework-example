package pages.elements.forms;

import org.openqa.selenium.WebDriver;

public class Alert extends BaseElement{
    public Alert(String name, String locator, WebDriver webDriver) {
        super(name, locator, webDriver);
    }
    public String getText(){
        return driver.getText(locator);
    }
}
