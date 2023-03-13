package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.pages.GridPage;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;

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
        SoftAssert softAssert = new SoftAssert();
        final String EXPECTED_ITEM_POSITION = "7";
        final String EXPECTED_ITEM_NAME = "Super Pepperoni";
        final String EXPECTED_ITEM_PRICE = "$10";
        int itemIndex = gridPage.getItemIndex(EXPECTED_ITEM_POSITION);
        softAssert.assertEquals(gridPage.getItemName(itemIndex).getText(), EXPECTED_ITEM_NAME);
        softAssert.assertEquals(gridPage.getItemPrice(itemIndex).getText(), EXPECTED_ITEM_PRICE);
        softAssert.assertAll();
    }

    @Test
    public void verifyAllGridItems() {
        SoftAssert softAssert = new SoftAssert();
        for(int index = 0; index < gridPage.getElementGridItemList().size(); index++) {
            softAssert.assertTrue(gridPage.getItemName(index).isDisplayed());
            softAssert.assertTrue(gridPage.getItemImage(index).isDisplayed());
            softAssert.assertTrue(gridPage.getItemPrice(index).isDisplayed());
            softAssert.assertTrue(gridPage.getItemButton(index).isDisplayed());
        }
        softAssert.assertAll();
    }
}
