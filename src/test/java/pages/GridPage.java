package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GridPage extends BasePage {

    // String locators
    private final String locatorGridItemList = "(//div[@class='item'])";
    private final String locatorGridItemName = "h4";
    private final String locatorGridItemNumber = "label[@data-test-id='card-number']";
    private final String locatorGridItemPrice = "p";
    private final String locatorGridItemImage = "img";
    private final String locatorGridItemButton = "button";

    // Element locators
    private By byGridItemList = By.xpath(locatorGridItemList);
    private By byGridItemNumber = By.xpath(locatorGridItemNumber);
    private By byGridItemName = By.xpath(locatorGridItemName);
    private By byGridItemPrice = By.xpath(locatorGridItemPrice);
    private By byGridItemImage = By.xpath(locatorGridItemImage);
    private By byGridItemButton = By.xpath(locatorGridItemButton);

    // Constructor
    public GridPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public List<WebElement> getElementGridItemList(){
        return getElementList(locatorGridItemList, byGridItemList);
    }

    private WebElement getElementGridItem(int elementIndex){
        return getElementList(locatorGridItemList, byGridItemList).get(elementIndex);
    }

    public int getElementGridItemIndex(String elementNumber){
        int gridItemIndex = 0;
        for(int index = 0; index < getElementGridItemList().size(); index++) {
            if (getElementGridItemNumber(index).getText().equals(elementNumber)) {
                gridItemIndex = index;
            }
        }
        return gridItemIndex;
    }
    public WebElement getElementGridItemName(int elementIndex){
        // TODO: implement get element from list on the base page
        getLogger().info("Getting item name: " + getElementGridItem(elementIndex).findElement(byGridItemName).getText());
        return getElementGridItem(elementIndex).findElement(byGridItemName);
    }

    public WebElement getElementGridItemNumber(int elementIndex){
        // TODO: implement get element from list on the base page
        getLogger().info("Getting item number: " + getElementGridItem(elementIndex).findElement(byGridItemNumber).getText());
        return getElementGridItem(elementIndex).findElement(byGridItemNumber);
    }

    public WebElement getElementGridItemPrice(int elementIndex){
        // TODO: implement get element from list on the base page
        getLogger().info("Getting item price: " + getElementGridItem(elementIndex).findElement(byGridItemPrice).getText());
        return getElementGridItem(elementIndex).findElement(byGridItemPrice);
    }

    public WebElement getElementGridItemImage(int elementIndex){
        // TODO: implement get element from list on the base page
        getLogger().info("Getting item image: " + elementIndex);
        return getElementGridItem(elementIndex).findElement(byGridItemImage);
    }

    public WebElement getElementGridItemButton(int elementIndex){
        // TODO: implement get element from list on the base page
        getLogger().info("Getting item button: " + elementIndex);
        return getElementGridItem(elementIndex).findElement(byGridItemButton);
    }

}
