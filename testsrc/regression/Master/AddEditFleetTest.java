package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Master.Add_fleet;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.joda.time.Seconds;
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
 * Created by tct4 on 12/29/2016.
 */
public class AddEditFleetTest {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent= initExtentReport.init();

    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        DashBoard dashbord=loginPage.Login("akshu.pokley@gmail.com","123");
        driver.manage().timeouts().implicitlyWait(30,SECONDS);
    }

  /*  @Test(dataProvider="getOwnFleetData")
    public void AddEditOwnFleetTest(String fleetNo,String fleetCategory,String fleetType,
        String expected)throws IOException{
        ExtentTest test=extent.startTest("Add Fleet Test","To check functionality of save button");
        try
        {
            Menu menu=new Menu(driver);
            driver.manage().timeouts().implicitlyWait(30,SECONDS);
            menu.clickAddEditFleet();
            Add_fleet fleet=new Add_fleet(driver);
            fleet.setOwnTypeFleet();
            fleet.setFleetNumber(fleetNo);
            fleet.selectFleetCategory(fleetCategory);
            fleet.selectFleetType(fleetType);
            fleet.ClickBtnSave();
            Alert alert=driver.switchTo().alert();
            String actual=alert.getText();
            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);

            Assert.assertEquals(actual.trim(),expected.trim());
            test.log(LogStatus.PASS, "Fleet Added Successfully");

            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }
        catch (AssertionError e)
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
    public Object[][] getOwnFleetData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("AddEditOwnFleet");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][4];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell fleetNoCell = row.getCell(0);
            if (fleetNoCell == null) {
                data[i - 1][0] = "";
            } else {
                fleetNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = fleetNoCell.getStringCellValue();
            }

            HSSFCell fleetCategoryCell = row.getCell(1);
            if (fleetCategoryCell == null) {
                data[i - 1][1] = "";
            } else {
                fleetCategoryCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] =fleetCategoryCell.getStringCellValue();
            }

            HSSFCell fleetTypeCell = row.getCell(2);
            if (fleetTypeCell == null) {
                data[i - 1][2] = "";

            } else {
                fleetTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = fleetTypeCell.getStringCellValue();
            }

            HSSFCell expected=row.getCell(3);
            if(expected==null)
            {
                data[i-1][3]="";

            }else
            {
                expected.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=expected.getStringCellValue();
            }
        }
        return data;

    }
  */  @Test(dataProvider="getVendorFleetData")
    public void AddEditVendorFleetTest(String fleetNo,String fleetCategory,String fleetType,
                            String selectVendorName,String expected)throws IOException{
        ExtentTest test=extent.startTest("Add Fleet Test","To check functionality of save button");
        try
        {
            Menu menu=new Menu(driver);
            driver.manage().timeouts().implicitlyWait(50,SECONDS);
            menu.clickAddEditFleet();
            Add_fleet fleet=new Add_fleet(driver);
            fleet.setVendorTypeFleet();
            driver.manage().timeouts().implicitlyWait(50,SECONDS);
            fleet.setSelectVendorName(selectVendorName);
            fleet.setFleetNumber(fleetNo);
            fleet.selectFleetCategory(fleetCategory);
            fleet.selectFleetType(fleetType);
            fleet.ClickBtnSave();
            Alert alert=driver.switchTo().alert();
            String actual=alert.getText();
            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);

            Assert.assertEquals(actual.trim(),expected.trim());
            test.log(LogStatus.PASS, "Fleet Added Successfully");

            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }
        catch (AssertionError e)
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
    public Object[][] getVendorFleetData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("AddEditVendorFleet");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][5];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell fleetNoCell = row.getCell(0);
            if (fleetNoCell == null) {
                data[i - 1][0] = "";
            } else {
                fleetNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = fleetNoCell.getStringCellValue();
            }

            HSSFCell vendorNameCell = row.getCell(1);
            if ( vendorNameCell == null) {
                data[i - 1][1] = "";
            } else {
                vendorNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] =  vendorNameCell.getStringCellValue();
            }

            HSSFCell fleetCategoryCell = row.getCell(2);
            if (fleetCategoryCell == null) {
                data[i - 1][2] = "";
            } else {
                fleetCategoryCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] =fleetCategoryCell.getStringCellValue();
            }

            HSSFCell fleetTypeCell = row.getCell(3);
            if (fleetTypeCell == null) {
                data[i - 1][3] = "";

            } else {
                fleetTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = fleetTypeCell.getStringCellValue();
            }
            HSSFCell expected=row.getCell(4);
            if(expected==null)
            {
                data[i-1][4]="";

            }else
            {
                expected.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=expected.getStringCellValue();
            }
        }
        return data;

    }
    }