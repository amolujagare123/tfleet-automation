package regression.Admin;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Admin.AddClientsUser;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Master.Add_Company;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sai Ram on 09/08/2016.
 */
public class AddClientsUserTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass

    public void init() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getdata")

    public void addClientUserTest(String companyName, String userEmailId, String password, String expected)
            throws IOException {
        ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver Initialised");
            menu.clickAddClientUser();
            test.log(LogStatus.INFO, "AddClientUser Page Opened");

            AddClientsUser addClientsUser = new AddClientsUser(driver);
            test.log(LogStatus.INFO, "AddClientUser page Object Created");

            addClientsUser.setCompany(companyName);
            test.log(LogStatus.INFO, "Company name set");

            addClientsUser.setUserEmailId(userEmailId);
            test.log(LogStatus.INFO, "User EmailId set");

            addClientsUser.setPassword(password);
            test.log(LogStatus.INFO, "Pasword set");

            addClientsUser.ClickSave();
            test.log(LogStatus.INFO, "Save button clicked");


        } catch (NoSuchElementException e) {

        }
    }

}
