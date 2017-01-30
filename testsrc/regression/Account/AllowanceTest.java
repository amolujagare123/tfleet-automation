package regression.Account;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Account.Allowance;
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

import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by tct4 on 1/17/2017.
 */
public class AllowanceTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();
    @BeforeClass
    public void init() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }

    @Test(dataProvider = "getAllowanceData")
    public void allowanceTest(String allowanceType, String employeeName, String description, String amount, String expected) throws IOException {
        ExtentTest test = extent.startTest("Test Allowance Page | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            menu.clickAccountAllowance();
            driver.manage().timeouts().implicitlyWait(40,SECONDS);
            Allowance allowance = new Allowance(driver);
            allowance.setSelectAllowanceType(allowanceType);
            Thread.sleep(3000);
            allowance.setSelectEmployee(employeeName);
            Thread.sleep(3000);
            allowance.setTxtDescription(description);
            allowance.setTxtAmount(amount);
            allowance.clickBtnSave();
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
            Alert alert = driver.switchTo().alert();
            String actual = alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(), expected.trim());

        }  catch (AssertionError e)
        {
            test.log(LogStatus.FAIL, e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }
        catch (NoSuchElementException e)
        {
            test.log(LogStatus.FAIL, "Element not found : "+e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }

        catch(Throwable e)
        {
            test.log(LogStatus.ERROR,"There is Error : "+e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
        }

        extent.endTest(test);
        extent.flush();


    }
    @DataProvider
    public Object[][] getAllowaneData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Account.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("AllowanceData");
        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][5];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);

            HSSFCell allowanceTypeCell = row.getCell(0);
            if (allowanceTypeCell == null) {
                data[i - 1][0] = "";
            } else {
                allowanceTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = allowanceTypeCell.getStringCellValue();
            }
            HSSFCell employeeNameCell = row.getCell(1);
            if (employeeNameCell == null) {
                data[i - 1][1] = "";
            } else {
                employeeNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = employeeNameCell.getStringCellValue();
            }
            HSSFCell descriptionCell = row.getCell(2);
            if (descriptionCell == null) {
                data[i - 1][2] = "";
            } else {
                descriptionCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = descriptionCell.getStringCellValue();
            }
            HSSFCell amountCell = row.getCell(3);
            if (amountCell == null) {
                data[i - 1][3] = "";
            } else {
                amountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = amountCell.getStringCellValue();
            }
            HSSFCell expectedCell = row.getCell(4);
            if (expectedCell == null)
            {
                data[i - 1][4] = "";
            } else
            {
                expectedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] =expectedCell.getStringCellValue();
            }


        }
return data;

    }



}
