package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final Map<DriverManagerType, Supplier<WebDriver>> driverMap = new EnumMap<>(DriverManagerType.class);

    static {
        driverMap.put(DriverManagerType.CHROME, () -> {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--no-sandbox");
            options.addArguments("--incognito");
            options.addArguments("--disable-dev-shm-usage");

            return new ChromeDriver(options);
        });

        driverMap.put(DriverManagerType.FIREFOX, () -> {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            return new FirefoxDriver(options);
        });
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call createDriver() first.");
        }
        return driver;
    }

    public static WebDriver createDriver(String browserType) {
        DriverManagerType type = parseBrowserType(browserType);
        WebDriverManager.getInstance(type).setup();

        WebDriver driver = driverMap.get(type).get();
        driverThreadLocal.set(driver);
        return driver;
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

    public static boolean isDriverCreated() {
        return driverThreadLocal.get() != null;
    }
    private static DriverManagerType parseBrowserType(String browserType) {
        try {
            return DriverManagerType.valueOf(browserType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType +
                    ". Supported types: " + String.join(", ", getSupportedBrowsers()));
        }
    }
    public static List<String> getSupportedBrowsers() {
        return driverMap.keySet().stream()
                .map(Enum::name)
                .map(String::toLowerCase)
                .toList();
    }
}