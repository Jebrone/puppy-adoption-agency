package tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data_providers.DP_Adoptions;
import pages.Page_AdoptionCart;
import pages.Page_AdoptionList;
import pages.Page_OrderForm;
import pages.Page_PuppyDetails;

public class TC_Adoption extends TC_Base {
    protected Page_AdoptionList adoptionListPage;
    protected Page_PuppyDetails puppyDetailsPage;
    protected Page_AdoptionCart adoptionCartPage;
    protected Page_OrderForm orderFormPage;
    
    @BeforeMethod
    public void setup_GoToHomePage() {
        adoptionListPage = basePage.pages.AdoptionList();
        adoptionListPage.visitPage();
    }

    @Test(
        dataProviderClass=DP_Adoptions.class,
        dataProvider = DP_Adoptions.TEST_NAME_SINGLE_ADOPTION)
    public void test_AdoptOnePuppy(Map<String, Object> puppy, Map<String, String> person, String paymentType) {
        puppyDetailsPage = adoptionListPage
            .viewPuppiesDetails((String) puppy.get("Name"));
        
        adoptionCartPage = puppyDetailsPage
            .adoptThePuppy();
        
        orderFormPage = adoptionCartPage
            .completeAdoption();
        
        adoptionListPage = orderFormPage
            .enterName(person.get("Name"))
            .enterAddress(person.get("Address"))
            .enterEmail(person.get("Email"))
            .selectPaymentType(paymentType)
            .placeOrder();
    }

    @Test(
        dataProviderClass=DP_Adoptions.class,
        dataProvider = DP_Adoptions.TEST_NAME_DOUBLE_ADOPTION)
    public void test_AdoptTwoPuppies(Map<String, Object> firstPuppy, Map<String, Object> secondPuppy, 
            Map<String, String> person, String paymentType) {
        adoptionListPage
            .viewPuppiesDetails((String) firstPuppy.get("Name"))
            .adoptThePuppy()
            .adoptAnotherPuppy()
            .viewPuppiesDetails((String) secondPuppy.get("Name"))
            .adoptThePuppy()
            .completeAdoption();

        orderFormPage
            .enterName(person.get("Name"))
            .enterAddress(person.get("Address"))
            .enterEmail(person.get("Email"))
            .selectPaymentType(paymentType)
            .placeOrder();
    }

    @Test(
        dataProviderClass=DP_Adoptions.class,
        dataProvider = DP_Adoptions.TEST_NAME_DOUBLE_ADOPTION_WITH_ACCESSORIES)
    public void test_AdoptTwoPuppiesWithAccessories(Map<String, Object> firstPuppy, Map<String, Object> secondPuppy, 
            Map<String, String> person, String paymentType) {
        adoptionListPage
            .viewPuppiesDetails((String) firstPuppy.get("Name"))
            .adoptThePuppy()
            .adoptAnotherPuppy()
            .viewPuppiesDetails((String) secondPuppy.get("Name"))
            .adoptThePuppy()

            .selectCollarForPuppy((String) firstPuppy.get("Name"))
            .selectToyForPuppy((String) firstPuppy.get("Name"))

            .selectCollarForPuppy((String) secondPuppy.get("Name"))
            .selectToyForPuppy((String) secondPuppy.get("Name"))
            .completeAdoption();

        orderFormPage
            .enterName(person.get("Name"))
            .enterAddress(person.get("Address"))
            .enterEmail(person.get("Email"))
            .selectPaymentType(paymentType)
            .placeOrder();
    }
}
