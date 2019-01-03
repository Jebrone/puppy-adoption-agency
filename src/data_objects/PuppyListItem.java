package data_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PuppyListItem {
    private WebElement puppyListElement;
    
    private static final By NAME = By.cssSelector("[class='name'] *");
    private static final By BREED = By.cssSelector("[class='details'] *:nth-child(1)");
    private static final By GENDER = By.cssSelector("[class='details'] *:nth-child(2)");
    private static final By FORM = By.cssSelector("[class='view'] form");
    private static final By VIEW_DETAILS_BUTTON = By.cssSelector("[class='view'] [value='View Details']");
    
    private String name, breed, gender, url;
    
    public PuppyListItem(WebElement puppyListElement) {
        this.puppyListElement = puppyListElement;
        name = puppyListElement.findElement(NAME).getText();
        breed = puppyListElement.findElement(BREED).getText();
        gender = puppyListElement.findElement(GENDER).getText();
        url = puppyListElement.findElement(FORM).getAttribute("action");
    }
    
    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public String getUrl() {
        return url;
    }
    
    public int getId() {
        String[] list = url.split("/");
        return Integer.parseInt(list[list.length - 1]);
    }
    
    public void clickViewDetails() {
        puppyListElement.findElement(VIEW_DETAILS_BUTTON).click();
    }
    
    public String toString() {
        return "[Name: " + this.name + "][Breed: " + this.breed + "][Gender: " + this.gender + "][ID: " + getId() + "]";
    }
}
