package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.Page_Base;

public class TC_Base {

    protected WebDriver driver;
    protected Page_Base basePage;

    @BeforeTest
    @Parameters({"Operating System"})
    public void setup_InitializeDriver(String os) {
    	switch(os.toLowerCase()) {
    		case "windows":
    			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    			break;
    		case "mac":
    			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    			break;
    	}
    	
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        basePage = new Page_Base(driver);
    }
    
    @AfterTest
    public void teardown_CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
