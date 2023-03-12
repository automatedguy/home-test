package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationPage extends BasePage {

    // Locators
    private final String linkHomeLocator = ".topnav a[href='/home']";
    private final String linkFormLocator = ".topnav a[href='/checkout']";
    private final String linkGridLocator = ".topnav a[href='/grid']";
    private final String linkSearchLocator = ".topnav a[href='/search']";

    // By locators
    private By linkHome = By.cssSelector(linkHomeLocator);
    private By linkForm = By.cssSelector(linkFormLocator);
    private By linkGrid = By.cssSelector(linkGridLocator);
    private By linkSearch = By.cssSelector(linkSearchLocator);

    // Constructor
    protected TopNavigationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    // Methods
    public WebDriver clickLinkHome() {
        clickElement(linkHomeLocator, linkHome);
        return getWebDriver();
    }

    public WebDriver clickLinkForm() {
        clickElement(linkFormLocator, linkForm);
        return getWebDriver();
    }

    public WebDriver clickLinkGrid() {
        clickElement(linkGridLocator, linkGrid);
        return getWebDriver();
    }

    public WebDriver clickLinkSearch() {
        clickElement(linkSearchLocator, linkSearch);
        return getWebDriver();
    }
}