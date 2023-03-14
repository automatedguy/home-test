package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void initializeLoginPage() {
        loginPage = new LoginPage(getWebDriver());
    }

    @Test
    public void verifyLoginSuccess() {
        final String EXPECTED_WELCOME_MESSAGE_TEXT = "Welcome!";
        final String EXPECTED_USERNAME_TEXT = System.getProperty("credential.username");
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterTextUsername(System.getProperty("credential.username"));
        loginPage.enterTextPassword(System.getProperty("credential.password"));
        HomePage homePage = new HomePage(loginPage.clickButtonSignIn());
        softAssert.assertEquals(homePage.getWelcomeMessage().getText(), EXPECTED_WELCOME_MESSAGE_TEXT);
        softAssert.assertEquals(homePage.getUsername().getText(), EXPECTED_USERNAME_TEXT);
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginFailureWrongCredentials() {
        final String EXPECTED_LOGIN_ERROR_MESSAGE_TEXT = "Wrong credentials";
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterTextUsername("wrongusername");
        loginPage.enterTextPassword("wrongpassword");
        loginPage.clickButtonSignIn();
        softAssert.assertEquals(loginPage.getMessageLoginError().getText(), EXPECTED_LOGIN_ERROR_MESSAGE_TEXT);
    }
    
    @Test
    public void verifyLoginFailureBlankCredentials() {
        final String EXPECTED_LOGIN_ERROR_MESSAGE = "Fields can not be empty";
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterTextUsername("");
        loginPage.enterTextPassword("");
        loginPage.clickButtonSignIn();
        softAssert.assertEquals(loginPage.getMessageLoginError().getText(), EXPECTED_LOGIN_ERROR_MESSAGE);
    }
}
