package regression.Account;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Account.FuelConsumption;
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
public class FuelConsumptionTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass
    public void init() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        DashBoard dashboard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }
    @Test(dataProvider = "getFuelConsumptionData")
    public void fuelConsumptionTest(String fleetNo, String Location, String meterReading, String totalLiter, String costPerLiter,
                                    String chaufferName, String approvalManager,String pnrNo, String pumpName, String Description,
                                    String Expected) throws IOException
    {
        ExtentTest test = extent.startTest("Test Fuel Consumption Page || To save Record", "To test Save button functionality");
        try {

            Menu menu = new Menu(driver);
            driver.manage().timeouts().implicitlyWait(50, SECONDS);
            menu.clickAccount_FuelConsumption();
            driver.manage().timeouts().implicitlyWait(50, SECONDS);
            FuelConsumption fuel = new FuelConsumption(driver);
            fuel.setSelectFleetNo(fleetNo);
            fuel.setTxtLocation(Location);
            fuel.setTxtMeterReading(meterReading);
            fuel.setTxtTotalLiter(totalLiter);
            fuel.setTxtCostPerLiter(costPerLiter);
            fuel.setTxtChaufferName(chaufferName);
            fuel.setSelectApprovalManager(approvalManager);
            fuel.setTxtPNRNo(pnrNo);
            fuel.setSelectPump(pumpName);
            fuel.clickSelectPaid();
            fuel.setTxtDescription(Description);
            fuel.clickbtnSave();
            Alert alert=driver.switchTo().alert();
            String actual=alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(),Expected.trim());
        }
        catch (AssertionError e) {
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
    public Object[][] getFuelConsumptionData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Account.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("FuelConsumptionData");
        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][10];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);
            HSSFCell fleetNoCell = row.getCell(0);
            if (fleetNoCell == null) {
                data[i - 1][0] = "";
            } else {
                fleetNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = fleetNoCell.getStringCellValue();
            }
            HSSFCell locationCell = row.getCell(1);
            if (locationCell == null) {
                data[i - 1][1] = "";
            } else {
                locationCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = locationCell.getStringCellValue();
            }
            HSSFCell meterReading = row.getCell(2);
            if (meterReading == null) {
                data[i - 1][2] = "";
            } else {
                meterReading.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = meterReading.getStringCellValue();
            }
            HSSFCell totalLtrCell = row.getCell(3);
            if (totalLtrCell == null) {
                data[i - 1][3] = "";
            } else {
                totalLtrCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = totalLtrCell.getStringCellValue();
            }
            HSSFCell costPerLitCell = row.getCell(4);
            if (costPerLitCell == null) {
                data[i - 1][4] = "";
            } else {
                costPerLitCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] = costPerLitCell.getStringCellValue();
            }

            HSSFCell chauffeurCell = row.getCell(5);
            if (chauffeurCell == null) {
                data[i - 1][5] = "";
            } else {
                chauffeurCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][5] = chauffeurCell.getStringCellValue();
            }
            HSSFCell approvalManagerCell = row.getCell(6);
            if (approvalManagerCell == null) {
                data[i - 1][6] = "";
            } else {
                approvalManagerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][6] = approvalManagerCell.getStringCellValue();
            }
            HSSFCell pnrNoCell = row.getCell(7);
            if (pnrNoCell == null) {
                data[i - 1][7] = "";
            } else {
                pnrNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][7] = pnrNoCell.getStringCellValue();
            }
            HSSFCell pumpNameCell = row.getCell(8);
            if (pumpNameCell == null) {
                data[i - 1][8] = "";
            } else {
                pumpNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][8] = pumpNameCell.getStringCellValue();
            }
            HSSFCell descriptionCell = row.getCell(9);
            if (descriptionCell == null) {
                data[i - 1][9] = "";
            } else {
                descriptionCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][9] = descriptionCell.getStringCellValue();
            }
            HSSFCell expectedCell = row.getCell(10);
            if (expectedCell == null) {
                data[i - 1][10] = "";
            } else {
                expectedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][10] = expectedCell.getStringCellValue();
            }
        }
        return data;

    }
}


