package pages;

import org.openqa.selenium.WebDriver;

public class Page_Base {
    protected WebDriver driver;
    
    public Page_Base(WebDriver driver) {
        this.driver = driver;
    }
    
}
