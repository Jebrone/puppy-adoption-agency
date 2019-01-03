package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_PuppyDetails extends Page_Base {
    
    private String pageUrl;

    private static final By ADOPT_BUTTON = By.cssSelector(".fees_line form [value='Adopt Me!']");
    private static final By ADOPTION_FEE = By.cssSelector(".fees_line .fees");

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

    public Double getAdoptionFee() {
        System.out.println("Getting Adoption Fee");
        Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]{2}");
        Matcher match = pattern.matcher(driver.findElement(ADOPTION_FEE).getText());
        if (match.find()) {
            return Double.parseDouble(match.group(0));
        }
        return null;
    }
}
