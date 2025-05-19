package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverWrapper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DriverWrapper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getElement(String locator) {
        ActionLogger.logAction("FIND", locator);
        return driver.findElement(By.xpath(locator));
    }

    public void waitForElementToBeVisible(String locator) {
        ActionLogger.logAction("WAIT VISIBLE", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementToBeClickable(String locator) {
        ActionLogger.logAction("WAIT CLICKABLE", locator);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void click(String locator) {
        ActionLogger.logAction("CLICK", locator);
        getElement(locator).click();
    }

    public void sendKeys(String locator, String text) {
        ActionLogger.logActionWithText("SEND KEYS", locator, text);
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void navigateToUrl(String url) {
        ActionLogger.log("NAVIGATE", "URL: " + url);
        driver.get(url);
    }

    public void select(String locator) {
        ActionLogger.logAction("SELECT", locator);
        getElement(locator).click();
    }

    public String getText(String locator) {
        ActionLogger.logAction("GET TEXT", locator);
        return getElement(locator).getText();
    }

    public List<WebElement> getAllElements(String locator) {
        ActionLogger.logAction("FIND ALL ELEMENTS", locator);
        return driver.findElements(By.xpath(locator));
    }

    public void refreshPage() {
        ActionLogger.log("PAGE", "Refreshing page");
        driver.navigate().refresh();
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        ActionLogger.log("PAGE", "Waiting for page to load");
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        ActionLogger.log("PAGE", "Current URL: " + url);
        return url;
    }
}