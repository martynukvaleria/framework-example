package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static final Map<DriverManagerType, Supplier<WebDriver>> driverMap = new EnumMap<>(DriverManagerType.class);

    static {
        driverMap.put(DriverManagerType.CHROME, ChromeDriver::new);
        driverMap.put(DriverManagerType.FIREFOX, FirefoxDriver::new);
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call createDriver() first.");
        }
        return driver;
    }

    public static void createDriver(String browserType) {
        DriverManagerType type;
        try {
            type = DriverManagerType.valueOf(browserType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType +
                    ". Supported types: " + String.join(", ", getSupportedBrowsers()));
        }

        WebDriverManager.getInstance(type).setup();
        WebDriver driver = driverMap.get(type).get();
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driverThreadLocal.remove();
            }
        }
    }

    public static String[] getSupportedBrowsers() {
        return driverMap.keySet().stream()
                .map(Enum::name)
                .toArray(String[]::new);
    }
}