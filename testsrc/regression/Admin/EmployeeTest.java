package regression.Admin;

import com.tfleet.pages.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

/**
 * Created by Sai Ram on 29/07/2016.
 */


public class EmployeeTest
{
    public static WebDriver driver;
    Menu menu = new Menu(driver);

    @BeforeClass
        public static void init(){
    }

    @BeforeTest
    public void openHomePage(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
