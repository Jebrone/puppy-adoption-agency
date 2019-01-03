package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_AdoptionCart extends Page_Base {
    
    private final String pageUrl;

    private static final By COMPLETE_ADOPTION_BUTTON = By.cssSelector("[class='cart_buttons'] form [value='Complete the Adoption']");
    private static final By ADOPT_ANOTHER_PUPPY_BUTTON = By.cssSelector("[class='cart_buttons'] form [value='Adopt Another Puppy']");
    private static final By COLLAR_CHECKBOX = By.id("collar");
    private static final By TOY_CHECKBOX = By.id("toy");

    public Page_AdoptionCart(WebDriver driver) {
        super(driver);
        pageUrl = BASE_URL +"carts/";
    }

    public Page_AdoptionCart visitPage(int cartId) {
        System.out.println("Visiting Cart Page [" + cartId + "]");
        driver.navigate().to(pageUrl + cartId);
        return this;
    }

    public Page_OrderForm completeAdoption() {
        System.out.println("Completeing adoption process");
        driver.findElement(COMPLETE_ADOPTION_BUTTON).click();
        return pages.OrderForm();
    }
    
    public Page_AdoptionList adoptAnotherPuppy() {
        System.out.println("Adopting another puppy");
        driver.findElement(ADOPT_ANOTHER_PUPPY_BUTTON).click();
        return pages.AdoptionList();
    }

    public Page_AdoptionCart selectCollar(int index) {
        System.out.println("Selecting collar for puppy #" + (index + 1));
        driver.findElements(COLLAR_CHECKBOX).get(index).click();
        return this;
    }

    public Page_AdoptionCart selectToy(int index) {
        System.out.println("Selecting toy for puppy #" + (index + 1));
        driver.findElements(TOY_CHECKBOX).get(index).click();
        return this;
    }

}
