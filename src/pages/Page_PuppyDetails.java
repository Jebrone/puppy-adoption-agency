package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_PuppyDetails extends Page_Base {
    
    private String pageUrl;
    
    private static final By ADOPT_BUTTON = By.cssSelector("[class='fees_line'] form [type='submit']");

    public Page_PuppyDetails(WebDriver driver) {
        super(driver);
        pageUrl = BASE_URL + "puppies/";
    }

    public Page_PuppyDetails visitPage(int puppyId) {
        System.out.println("Visiting Puppy Details Page [" + puppyId + "]");
        driver.navigate().to(pageUrl + puppyId);
        return this;
    }
    
    public Page_AdoptionCart adoptThePuppy() {
        System.out.println("Adopting this puppy");
        driver.findElement(ADOPT_BUTTON).click();
        return pages.AdoptionCart();
    }
}
