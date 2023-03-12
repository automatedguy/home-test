package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public abstract class BasePage {

    // Fields
    private WebDriver webDriver;
    private final Logger logger = Logger.getLogger("BasePage");
    private WebDriverWait wait;
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

    protected String getElementText(String elementDescription, By elementLocator) {
        logger.info("Getting text from " + elementDescription);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return webDriver.findElement(elementLocator).getText();
    }

    protected boolean getElementStatus() {
        return false;
    }

}
