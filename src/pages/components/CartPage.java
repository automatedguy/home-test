package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CartPage extends BasePage {

    // String locators
    private final String locatorTextPriceList = "//a[@href='#']/following-sibling::span[@class='price']";
    private final String locatorTextPriceTotal = "//p/span[@class='price']/b";

    // Element locators
    private By elementTextPriceList = By.xpath(locatorTextPriceList);
    private By elementTextPriceTotal = By.xpath(locatorTextPriceTotal);


    // Constructor
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public int getPriceListSum(){
        int totalPriceSum = 0;
        for(WebElement element : getElementList(locatorTextPriceList, elementTextPriceList))
            totalPriceSum = totalPriceSum + Integer.parseInt(element.getText().replace("$", ""));
        return totalPriceSum;
    }

    public int getPriceTotal(){
        return Integer.parseInt(getTextElement(locatorTextPriceTotal, elementTextPriceTotal).replace("$", ""));
    }

}
