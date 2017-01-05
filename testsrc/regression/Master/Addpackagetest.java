package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Master.Add_Package;
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
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by tct4 on 9/21/2016.
 */
public class Addpackagetest
{
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass
    public void init() {
        driver.manage().window().maximize();
        LoginPage loginpage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        DashBoard dashBoard = loginpage.Login("akshu.pokley@gmail.com", "123");

    }

    @Test(dataProvider = "getData")
    public void Addpackagetest(String pkgName, String basicHr, String basicKm, String extraHrAmt,
                               String extraKmAmt, String pkgAmt, String fleetCategory, String fleetType, String expected) throws IOException {
        ExtentTest test = extent.startTest("Add Package Test", "To test save button functionality");
        try {
            Menu menu = new Menu(driver);
            menu.clickPackage();

            Add_Package addPackage = new Add_Package(driver);
            addPackage.setPkgName(pkgName);
            addPackage.setPkgAmnt(pkgAmt);
            addPackage.setBasicHrs(basicHr);
            addPackage.setBasicKms(basicKm);
            addPackage.setExtraHrsAmt(extraHrAmt);
            addPackage.setExtraKmsAmt(extraKmAmt);
            addPackage.selectFleetCategory(fleetCategory);
            driver.manage().timeouts().implicitlyWait(40, SECONDS);
            addPackage.selectFleetType(fleetType);
            addPackage.ClickBtnSave();
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
            Alert alert = driver.switchTo().alert();
            String actual = alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(), expected.trim());
            test.log(LogStatus.PASS, "Package Added Successfully");

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
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("AddPackageData");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][9];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell packageNameCell = row.getCell(0);
            if (packageNameCell == null) {
                data[i - 1][0] = "";
            } else {
                packageNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = packageNameCell.getStringCellValue();
            }

            HSSFCell packageAmountCell = row.getCell(1);
            if (packageAmountCell == null) {
                data[i - 1][1] = "";
            } else {
                packageAmountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = packageAmountCell.getStringCellValue();
            }

            HSSFCell packageBasicHrCell = row.getCell(2);
            if (packageBasicHrCell == null) {
                data[i - 1][2] = "";

            } else {
                packageBasicHrCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = packageBasicHrCell.getStringCellValue();
            }

            HSSFCell packageBasicKmCell = row.getCell(3);
            if (packageBasicKmCell == null) {
                data[i - 1][3] = "";

            } else {
                packageBasicKmCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = packageBasicKmCell.getStringCellValue();
            }

            HSSFCell packacgeExtHrAmountCell = row.getCell(4);
            if (packacgeExtHrAmountCell == null) {
                data[i - 1][4] = "";

            } else {
                packacgeExtHrAmountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] = packacgeExtHrAmountCell.getStringCellValue();
            }

            HSSFCell packageExtKmAmountCell = row.getCell(5);
            if (packageExtKmAmountCell == null) {
                data[i - 1][5] = "";

            } else {
                packageExtKmAmountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][5] = packageExtKmAmountCell.getStringCellValue();
            }

            HSSFCell packageFleetCategoryCell = row.getCell(6);
            if (packageFleetCategoryCell == null) {
                data[i - 1][6] = "";

            } else {
                packageFleetCategoryCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][6] = packageFleetCategoryCell.getStringCellValue();
            }

            HSSFCell packageFleetTypeCell = row.getCell(7);
            if (packageFleetTypeCell == null) {
                data[i - 1][7] = "";

            } else {
                packageFleetTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][7] = packageFleetTypeCell.getStringCellValue();
            }

            HSSFCell expactedResultCell = row.getCell(8);
            if (expactedResultCell == null) {
                data[i - 1][8] = "";

            } else {
                expactedResultCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][8] = expactedResultCell.getStringCellValue();
            }
        }
        return data;
    }
}