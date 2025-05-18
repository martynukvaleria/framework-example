package pages;

import core.DriverWrapper;
import org.openqa.selenium.WebDriver;
import pages.elements.LoginPageElements;

public class LoginPage {
    LoginPageElements loginPageElements;
    DriverWrapper driver;

    public LoginPage(WebDriver webDriver){
        loginPageElements = new LoginPageElements(webDriver);
        driver = new DriverWrapper(webDriver);
    }

    public void logIn(String url, String email, String password) {
        driver.navigateToUrl(url);
        enterUserDetails(email, password);
    }

    public void enterUserDetails(String email, String password){
        loginPageElements.getEmail().sendKeys(email);
        loginPageElements.getPassword().sendKeys(password);
        loginPageElements.getSignIn().click();
    }
}
