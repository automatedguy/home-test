package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public WebElement getOrderConfirmed(){
        return getElement(locatorTextOrderConfirmed, byTextOrderConfirmed);
    }

    public WebElement getOrderNumber(){
        return getElement(locatorTextOrderNumber, byTextOrderNumber);
    }
}
