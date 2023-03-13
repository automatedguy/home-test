package test.java.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import test.java.utils.ConfigProperties;

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
        // WebDriverManager.firefoxdriver().setup();
    }

    private void setProperties() {
        System.setProperty("url.base", configProperties.getProperty("url.base"));
        System.setProperty("url.login", configProperties.getProperty("url.login"));
        System.setProperty("credential.username", configProperties.getProperty("credential.username"));
        System.setProperty("credential.password", configProperties.getProperty("credential.password"));
    }

    private void startBrowser() {
        logger.info("Starting browser");
        // Added workarund for Chrome related bug https://github.com/SeleniumHQ/selenium/issues/11750
        // [🐛 Bug]: Chrome 111 is not compatible with default HTTP Client #11750
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        // webDriver = new FirefoxDriver();
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
