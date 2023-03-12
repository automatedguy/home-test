package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigProperties;

import java.util.logging.Logger;

public abstract class BaseTest {

    private WebDriver webDriver;
    private final ConfigProperties configProperties = new ConfigProperties();
    private final Logger logger = Logger.getLogger("BaseTest");

    @BeforeMethod
    protected void openBaseUrl() {
        logger.info("Navigating to URL: " + System.getProperty("url.base") + System.getProperty("url.login"));
        webDriver.get(configProperties.getProperty("url.base") + System.getProperty("url.login"));
    }
    @BeforeClass
    public void setUp() {
        configureWebDriver();
        setProperties();
        startBrowser();
        maximizeBrowser();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

    private void configureWebDriver() {
        logger.info("Configuring web driver");
        WebDriverManager.chromedriver().setup();
    }

    private void setProperties() {
        System.setProperty("url.base", configProperties.getProperty("url.base"));
        System.setProperty("url.login", configProperties.getProperty("url.login"));
        System.setProperty("credential.username", configProperties.getProperty("credential.username"));
        System.setProperty("credential.password", configProperties.getProperty("credential.password"));
    }

    private void startBrowser() {
        logger.info("Starting browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        webDriver = new ChromeDriver(chromeOptions);
    }

    private void maximizeBrowser() {
        logger.info("Maximizing browser");
        webDriver.manage().window().maximize();
    }
    private void closeBrowser() {
        logger.info("Closing browser");
        webDriver.close();
    }
    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
