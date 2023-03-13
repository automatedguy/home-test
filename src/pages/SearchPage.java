package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getTextSearchResult() {
        if(getTextElement(locatorTextSearchResult, elementTextSearchResult).equals("searching...")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getTextSearchResult();
        }
        return getTextElement(locatorTextSearchResult, elementTextSearchResult);
    }
}
