package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Page_OrderForm extends Page_Base {
    
    private static final By NAME_INPUT = By.cssSelector(".puppy_form form #order_name");
    private static final By ADDRESS_TEXTBOX = By.cssSelector(".puppy_form form #order_address");
    private static final By EMAIL_INPUT = By.cssSelector(".puppy_form form #order_email");
    private static final By PAY_TYPE_DROPDOWN = By.cssSelector(".puppy_form form #order_pay_type");
    private static final By PLACE_ORDER_BUTTON = By.cssSelector(".actions input[value='Place Order']");

    public Page_OrderForm(WebDriver driver) {
        super(driver);
    }

    public Page_OrderForm enterName(String adopterName) {
        System.out.println("Entering [" + adopterName + "] for Name");
        driver.findElement(NAME_INPUT).sendKeys(adopterName);
        return this;
    }

    public Page_OrderForm enterAddress(String adopterAddress) {
        System.out.println("Enter [" + adopterAddress + "] for Address");
        driver.findElement(ADDRESS_TEXTBOX).sendKeys(adopterAddress);
        return this;
    }

    public Page_OrderForm enterEmail(String adopterEmail) {
        System.out.println("Entering [" + adopterEmail + "] for Email");
        driver.findElement(EMAIL_INPUT).sendKeys(adopterEmail);
        return this;
    }

    public Page_OrderForm selectPaymentType(String paymentType) {
        System.out.println("Selecting [" + paymentType + "] for payment type");
        Select payTypeDropdown = new Select(driver.findElement(PAY_TYPE_DROPDOWN));
        payTypeDropdown.selectByValue(paymentType);
        return this;
    }

    public Page_AdoptionList placeOrder() {
        System.out.println("Placing Order");
        driver.findElement(PLACE_ORDER_BUTTON).click();
        return pages.AdoptionList();
    }

}
