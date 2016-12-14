package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Master.Add_Package;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by tct4 on 9/21/2016.
 */
public class Addpackagetest {
 WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent= initExtentReport.init();
    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginpage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard=loginpage.Login("akshay85pokley@gmail.com", "123");

    }
    @Test(dataProvider = "getData")
    public void Addpackagetest(String pkgName,String basicHr, String basicKm, String extraHrAmt,
                               String extraKmAmt,String pkgAmt,String fleetCategory, String fleetType)throws IOException
    {
        ExtentTest test=extent.startTest("Add Package Test","To test save button functionality");
        Menu menu=new Menu(driver);
        menu.clickPackage();
        Add_Package addPackage=new Add_Package(driver);
        addPackage.setPkgName(pkgName);
        addPackage.setPkgAmnt(pkgAmt);
        addPackage.setBasicHrs(basicHr);
        addPackage.setBasicKms(basicKm);
        addPackage.selectFleetCategory(fleetCategory);

    }




}
