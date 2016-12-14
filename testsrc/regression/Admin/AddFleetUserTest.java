package regression.Admin;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Admin.AddFleetUser;
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
import org.openqa.selenium.UnhandledAlertException;
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
 * Created by Sai Ram on 09/08/2016.
 */
public class AddFleetUserTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass

    public void init() {

        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshay85pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getdata")

    public void addfleetUserTest(String employee, String email, String password) throws IOException {

        ExtentTest test = extent.startTest("Test add FleetUser | Save record ", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver Initialized");
            menu.clickAddFleetUser();
            test.log(LogStatus.INFO, "Add FleetUser page opened");

            AddFleetUser addFleetUser = new AddFleetUser(driver);
            test.log(LogStatus.INFO, "Add FleetUser page Objet created");

            addFleetUser.setSelectEmployee(employee);
            test.log(LogStatus.INFO, "Employee name set");

            addFleetUser.setEmail(email);
            test.log(LogStatus.INFO, "Employee Email set");

            addFleetUser.setPassword(password);
            test.log(LogStatus.INFO, "password set");

            addFleetUser.clickSave();
            test.log(LogStatus.INFO, "Save button clicked");

            String expected = "FleetUser added successfuly";
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Alert alert = driver.switchTo().alert();
            String Actual = alert.getText();
            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + Actual);

            try {
                Assert.assertEquals(Actual.trim(), expected.trim(), "Test Fail");
                test.log(LogStatus.INFO, "FleetUser added successfully");
            } catch (AssertionError e) {
                test.log(LogStatus.INFO, "add FleetUser page objet created");
                test.log(LogStatus.INFO, "snapshot below" + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));
            }
        } catch (UnhandledAlertException e) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Throwable e) {
            test.log(LogStatus.ERROR, "There is exception" + e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));
        }

        extent.endTest(test);
        extent.flush();
    }

    @DataProvider
    public Object[][] getdata() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/addFleetUser.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("Sheet1");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][3];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);


            HSSFCell employeeCell = row.getCell(0);
            if (employeeCell == null) {
                data[i - 1][0] = "";
            } else {
                employeeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = employeeCell.getStringCellValue();
            }

            HSSFCell emailCell = row.getCell(1);
            if (emailCell == null) {
                data[i - 1][1] = "";
            } else {
                emailCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = emailCell.getStringCellValue();
            }

            HSSFCell passwordCell = row.getCell(2);
            if (passwordCell == null) {
                data[i - 1][2] = "";
            } else {
                passwordCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = passwordCell.getStringCellValue();
            }


        }

        return data;
    }

}
