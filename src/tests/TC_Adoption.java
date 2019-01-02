package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Page_Home;

public class TC_Adoption extends TC_Base {
    protected Page_Home homePage;
    
    @BeforeMethod
    public void setup_GoToHomePage() {
        homePage = basePage.Pages.Home();
        homePage.visitPage();
    }

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
}
