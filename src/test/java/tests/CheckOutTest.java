package test.java.tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.pages.CheckoutPage;
import test.java.pages.ConfirmationPage;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;

public class CheckOutTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    @DataProvider(name = "check_out_form_data")
    public Object[][] checkoutFormData() {
        return new Object[][]{
                {"John Doe", "johndoe@test.com", "123 Main St", "New York", "NY", "10001",
                        "John Doe", "998987668", "November", "2027", "777"}
        };
    }
    @BeforeMethod
    public void performLoginAndNavigateToCheckout() {
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterTextUsername(System.getProperty("credential.username"));
        loginPage.enterTextPassword(System.getProperty("credential.password"));
        homePage = new HomePage(loginPage.clickButtonSignIn());
        checkoutPage = new CheckoutPage(homePage.getTopNavigationPage().clickLinkForm());
    }

    @Test(dataProvider = "check_out_form_data")
    public void verifyCheckoutFormOrderSuccess(String fullName, String email, String address, String city, String state,
                                               String zipCode, String nameOnCard, String creditCardNumber, String expirationMonth,
                                               String expirationYear, String cvv) {
        final String EXPECTED_ORDER_CONFIRMED_TEXT = "Order Confirmed!";
        final String EXPECTED_ORDER_NUMBER_TEXT = "Order Number:";
        SoftAssert softAssert = new SoftAssert();
        final boolean shippingAddressSameAsBilling = true;

        checkoutPage.getBillingAddressPage().populateBillingAddress(fullName, email, address, city, state, zipCode, shippingAddressSameAsBilling);
        checkoutPage.getPaymentFormPage().populatePaymentForm(nameOnCard, creditCardNumber, expirationMonth, expirationYear, cvv);
        confirmationPage = new ConfirmationPage(checkoutPage.clickButtonContinueToCheckout());
        softAssert.assertEquals(confirmationPage.getOrderConfirmed().getText(), EXPECTED_ORDER_CONFIRMED_TEXT);
        softAssert.assertEquals(confirmationPage.getOrderNumber().getText().substring(0,13), EXPECTED_ORDER_NUMBER_TEXT);
        softAssert.assertNotNull(confirmationPage.getOrderNumber().getText().substring(14, 18));
        softAssert.assertAll();

    }

    @Test(dataProvider = "check_out_form_data")
    public void verifyCheckoutFormOrderAlert(String fullName, String email, String address, String city, String state,
                                             String zipCode, String nameOnCard, String creditCardNumber, String expirationMonth,
                                             String expirationYear, String cvv){
        final String EXPECTED_ALERT_TEXT = "Shipping address same as billing checkbox must be selected.";
        SoftAssert softAssert = new SoftAssert();
        final boolean shippingAddressSameAsBilling = false;

        checkoutPage.getBillingAddressPage().populateBillingAddress(fullName, email, address, city, state, zipCode, shippingAddressSameAsBilling);
        checkoutPage.getPaymentFormPage().populatePaymentForm(nameOnCard, creditCardNumber, expirationMonth, expirationYear, cvv);
        checkoutPage.clickButtonContinueToCheckout();
        Alert alert = getWebDriver().switchTo().alert();
        softAssert.assertEquals(alert.getText(), EXPECTED_ALERT_TEXT);
        alert.accept();
        softAssert.assertAll();
    }

    @Test
    public void verifyCheckoutFormOrderCartTotal(){
        final int EXPECTED_CART_PRICE_TOTAL = 30;
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(checkoutPage.getCartPage().getPriceListSum(), EXPECTED_CART_PRICE_TOTAL);
        softAssert.assertEquals(checkoutPage.getCartPage().getPriceTotal(), EXPECTED_CART_PRICE_TOTAL);
        softAssert.assertAll();
    }
}
