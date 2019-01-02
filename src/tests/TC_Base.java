package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TC_Base {

    protected ChromeDriver driver;

    @BeforeTest
    public void setup_InitializeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @AfterTest
    public void teardown_CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
