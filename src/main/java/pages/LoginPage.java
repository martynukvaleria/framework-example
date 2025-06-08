package pages;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.elements.LoginPageElements;

public class LoginPage extends BasePage {
    LoginPageElements loginPageElements;

    public LoginPage(WebDriver driver){
        super(driver);
        loginPageElements = new LoginPageElements(driver);
    }

    public void logIn(String url, String email, String password) {
        driverWrapper.navigateToUrl(url);
        enterUserDetails(email, password);
    }

    public void enterUserDetails(String email, String password){
        loginPageElements.getEmail().sendKeys(email);
        loginPageElements.getPassword().sendKeys(password);
        loginPageElements.getSignIn().click();
    }
}
