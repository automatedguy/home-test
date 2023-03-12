package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigProperties;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void initializeLoginPage() {
        loginPage = new LoginPage(getWebDriver());
    }

    @Test
    public void verifyLoginSuccess() {
        final String EXPECTED_WELCOME_MESSAGE = "Welcome!";
        final String EXPECTED_USERNAME = System.getProperty("credential.username");
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterUsername(System.getProperty("credential.username"));
        loginPage.enterPassword(System.getProperty("credential.password"));
        HomePage homePage = new HomePage(loginPage.clickSignInButton());
        softAssert.assertEquals(homePage.getWelcomeMessage(), EXPECTED_WELCOME_MESSAGE);
        softAssert.assertEquals(homePage.getUsername(), EXPECTED_USERNAME);
        softAssert.assertAll();
    }
    @Test
    public void verifyLoginFailureWrongCredentials() {
        final String EXPECTED_LOGIN_ERROR_MESSAGE = "Wrong credentials";
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterUsername("wrongusername");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickSignInButton();
        softAssert.assertEquals(loginPage.getMessageLoginError(), EXPECTED_LOGIN_ERROR_MESSAGE);
    }
    @Test
    public void verifyLoginFailureBlankCredentials() {
        final String EXPECTED_LOGIN_ERROR_MESSAGE = "Fields can not be empty";
        SoftAssert softAssert = new SoftAssert();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickSignInButton();
        softAssert.assertEquals(loginPage.getMessageLoginError(), EXPECTED_LOGIN_ERROR_MESSAGE);
    }
}
