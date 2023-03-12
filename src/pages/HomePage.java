package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private final String menuHomeLocator = "menu-home";
    private final String menuFormLocator = "menu-form";
    private final String menuGridLocator = "menu-grid";
    private final String menuSearchLocator = "menu-search";
    private final String labelWelcomeLocator = "welcome";
    private final String labelUsernameLocator = "username";

    // By locators
    private By menuHome = By.cssSelector(".topnav a[href='/home']");
    private By menuForm = By.cssSelector(".topnav a[href='/checkout']");
    private By menuGrid = By.cssSelector(".topnav a[href='/grid']");
    private By menuSearch = By.cssSelector(".topnav a[href='/search']");
    private By labelWelcome = By.xpath("//div[@id='welcome-message']/h2");
    private By labelUsername = By.cssSelector("[data-id='username']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public WebDriver clickMenuHome() {
        clickElement(menuHomeLocator, menuHome);
        return getWebDriver();
    }
    public WebDriver clickMenuForm() {
        clickElement(menuFormLocator, menuForm);
        return getWebDriver();
    }
    public WebDriver clickMenuGrid() {
        clickElement(menuGridLocator, menuGrid);
        return getWebDriver();
    }
    public WebDriver clickMenuSearch() {
        clickElement(menuSearchLocator, menuSearch);
        return getWebDriver();
    }
    public String getWelcomeMessage() {
        return getElementText(labelWelcomeLocator, labelWelcome);
    }
    public String getUsername() {
        return getElementText(labelUsernameLocator, labelUsername);
    }
}
