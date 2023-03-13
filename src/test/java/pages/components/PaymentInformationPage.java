package test.java.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.pages.BasePage;

public class PaymentInformationPage extends BasePage {

    // String locators
    private final String locatorTextNameOnCard = "cname";
    private final String locatorTextCreditCardNumber = "ccnum";
    private final String locatorSelectExpirationMonth = "expmonth";
    private final String locatorTextExpirationYear = "expyear";
    private final String locatorTextCvv = "cvv";

    // Element locators
    private By byTextNameOnCard = By.id(locatorTextNameOnCard);
    private By byTextCreditCardNumber = By.id(locatorTextCreditCardNumber);
    private By bySelectExpirationMonth = By.id(locatorSelectExpirationMonth);
    private By byTextExpirationYear = By.id(locatorTextExpirationYear);
    private By byTextCvv = By.id(locatorTextCvv);

    // Constructor
    public PaymentInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Methods
    public void enterTextNameOnCard(String nameOnCard) {
        sendKeys(locatorTextNameOnCard, byTextNameOnCard, nameOnCard);
    }

    public void enterTextCreditCardNumber(String creditCardNumber) {
        sendKeys(locatorTextCreditCardNumber, byTextCreditCardNumber, creditCardNumber);
    }

    public void setSelectExpirationMonth(String expirationMonth) {
        selectOption(locatorSelectExpirationMonth, bySelectExpirationMonth, expirationMonth);
    }

    public void enterTextExpirationYear(String expirationYear) {
        sendKeys(locatorTextExpirationYear, byTextExpirationYear, expirationYear);
    }

    public void enterTextCvv(String cvv) {
        sendKeys(locatorTextCvv, byTextCvv, cvv);
    }

    public void populatePaymentForm(String nameOnCard, String creditCardNumber, String expirationMonth, String expirationYear, String cvv) {
        enterTextNameOnCard(nameOnCard);
        enterTextCreditCardNumber(creditCardNumber);
        setSelectExpirationMonth(expirationMonth);
        enterTextExpirationYear(expirationYear);
        enterTextCvv(cvv);
    }
}
