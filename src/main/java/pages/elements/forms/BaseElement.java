package pages.elements.forms;

import core.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

public abstract class BaseElement {
    protected String name;
    protected String locator;
    protected DriverWrapper driver;
    protected WebDriver webDriver;

    public BaseElement(String name, String locator, WebDriver webDriver) {
        this.name = name;
        this.locator = locator;
        this.webDriver = webDriver;
        this.driver = getDriverWrapper();
    }

    protected DriverWrapper getDriverWrapper() {
        if (this.webDriver instanceof DriverWrapper) {
            return (DriverWrapper) this.webDriver;
        }
        return new DriverWrapper(this.webDriver);
    }

    public WebElement getElement() {
        return driver.getElement(locator);
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    public void replacePartOfLocator(String placeholder, String value) {
        this.locator = this.locator.replace(placeholder, value);
    }

    public void waitForElementToBeVisible() {
        driver.waitForElementToBeVisible(locator);
    }

    public void waitForElementToBeClickable() {
        driver.waitForElementToBeClickable(locator);
    }

    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    public String getText() {
        return getElement().getText();
    }

    public List<WebElement> getAllElements() {
        return driver.getAllElements(locator);
    }
}