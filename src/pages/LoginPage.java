package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final String locatorInputUsername = "username";
    private final String locatorInputPassword = "password";
    private final String locatorButtonSignIn = "signin-button";
    private final String locatorMessageLoginError = "message";

    // By locators
    private By elementInputUsername = By.id(locatorInputUsername);
    private By elementInputPassword = By.id(locatorInputPassword);
    private By elementButtonSignin = By.id(locatorButtonSignIn);
    private By elementMessageLoginError = By.id(locatorMessageLoginError);

    // Constructor
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public void enterInputUsername(String username) {
        sendKeys(locatorInputUsername, elementInputUsername, username);
    }

    public void enterInputPassword(String password) {
        sendKeys(locatorInputPassword, elementInputPassword, password);
    }

    public WebDriver clickButtonSignIn() {
        clickElement(locatorButtonSignIn, elementButtonSignin);
        return getWebDriver();
    }

    public String getTextMessageLoginError() {
        return getElementText(locatorMessageLoginError, elementMessageLoginError);
    }
}
