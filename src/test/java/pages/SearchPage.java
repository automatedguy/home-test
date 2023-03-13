package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    // String Locators
    private final String locatorTextSearch = "//input[@name='searchWord']";
    private final String locatorButtonSearch = "//button[@type='submit']";
    private final String locatorTextSearchResult = "result";

    // Element locators
    private By elementTextSearch = By.xpath(locatorTextSearch);
    private By elementButtonSearch = By.xpath(locatorButtonSearch);
    private By elementTextSearchResult = By.id(locatorTextSearchResult);
    // Constructor
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public void enterTextSearch(String text) {
        sendKeys(locatorTextSearch, elementTextSearch, text);
    }
    public void clickButtonSearch() {
        clickElement(locatorButtonSearch, elementButtonSearch);
    }

    public WebElement getSearchResult() {
        if(getElement(locatorTextSearchResult, elementTextSearchResult).equals("searching...")) {
            // TODO: improve this wait somehow
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getSearchResult();
        }
        return getElement(locatorTextSearchResult, elementTextSearchResult);
    }
}
