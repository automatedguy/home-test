package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;
import test.java.pages.SearchPage;

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
        final String INPUT_SEARCH_TEXT = "automation";
        final String EXPECTED_SEARCH_RESULT = "Found one result for automation";
        SoftAssert softAssert = new SoftAssert();

        searchPage.enterTextSearch(INPUT_SEARCH_TEXT);
        searchPage.clickButtonSearch();
        softAssert.assertEquals(searchPage.getTextSearchResult(), EXPECTED_SEARCH_RESULT);
        softAssert.assertAll();

    }

    @Test
    public void verifySearchEmpty() {
        final String INPUT_SEARCH_TEXT = "";
        final String EXPECTED_SEARCH_RESULT = "Please provide a search word.";
        SoftAssert softAssert = new SoftAssert();

        searchPage.enterTextSearch(INPUT_SEARCH_TEXT);
        searchPage.clickButtonSearch();
        softAssert.assertEquals(searchPage.getTextSearchResult(), EXPECTED_SEARCH_RESULT);
        softAssert.assertAll();
    }

}
