package pages.elements;

import readers.LocatorReader;
import org.openqa.selenium.WebDriver;
import pages.elements.forms.Button;
import pages.elements.forms.TextField;


public class LoginPageElements {
    LocatorReader reader = new LocatorReader("src/test/resources/locators/loginPage.xml");

    private Button continueWithGoogle;
    private Button chooseAccount;
    private TextField email;
    private TextField password;
    private Button signIn;

    public LoginPageElements(WebDriver webDriver){
        continueWithGoogle = new Button("Continue with google", reader.getLocator("//loginPage/continueWithGoogle"), webDriver);
        chooseAccount = new Button("Choose account", reader.getLocator("//loginPage/chooseAccount"), webDriver);
        email = new TextField("Email", reader.getLocator("//loginPage/email"), webDriver);
        password = new TextField("Password", reader.getLocator("//loginPage/password"), webDriver);
        signIn = new Button("Sign in", reader.getLocator("//loginPage/signIn"), webDriver);
    }

    public Button getContinueWithGoogle() {
        return continueWithGoogle;
    }

    public Button getChooseAccount(String name) {
        chooseAccount.replacePartOfLocator("{accName}", name);
        return chooseAccount;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getPassword() {
        return password;
    }

    public Button getSignIn() {
        return signIn;
    }
}
