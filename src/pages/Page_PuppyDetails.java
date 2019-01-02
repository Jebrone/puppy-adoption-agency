package pages;

import org.openqa.selenium.WebDriver;

public class Page_PuppyDetails extends Page_Base {
    
    private String pageUrl;

    public Page_PuppyDetails(WebDriver driver) {
        super(driver);
        pageUrl = BASE_URL + "puppies/";
    }

    public Page_PuppyDetails visitPage(int puppyId) {
        driver.navigate().to(pageUrl + puppyId);
        return this;
    }
    
    public Page_AdoptionCart adoptThePuppy() {
        // TODO Auto-generated method stub
        return pages.AdoptionCart();
    }
}
