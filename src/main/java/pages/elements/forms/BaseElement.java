package pages.elements.forms;

import core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected String name;
    protected By locator;
    protected DriverWrapper driver;
    protected WebDriver webDriver;

    public BaseElement(String name, By locator, WebDriver webDriver) {
        this.name = name;
        this.locator = locator;
        this.webDriver = webDriver;
        driver = getDriverWrapper();
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
        if (locator instanceof By.ByXPath) {
            String xpath = locator.toString().replaceFirst("By.xpath: ", "");
            String updatedXpath = xpath.replace(placeholder, value);
            this.locator = By.xpath(updatedXpath);
        } else {
            throw new UnsupportedOperationException("Replacement supported only for XPath locators");
        }
    }

    public void waitForElementToBeVisible(){
        driver.waitForElementToBeVisible(locator);
    }
    public void waitForElementToBeClickable(){
        driver.waitForElementToBeClickable(locator);
    }
}
