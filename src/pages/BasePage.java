package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public abstract class BasePage {
    private WebDriver webDriver;
    public final Logger logger = Logger.getLogger("BasePage");

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void clickElement(String elementDescription, By elementLocator) {
        logger.info("Clicking on " + elementDescription);
        webDriver.findElement(elementLocator).click();
    }

    public void sendKeys(String elementDescription, By elementLocator, String inputText) {
        logger.info("Sending keys to " + elementDescription + " : " + inputText);
        webDriver.findElement(elementLocator).sendKeys(inputText);
    }

    public String getElementText(String elementDescription, By elementLocator) {
        logger.info("Getting text from " + elementDescription);
        return webDriver.findElement(elementLocator).getText();
    }

    public boolean getElementStatus() {
        return false;
    }

}
