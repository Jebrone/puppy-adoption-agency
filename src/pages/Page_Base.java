package pages;

import org.openqa.selenium.WebDriver;

public class Page_Base {
    
    public Pages pages;
    protected WebDriver driver;
    
    protected static final String BASE_URL = "http://puppies.herokuapp.com/";
    
    public Page_Base(WebDriver driver) {
        this.driver = driver;
        this.pages = new Pages();
    }
    
    public class Pages {
        
        public Page_AdoptionList AdoptionList() {
            return new Page_AdoptionList(driver);
        }

        public Page_PuppyDetails PuppyDetails() {
            return new Page_PuppyDetails(driver);
        }

        public Page_AdoptionCart AdoptionCart() {
            return new Page_AdoptionCart(driver);
        }
        
        public Page_OrderForm OrderForm() {
            return new Page_OrderForm(driver);
            
        }
    }
}
