package pages;

import org.openqa.selenium.WebDriver;

public class Page_AdoptionCart extends Page_Base {
    
    private final String pageUrl;

    public Page_AdoptionCart(WebDriver driver) {
        super(driver);
        pageUrl = BASE_URL +"carts/";
    }

    public Page_AdoptionCart visitPage(int cartId) {
        driver.navigate().to(pageUrl + cartId);
        return this;
    }

    public Page_OrderForm completeAdoption() {
        // TODO Auto-generated method stub
        return pages.OrderForm();
    }
    
    public Page_AdoptionList adoptAnotherPuppy() {
        // TODO Auto-generated method stub
        return pages.AdoptionList();
    }

    public Page_AdoptionCart selectCollarForPuppy(String puppiesName) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_AdoptionCart selectToyForPuppy(String puppiesName) {
        // TODO Auto-generated method stub
        return this;
    }

}
