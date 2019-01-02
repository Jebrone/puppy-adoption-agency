package pages;

import org.openqa.selenium.WebDriver;

public class Page_OrderForm extends Page_Base {

    public Page_OrderForm(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public Page_OrderForm enterName(String adopterName) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_OrderForm enterAddress(String adopterAddress) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_OrderForm enterEmail(String adopterEmail) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_OrderForm selectPaymentType(String paymentType) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_AdoptionList placeOrder() {
        // TODO Auto-generated method stub
        return pages.AdoptionList();
    }

}
