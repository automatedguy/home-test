package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // String locators
    private final String locatorTextUsername = "username";
    private final String locatorTextPassword = "password";
    private final String locatorButtonSignIn = "signin-button";
    private final String locatorMessageLoginError = "message";

    // Element locators
    private By byTextUsername = By.id(locatorTextUsername);
    private By byTextPassword = By.id(locatorTextPassword);
    private By byButtonSignin = By.id(locatorButtonSignIn);
    private By byMessageLoginError = By.id(locatorMessageLoginError);

    // Constructor
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public void enterTextUsername(String username) {
        sendKeys(locatorTextUsername, byTextUsername, username);
    }

    public void enterTextPassword(String password) {
        sendKeys(locatorTextPassword, byTextPassword, password);
    }

    public WebDriver clickButtonSignIn() {
        clickElement(locatorButtonSignIn, byButtonSignin);
        return getWebDriver();
    }

    public String getTextMessageLoginError() {
        return getTextElement(locatorMessageLoginError, byMessageLoginError);
    }
}
