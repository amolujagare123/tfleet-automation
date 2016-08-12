package regression.Dispatch;


import com.tfleet.pages.DashBoard;
import com.tfleet.pages.Dispatch.CreateDutySlip;
import com.tfleet.pages.Dispatch.DutySlip;
import regression.LoginPage;
import com.tfleet.pages.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * Created by tcraft on 26/12/2015.
 */
public class CrateDSTest {

    public static WebDriver driver;
    Menu menu=new Menu(driver);

    @BeforeClass
    public static void init() {

    }

    @BeforeTest
    public void openHomePage()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://192.168.0.125:99/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("tcraft@pranali", "tcraft123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void createDS() throws ParseException, InterruptedException {

       DutySlip DS= new DutySlip(driver);
     CreateDutySlip cds=DS.gotoDS("0001");
     // cds.clickFleetTypeVendor();

      cds.selectFleetType("ECONOMY");
        Thread.sleep(5000);
        cds.selectFleetType("TATA INDICA");
        Thread.sleep(5000);
        cds.selectFleetNo("MH 12 AS 1234");

        cds.selectChauffer("Jitendra");
        Thread.sleep(5000);
        cds.setKmOut("0");
        cds.selectHr("01");
        cds.selectMin("15");
        cds.setDispatchDate("01/01/2016");
        cds.clickSendMail();
        // DutySlip DS= new DutySlip(driver);
        DS.gotoDS("0054");
     //   CreateDutySlip cds= new CreateDutySlip(driver);
        /*DutySlip DS= new DutySlip(driver);
        DS.gotoDS("0054");*/
   //     cds.selectFleetCategory("bus");

    }

}
