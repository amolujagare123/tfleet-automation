package regression.QuickInvoice;

import com.relevantcodes.extentreports.ExtentReports;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by SAI RAM on 1/9/2017.
 */
public class QuickInvoice {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass
    public void init(){
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getdata")
    public void QuickInvoiceTest(String previousInvoice,String bookingNumber,String invoiceDate,String company,String reportingAddress,
                                 String rentalCity,String nameOfGuest,String bookedBy,String mobileNo,String email,String fleetType,
                                 String owned,String fleetCategory,String fleetType,String )


}
