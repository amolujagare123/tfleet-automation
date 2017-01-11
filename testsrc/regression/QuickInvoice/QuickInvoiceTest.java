package regression.QuickInvoice;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.pages.QuickInvoice.QuickInvoice;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by SAI RAM on 1/9/2017.
 */
public class QuickInvoiceTest {

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
    public void QuickInvoiceTest(String previousInvoice, String bookingNumber, String invoiceDate, String company, String reportingAddress,
                                 String rentalCity, String nameOfGuest, String bookedBy, String mobileNo, String email, String owned,
                                 String fleetCategory, String fleetType, String fleetNumber, String chauffeurName, String dateOut,
                                 String dateIn, String totalDays, String timeOut, String timeIn, String totalHrs, String kmOut,
                                 String kmIn, String totalKm, String packageName, String feedBack, String basicRate, String extraKmAmount,
                                 String extraHrAmount, String outStationAllowence, String nightAllowence, String parking, String toll,
                                 String otherRecoverable, String interStateTax, String total, String serviceTaxAmount, String grossAmount)
            throws IOException {

        ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver initialised");
            menu.clickQuickInvoice();
            test.log(LogStatus.INFO, "Quick Invoice page opened");

            QuickInvoice quickInvoice = new QuickInvoice(driver);
            test.log(LogStatus.INFO, "Quick Invoice page object created");

            quickInvoice.setSelectPreviousInvoice(previousInvoice);
            test.log(LogStatus.INFO, "Previous Invoice Select");

            quickInvoice.setBookingNo(bookingNumber);
            test.log(LogStatus.INFO, "Booking No set");

            quickInvoice.setSelectCompany(company);
            test.log(LogStatus.INFO, "company name select");

            quickInvoice.setTxtReportingAddress(reportingAddress);
            test.log(LogStatus.INFO, "Reporting address set");

            quickInvoice.setSelectRentalCity(rentalCity);
            test.log(LogStatus.INFO, "Rental City Select");

            quickInvoice.setTxtNameOfGuest(nameOfGuest);
            test.log(LogStatus.INFO,"Name of guest set");

            quickInvoice.setTxtBookedBy(bookedBy);
            test.log(LogStatus.INFO,"Booked by set");

            quickInvoice.setTxtMobileno(mobileNo);
            test.log(LogStatus.INFO,"Mobile no set");

            quickInvoice.setTxtEmail(email);
            test.log(LogStatus.INFO,"Email set");

            quickInvoice.clickOwned();
            test.log(LogStatus.INFO,"Clicked Owned");

            quickInvoice.setSelectFleetCategory(fleetCategory);
            test.log(LogStatus.INFO,"Fleet Category select");

            quickInvoice.setSelectFleetType(fleetType);
            test.log(LogStatus.INFO,"Fleet Type select");

            quickInvoice.setSelectFleetNo(fleetNumber);
            test.log(LogStatus.INFO,"Fleet No select");

            quickInvoice.setSelectChauffeurName(chauffeurName);
            test.log(LogStatus.INFO,"Chauffeur Name select");

            quickInvoice.setSelectTimeOutHr(timeOut);
            test.log(LogStatus.INFO,"TimeOutHr Select");

            quickInvoice.setSelectTimeOutMin(timeOut);
            test.log(LogStatus.INFO,"TimeOutMin Select");

            quickInvoice.setTotalHrs(totalHrs);
            test.log(LogStatus.INFO,"Total Hrs set");

            quickInvoice.setTxtKmOut(kmOut);
            test.log(LogStatus.INFO,"KM out set");

            quickInvoice.setTxtKmIn(kmIn);
            test.log(LogStatus.INFO,"Total KmIn set");

            quickInvoice.setSelectPackageName(packageName);
            test.log(LogStatus.INFO,"Package Name Select");

            quickInvoice.setTxtFeedBack(feedBack);
            test.log(LogStatus.INFO,"FeedBack set");





        } catch (AssertionError e) {
        }
    }
}