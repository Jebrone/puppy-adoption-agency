package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TC_Adoption extends TC_Base {

    @Test
    public void test_AdoptOnePuppy() {
        // TODO
    }

    @Test
    public void test_AdoptTwoPuppies() {
        // TODO
    }

    @Test
    public void test_AdoptTwoPuppiesWithAccessories() {
        // TODO
    }
    
    @AfterClass
    public void test_CleanUpAdoptions() throws UnirestException, InterruptedException {

        driver.navigate().to("http://puppies.herokuapp.com/adoptions");
        Thread.sleep(10000);

        List<WebElement> adoptions = driver
                .findElements(By.cssSelector("#content table tr td [data-method='delete']"));

        for (WebElement adopt : adoptions) {
            System.out.println(adopt.getAttribute("href"));

            HttpResponse<String> response = Unirest.post(adopt.getAttribute("href"))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body("_method=delete"
                            + "&"
                            + "authenticity_token=BnFWddxrYj2FzP753Y8buaL3jM9liUfo4AFY8Lir+MU=")
                    .asString();

            System.out.println("Status: " + response.getStatus() + " " + response.getStatusText());

        }
    }
}
