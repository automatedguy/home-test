package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeMethod
    public void performLoginAndNavigateToSearch() {
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterTextUsername(System.getProperty("credential.username"));
        loginPage.enterTextPassword(System.getProperty("credential.password"));
        homePage = new HomePage(loginPage.clickButtonSignIn());
        searchPage = new SearchPage(homePage.getTopNavigationPage().clickLinkSearch());
    }

    @Test
    public void verifySearchSuccess() {

    }

    @Test
    public void verifySearchEmpty() {

    }

}
