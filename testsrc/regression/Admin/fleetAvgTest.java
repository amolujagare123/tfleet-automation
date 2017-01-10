package regression.Admin;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Admin.FleetAverage;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;

/**
 * Created by SAI RAM on 1/9/2017.
 */
public class fleetAvgTest {


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
    public void fleetAverage(String fleetNo, String fletAverage, String expected)
            throws IOException {

        ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");
        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver initialised");
            menu.clickFleetAverage();
            test.log(LogStatus.INFO, "Fleet Average page opened");

            FleetAverage fleetAverage = new FleetAverage(driver);
            test.log(LogStatus.INFO, "FleetAverage page object created");

            fleetAverage.setselectFleetNo(fleetNo);
            test.log(LogStatus.INFO, "Fleet No select");

            fleetAverage.setFleetAverageLnk(fletAverage);
            test.log(LogStatus.INFO, "save button clicked");


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Alert alert = driver.switchTo().alert();


            String actual = alert.getText();

            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);


            Assert.assertEquals(actual.trim(), expected.trim());
            test.log(LogStatus.PASS, "fleet Average done successfully");

            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));


        } catch (AssertionError e) {
            test.log(LogStatus.FAIL, e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));

        } catch (NoSuchElementException e) {
            test.log(LogStatus.FAIL, "Element not found : " + e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));

        } catch (Throwable e) {
            test.log(LogStatus.ERROR, "There is Error : " + e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));
        }

        extent.endTest(test);
        extent.flush();
    }

    @DataProvider
    public Object[][] getdata() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("Fleetverage");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][3];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell fleetNoCell = row.getCell(0);
            if (fleetNoCell == null) {
                data[i - 1][0] = "";
            } else {
                fleetNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = fleetNoCell.getStringCellValue();
            }

            HSSFCell averageCell = row.getCell(1);
            if (averageCell == null) {
                data[i - 1][1] = "";
            } else {
                averageCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = averageCell.getStringCellValue();
            }

            HSSFCell expectedResult = row.getCell(2);
            if (expectedResult == null) {
                data[i - 1][2] = "";

            } else {
                expectedResult.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = expectedResult.getStringCellValue();
            }


        }
        return data;

    }
}
