package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Master.AddPump;
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
 * Created by tct4 on 12/29/2016.
 */



/**
 * Created by tct4 on 12/27/2016.
 */
public class AddPumpTest {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent= initExtentReport.init();

    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard=loginPage.Login("akshu.pokley@gmail.com","123");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }
    @Test(dataProvider = "getData")
    public void addPumpTest(String pumpName, String pumpAddress, String pumpEmail,String pumpLandLineNo,
                              String pumpContactNo,String pumpContactPerson,String expected)throws IOException
    {
        ExtentTest test= extent.startTest("Test Add Pump","To check functionality of Save button");
        try
        {
            Menu menu=new Menu(driver);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            menu.clickPetrolPump();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            AddPump pump=new AddPump(driver);
            pump.setTxtPumpName(pumpName);
            pump.setTxtPumpAddress(pumpAddress);
            pump.setTextEmail(pumpEmail);
            pump.setTxtLandlineNo(pumpLandLineNo);
            pump.setTxtConNo(pumpContactNo);
            pump.setTxtConPerson(pumpContactPerson);
            pump.clickSave();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            Alert alert=driver.switchTo().alert();
            String actual=alert.getText();

            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);


            Assert.assertEquals(actual.trim(), expected.trim());
            test.log(LogStatus.PASS, "PetrolPump Added Successfully");

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
    public Object[][] getData() throws IOException
    {
        FileInputStream fileInputStream=new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook=new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet=workbook.getSheet("AddPetrolPump");
        int rowCount=worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount-1][7];
        for(int i=1;i<rowCount;i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell pumpNameCell = row.getCell(0);
            if (pumpNameCell == null) {
                data[i - 1][0] = "";
            } else {
               pumpNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = pumpNameCell.getStringCellValue();
            }

            HSSFCell pumpAddressCell = row.getCell(1);
            if (pumpAddressCell == null) {
                data[i - 1][1] = "";
            } else {
                pumpAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = pumpAddressCell.getStringCellValue();
            }

            HSSFCell pumpEmailCell = row.getCell(2);
            if (pumpEmailCell == null) {
                data[i - 1][2] = "";

            }
            else
            {
                pumpEmailCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = pumpEmailCell.getStringCellValue();
            }

            HSSFCell pumpLandLineNoCell=row.getCell(3);
            if(pumpLandLineNoCell==null)
            {
                data[i-1][3]="";

            }else
            {
                pumpLandLineNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=pumpLandLineNoCell.getStringCellValue();
            }

            HSSFCell pumpContPerCell=row.getCell(4);
            if(pumpContPerCell==null)
            {
                data[i-1][4]="";

            }else
            {
                pumpContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=pumpContPerCell.getStringCellValue();
            }

            HSSFCell pumpContNoCell=row.getCell(5);
            if(pumpContNoCell==null)
            {
                data[i-1][5]="";

            }else
            {
                pumpContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][5]=pumpContNoCell.getStringCellValue();
            }

            HSSFCell expected=row.getCell(6);
            if(expected==null)
            {
                data[i-1][6]="";

            }else
            {
                expected.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][6]=expected.getStringCellValue();
            }
        }
        return  data;

    }

}









