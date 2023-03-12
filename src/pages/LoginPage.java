package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final String inputUsernameLocator = "username";
    private final String inputPasswordLocator = "password";
    private final String buttonSigninLocator = "signin-button";
    private final String messageLoginErrorLocator = "message";
    // By locators
    private By inputUsername = By.id(inputUsernameLocator);
    private By inputPassword = By.id(inputPasswordLocator);
    private By buttonSignin = By.id(buttonSigninLocator);

    private By messageLoginError = By.id(messageLoginErrorLocator);

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUsername(String username) {
        sendKeys(inputUsernameLocator, inputUsername, username);
    }

    public void enterPassword(String password) {
        sendKeys(inputPasswordLocator, inputPassword, password);
    }

    public WebDriver clickSignInButton() {
        clickElement(buttonSigninLocator, buttonSignin);
        return getWebDriver();
    }

    public String getMessageLoginError() {
        return getElementText(messageLoginErrorLocator, messageLoginError);
    }
}
