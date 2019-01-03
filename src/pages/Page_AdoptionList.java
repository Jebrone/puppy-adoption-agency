package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data_objects.PuppyListItem;

public class Page_AdoptionList extends Page_Base {
    
    private static final By PUPPY_LIST = By.className("puppy_list");
    private static final By NEXT_PAGE = By.className("next_page");

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
        PuppyListItem puppy;
        do {
            for(WebElement puppyElement: driver.findElements(PUPPY_LIST)) {
                puppy = new PuppyListItem(puppyElement);
                System.out.println(puppy.toString());
                if (puppy.getName().equals(puppiesName)) {
                    puppy.clickViewDetails();
                }
            }
        } while(nextPage());
        
        return pages.PuppyDetails();
    }

    private Boolean nextPage() {
        WebElement next = driver.findElement(NEXT_PAGE);
        if (next.isEnabled()) {
            next.click();
            return true;
        } else {
            return false;
        }
        
    }
}
