package regression.Dispatch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.tfleet.pages.DashBoard;
import regression.LoginPage;
import com.tfleet.pages.Menu;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * Created by TCT on 24-12-15.
 */
public class DutySlipTest {
    public static WebDriver driver;


    @BeforeClass
    public static void init() {

    }

   @BeforeTest
   public void openDutySlipPage()
   {
       driver = new FirefoxDriver();
       driver.manage().window().maximize();
       LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       DashBoard dashBoard = loginPage.Login("tcraft@pranali", "tcraft123");
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


   }

    @Test
    public void showButtonTest() throws ParseException {
        Menu menu=new Menu(driver);
        menu.clickCreateDutySlip();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //DutySlip ds = new DutySlip(driver);
        //ds.gotoDS("0054");
        /*ds.setFromDate("1/12/2015");
        ds.setToDate("31/12/2015");
        ds.setSelectCompany("seed");
        ds.clickShow();
        ds.clickEditDS("0054", "DS Not Created");*/
    }


}
