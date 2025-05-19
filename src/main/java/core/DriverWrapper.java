package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverWrapper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DriverWrapper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getRawDriver() {
        return driver;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void waitForElementToBeVisible(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementToBeClickable(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void click(String locator) {
        getElement(locator).click();
    }

    public void sendKeys(String locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void select(String locator) {
        WebElement element = getElement(locator);
        element.click();
    }

    public String getText(String locator){
        WebElement element = getElement(locator);
        return element.getText();
    }

    public List<WebElement> getAllElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void refreshPage(){
     driver.navigate().refresh();
    }
}
