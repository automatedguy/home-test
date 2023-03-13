package test.java.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public abstract class BasePage {

    // Fields
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final Logger logger = Logger.getLogger("BasePage");
    private final Duration timeoutInSeconds = Duration.ofSeconds(10);

    // Constructor
    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, timeoutInSeconds);
    }

    // Methods
    protected WebDriver getWebDriver() {
        return webDriver;
    }

    // Methods
    protected void clickElement(String elementDescription, By elementLocator) {
        logger.info("Clicking on " + elementDescription);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        webDriver.findElement(elementLocator).click();
    }

    protected void sendKeys(String elementDescription, By elementLocator, String inputText) {
        logger.info("Sending keys to " + elementDescription + " : " + inputText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        webDriver.findElement(elementLocator).sendKeys(inputText);
    }

    protected WebElement getElement(String elementDescription, By elementLocator) {
        logger.info("Getting text from " + elementDescription);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return webDriver.findElement(elementLocator);
    }

    protected List<WebElement> getElementList(String elementDescription, By elementLocator) {
        logger.info("Getting text element list from " + elementDescription);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return webDriver.findElements(elementLocator);
    }

    protected boolean isElementSelected(String elementDescription, By elementLocator) {
        logger.info("Checking if element is selected" + elementDescription);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return webDriver.findElement(elementLocator).isSelected();
    }

    protected void selectOption(String elementDescription, By elementLocator, String selectOption) {
        logger.info("Selecting option from " + elementDescription + " : " + selectOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement selectElement = webDriver.findElement(elementLocator);
        Select select = new Select(selectElement);
        select.selectByVisibleText(selectOption);
    }

    protected void waitElementTextChange(String elementDescription, By elementLocator, String text) {
        logger.info("Getting text from " + elementDescription);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(elementLocator, text));
    }

    public Alert getAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert();
    }
    protected Logger getLogger(){
        return logger;
    }
}
