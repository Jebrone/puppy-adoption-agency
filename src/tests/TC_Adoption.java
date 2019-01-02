package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Page_AdoptionList;
import pages.Page_OrderForm;
import pages.Page_PuppyDetails;
import pages.Page_AdoptionCart;

public class TC_Adoption extends TC_Base {
    protected Page_AdoptionList adoptionListPage;
    protected Page_PuppyDetails puppyDetailsPage;
    protected Page_AdoptionCart adoptionCartPage;
    protected Page_OrderForm orderFormPage;
    
    @BeforeClass
    public void setup_InitializePages() {
        adoptionListPage = basePage.pages.AdoptionList();
        puppyDetailsPage = basePage.pages.PuppyDetails();
        adoptionCartPage = basePage.pages.AdoptionCart();
        orderFormPage = basePage.pages.OrderForm();
    }
    
    @BeforeMethod
    public void setup_GoToHomePage() {
        adoptionListPage.visitPage();
    }

    @Test
    public void test_AdoptOnePuppy(String puppiesName, 
            String adopterName, String adopterAddress, String adopterEmail, String paymentType) {
        adoptionListPage
            .viewPuppiesDetails(puppiesName)
            .adoptThePuppy()
            .completeAdoption();
        
        orderFormPage
            .enterName(adopterName)
            .enterAddress(adopterAddress)
            .enterEmail(adopterEmail)
            .selectPaymentType(paymentType)
            .placeOrder();
    }

    @Test
    public void test_AdoptTwoPuppies(String firstPuppiesName, String secondPuppiesName,
            String adopterName, String adopterAddress, String adopterEmail, String paymentType) {
        adoptionListPage
            .viewPuppiesDetails(firstPuppiesName)
            .adoptThePuppy()
            .adoptAnotherPuppy()
            .viewPuppiesDetails(secondPuppiesName)
            .adoptThePuppy()
            .completeAdoption();

        orderFormPage
            .enterName(adopterName)
            .enterAddress(adopterAddress)
            .enterEmail(adopterEmail)
            .selectPaymentType(paymentType)
            .placeOrder();
    }

    @Test
    public void test_AdoptTwoPuppiesWithAccessories(String firstPuppiesName, String secondPuppiesName,
            String adopterName, String adopterAddress, String adopterEmail, String paymentType) {
        adoptionListPage
            .viewPuppiesDetails(firstPuppiesName)
            .adoptThePuppy()
            .adoptAnotherPuppy()
            .viewPuppiesDetails(secondPuppiesName)
            .adoptThePuppy()

            .selectCollarForPuppy(firstPuppiesName)
            .selectToyForPuppy(firstPuppiesName)

            .selectCollarForPuppy(secondPuppiesName)
            .selectToyForPuppy(secondPuppiesName)
            .completeAdoption();

        orderFormPage
            .enterName(adopterName)
            .enterAddress(adopterAddress)
            .enterEmail(adopterEmail)
            .selectPaymentType(paymentType)
            .placeOrder();
    }
}
