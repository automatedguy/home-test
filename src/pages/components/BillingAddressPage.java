package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BillingAddressPage extends BasePage {

    // String locators
    private final String locatorTextFullName = "fname";
    private final String locatorTextEmail = "email";
    private final String locatorTextAddress = "adr";
    private final String locatorTextCity = "city";
    private final String locatorTextState = "state";
    private final String locatorTextZipCode = "zip";
    private final String locatorCheckboxShippingAddressSameAsBilling = "sameadr";

    // Element locators
    private By byTextFullName = By.id(locatorTextFullName);
    private By byTextEmail = By.id(locatorTextEmail);
    private By byTextAddress = By.id(locatorTextAddress);
    private By byTextCity = By.id(locatorTextCity);
    private By byTextState = By.id(locatorTextState);
    private By byTextZipCode = By.id(locatorTextZipCode);

    private By byCheckboxShippingAddressSameAsBilling = By.name(locatorCheckboxShippingAddressSameAsBilling);

    public BillingAddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterTextFullName(String fullName) {
        sendKeys(locatorTextFullName, byTextFullName, fullName);
    }

    public void enterTextEmail(String email) {
        sendKeys(locatorTextEmail, byTextEmail, email);
    }

    public void enterTextAddress(String address) {
        sendKeys(locatorTextAddress, byTextAddress, address);
    }

    public void enterTextCity(String city) {
        sendKeys(locatorTextCity, byTextCity, city);
    }

    public void enterTextState(String state) {
        sendKeys(locatorTextState, byTextState, state);
    }

    public void enterTextZipCode(String zipCode) {
        sendKeys(locatorTextZipCode, byTextZipCode, zipCode);
    }

    public void clickCheckboxShippingAddressSameAsBilling(boolean checked) {
        if (isElementSelected(locatorCheckboxShippingAddressSameAsBilling, byCheckboxShippingAddressSameAsBilling) != checked) {
            clickElement(locatorCheckboxShippingAddressSameAsBilling, byCheckboxShippingAddressSameAsBilling);
        }
    }

    public void populateBillingAddress(String fullName, String email, String address, String city, String state, String zipCode, boolean shippingAddressSameAsBilling) {
        enterTextFullName(fullName);
        enterTextEmail(email);
        enterTextAddress(address);
        enterTextCity(city);
        enterTextState(state);
        enterTextZipCode(zipCode);
        clickCheckboxShippingAddressSameAsBilling(shippingAddressSameAsBilling);
    }
}
