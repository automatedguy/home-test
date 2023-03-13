package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {

    // String locators
    private final String locatorTextOrderConfirmed = "//div[@id='order-confirmation']/h1";
    private final String locatorTextOrderNumber = "//p[@data-id='ordernumber']";

    // Element locators
    private By byTextOrderConfirmed = By.xpath(locatorTextOrderConfirmed);
    private By byTextOrderNumber = By.xpath(locatorTextOrderNumber);

    // Constructor
    public ConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public String getTextOrderConfirmed(){
        return getTextElement(locatorTextOrderConfirmed, byTextOrderConfirmed);
    }

    public String getTextOrderNumber(){
        return getTextElement(locatorTextOrderNumber, byTextOrderNumber);
    }
}
