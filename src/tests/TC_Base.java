package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.Page_Base;

public class TC_Base {

    protected WebDriver driver;
    protected Page_Base basePage;

    @BeforeTest
    public void setup_InitializeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage = new Page_Base(driver);
    }
    
    @AfterTest
    public void teardown_CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
