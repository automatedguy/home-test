package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GridPage extends BasePage {

    // String locators
    private final String locatorItemList = "(//div[@class='item'])";
    private final String locatorItemName = "h4";
    private final String locatorItemNumber = "label[@data-test-id='card-number']";
    private final String locatorItemPrice = "p";
    private final String locatorItemImage = "img";
    private final String locatorItemButton = "button";

    // Element locators
    private By byItemList = By.xpath(locatorItemList);
    private By byItemNumber = By.xpath(locatorItemNumber);
    private By byItemName = By.xpath(locatorItemName);
    private By byItemPrice = By.xpath(locatorItemPrice);
    private By byItemImage = By.xpath(locatorItemImage);
    private By byItemButton = By.xpath(locatorItemButton);

    // Constructor
    public GridPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public List<WebElement> getElementGridItemList(){
        return getElementList(locatorItemList, byItemList);
    }

    private WebElement getItem(int elementIndex){
        return getElementList(locatorItemList, byItemList).get(elementIndex);
    }

    public int getItemIndex(String elementNumber){
        int gridItemIndex = 0;
        for(int index = 0; index < getElementGridItemList().size(); index++) {
            if (geItemNumber(index).getText().equals(elementNumber)) {
                gridItemIndex = index;
            }
        }
        return gridItemIndex;
    }
    public WebElement getItemName(int index){
        getLogger().info("Getting item name: " + getItem(index).findElement(byItemName).getText());
        return getItem(index).findElement(byItemName);
    }

    public WebElement geItemNumber(int index){
        getLogger().info("Getting item number: " + getItem(index).findElement(byItemNumber).getText());
        return getItem(index).findElement(byItemNumber);
    }

    public WebElement getItemPrice(int index){
        getLogger().info("Getting item price: " + getItem(index).findElement(byItemPrice).getText());
        return getItem(index).findElement(byItemPrice);
    }

    public WebElement getItemImage(int index){
        getLogger().info("Getting item image: " + index);
        return getItem(index).findElement(byItemImage);
    }

    public WebElement getItemButton(int index){
        getLogger().info("Getting item button: " + index);
        return getItem(index).findElement(byItemButton);
    }

}
