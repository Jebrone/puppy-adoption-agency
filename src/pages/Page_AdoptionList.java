package pages;

import org.openqa.selenium.WebDriver;

public class Page_AdoptionList extends Page_Base {

    public Page_AdoptionList(WebDriver driver) {
        super(driver);
    }

    public void visitPage() {
        driver.navigate().to(BASE_URL);
    }
    
    public Page_AdoptionList visitPage(int pageIndex) {
        driver.navigate().to(BASE_URL + "agency/index?page=" + pageIndex);
        return this;
    }

    public Page_PuppyDetails viewPuppiesDetails(String puppiesName) {
        // TODO Auto-generated method stub
        return pages.PuppyDetails();
    }

}
