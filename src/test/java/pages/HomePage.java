package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.pages.components.TopNavigationPage;

public class HomePage extends BasePage {

    // String locators
    private final String locatorTextWelcomeMessage = "//div[@id='welcome-message']/h2";
    private final String locatorTextUsername = "[data-id='username']";

    // Element locators
    private By byTextWelcomeMessage = By.xpath(locatorTextWelcomeMessage);
    private By byTextUsername = By.cssSelector(locatorTextUsername);

    // Page components
    private TopNavigationPage topNavigationPage;

    // Constructor
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        topNavigationPage = new TopNavigationPage(webDriver);
    }

    // Methods
    public String getTextWelcomeMessage() {
        return getTextElement(locatorTextWelcomeMessage, byTextWelcomeMessage);
    }
    public String getTextUsername() {
        return getTextElement(locatorTextUsername, byTextUsername);
    }

    public TopNavigationPage getTopNavigationPage() {
        return topNavigationPage;
    }
}
