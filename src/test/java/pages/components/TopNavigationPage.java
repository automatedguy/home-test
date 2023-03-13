package test.java.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.pages.BasePage;

public class TopNavigationPage extends BasePage {

    // String locators
    private final String locatorLinkHome = ".topnav a[href='/home']";
    private final String locatorLinkForm = ".topnav a[href='/checkout']";
    private final String locatorLinkGrid = ".topnav a[href='/grid']";
    private final String locatorLinkSearch = ".topnav a[href='/search']";

    // Element locators
    private By byLinkHome = By.cssSelector(locatorLinkHome);
    private By byLinkForm = By.cssSelector(locatorLinkForm);
    private By byLinkGrid = By.cssSelector(locatorLinkGrid);
    private By byLinkSearch = By.cssSelector(locatorLinkSearch);

    // Constructor
    public TopNavigationPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public WebDriver clickLinkHome() {
        clickElement(locatorLinkHome, byLinkHome);
        return getWebDriver();
    }

    public WebDriver clickLinkForm() {
        clickElement(locatorLinkForm, byLinkForm);
        return getWebDriver();
    }

    public WebDriver clickLinkGrid() {
        clickElement(locatorLinkGrid, byLinkGrid);
        return getWebDriver();
    }

    public WebDriver clickLinkSearch() {
        clickElement(locatorLinkSearch, byLinkSearch);
        return getWebDriver();
    }
}