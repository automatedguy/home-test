package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private final String locatorTextWelcomeMessage = "//div[@id='welcome-message']/h2";
    private final String locatorTextUsername = "[data-id='username']";

    // By locators
    private By elementTextWelcomeMessage = By.xpath(locatorTextWelcomeMessage);
    private By elementTextUsername = By.cssSelector(locatorTextUsername);

    // Components
    private TopNavigationPage topNavigationPage;

    // Constructor
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        topNavigationPage = new TopNavigationPage(webDriver);
    }

    // Methods
    public String getTextWelcomeMessage() {
        return getElementText(locatorTextWelcomeMessage, elementTextWelcomeMessage);
    }
    public String getElementTextUsername() {
        return getElementText(locatorTextUsername, elementTextUsername);
    }
}
