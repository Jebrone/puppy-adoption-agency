package pages;

import org.openqa.selenium.WebDriver;

public class Page_Home extends Page_Base {

    public Page_Home(WebDriver driver) {
        super(driver);
    }

    public void visitPage() {
        driver.navigate().to(BASE_URL);
    }

}
