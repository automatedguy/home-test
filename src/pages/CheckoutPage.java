package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.BillingAddressPage;
import pages.components.PaymentInformationPage;

public class CheckoutPage extends BasePage {

    // Locators
    private final String locatorButtonContinueToCheckout = "//button[@class='btn']";

    // Elements
    private By byElementButtonContinueToCheckout = By.xpath(locatorButtonContinueToCheckout);

    // Components
    private BillingAddressPage billingAddressPage;
    private PaymentInformationPage paymentInformationPage;

    // Constructor
    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        billingAddressPage = new BillingAddressPage(webDriver);
        paymentInformationPage = new PaymentInformationPage(webDriver);
    }

    // Methods

    public BillingAddressPage getBillingAddressPage() {
        return billingAddressPage;
    }

    public PaymentInformationPage getPaymentFormPage() {
        return paymentInformationPage;
    }
    public WebDriver clickButtonContinueToCheckout() {
        clickElement(locatorButtonContinueToCheckout, byElementButtonContinueToCheckout);
        return getWebDriver();
    }
}
