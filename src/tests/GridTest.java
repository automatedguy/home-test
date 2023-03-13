package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        SoftAssert softAssert = new SoftAssert();
        final String EXPECTED_GRID_ITEM_POSITION = "7";
        final String EXPECTED_GRID_ITEM_NAME = "Super Pepperoni";
        final String EXPECTED_GRID_ITEM_PRICE = "$10";

        int gridItemIndex = gridPage.getElementGridItemIndex(EXPECTED_GRID_ITEM_POSITION);
        softAssert.assertEquals(gridPage.getElementGridItemName(gridItemIndex).getText(), EXPECTED_GRID_ITEM_NAME);
        softAssert.assertEquals(gridPage.getElementGridItemPrice(gridItemIndex).getText(), EXPECTED_GRID_ITEM_PRICE);
        softAssert.assertAll();
    }

    @Test
    public void verifyAllGridItems() {
        SoftAssert softAssert = new SoftAssert();

        for(int index = 0; index < gridPage.getElementGridItemList().size(); index++) {
            softAssert.assertTrue(gridPage.getElementGridItemName(index).isDisplayed());
            softAssert.assertTrue(gridPage.getElementGridItemImage(index).isDisplayed());
            softAssert.assertTrue(gridPage.getElementGridItemPrice(index).isDisplayed());
            softAssert.assertTrue(gridPage.getElementGridItemButton(index).isDisplayed());
        }
        softAssert.assertAll();
    }
}
