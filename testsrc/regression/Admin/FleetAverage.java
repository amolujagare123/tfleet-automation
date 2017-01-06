package regression.Admin;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sai Ram on 09/08/2016.
 */
public class FleetAverage {

    //WebDriver driver = Driver.getDriver(Driver.DriverTypes.FIREFOX);
    //ExtentReports extent= initExtentReports.init();
WebDriver driver;
    @BeforeClass
    public void init() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void fleetaverageTest() throws IOException
    {

        Menu menu = new Menu(driver);

        //    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

            menu.clickAddClientUser();
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

        }





}
