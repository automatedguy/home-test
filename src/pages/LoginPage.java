package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final String inputUsernameLocator = "input[name='username']";
    private final String inputPasswordLocator = "input[name='password']";
    private final String buttonSigninLocator = "button.signin";
    // By locators
    private By inputUsername = By.cssSelector(inputUsernameLocator);
    private By inputPassword = By.cssSelector(inputPasswordLocator);
    private By buttonSignin = By.cssSelector(buttonSigninLocator);

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
}
