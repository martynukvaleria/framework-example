package pages.base;

import core.DriverWrapper;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected DriverWrapper driverWrapper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWrapper = new DriverWrapper(driver);
    }
}
