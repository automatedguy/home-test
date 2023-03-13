package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.GridPage;
import pages.HomePage;
import pages.LoginPage;

public class GridTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    private GridPage gridPage;

    @BeforeMethod
    public void performLoginAndNavigateToGrid() {
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterTextUsername(System.getProperty("credential.username"));
        loginPage.enterTextPassword(System.getProperty("credential.password"));
        homePage = new HomePage(loginPage.clickButtonSignIn());
        gridPage = new GridPage(homePage.getTopNavigationPage().clickLinkGrid());
    }

    @Test
    public void verifyGridItem() {

    }

    @Test
    public void verifyAllGridItems() {

    }
}
