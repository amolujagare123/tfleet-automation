package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;


import com.tfleet.pages.Master.Add_Garage;
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
public class AddGarageTest {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent= initExtentReport.init();

    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard=loginPage.Login("akshu.pokley@gmail.com","123");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }
    @Test(dataProvider = "getData")
    public void addGarageTest(String garageName, String garageAddress, String garageEmail,String garageLandLineNo,
                              String garageContactNo,String garageContactPerson,String expected)throws IOException
    {
        ExtentTest test= extent.startTest("Test Add Garage","To check functionality of Save button");
        try{
            Menu menu=new Menu(driver);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            menu.clickAddGarage();
            driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

            Add_Garage garage=new Add_Garage(driver);
            garage.setTxtGarageName(garageName);
            garage.setTxtGarageAddress(garageAddress);
            garage.setTextGarageEmail(garageEmail);
            garage.setTxtGarageLandlineNo(garageLandLineNo);
            garage.setTxtGarageConNo(garageContactNo);
            garage.setTxtGarageConPerson(garageContactPerson);

            garage.clickSave();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            Alert alert=driver.switchTo().alert();
            String actual=alert.getText();

            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);


            Assert.assertEquals(actual.trim(), expected.trim());
            test.log(LogStatus.PASS, "Garage Added Successfully");

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

        HSSFSheet worksheet=workbook.getSheet("AddGarage");
        int rowCount=worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount-1][7];
        for(int i=1;i<rowCount;i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell garageNameCell = row.getCell(0);
            if (garageNameCell == null) {
                data[i - 1][0] = "";
            } else {
                garageNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = garageNameCell.getStringCellValue();
            }

            HSSFCell garageAddressCell = row.getCell(1);
            if (garageAddressCell == null) {
                data[i - 1][1] = "";
            } else {
                garageAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = garageAddressCell.getStringCellValue();
            }

            HSSFCell garageEmailCell = row.getCell(2);
            if (garageEmailCell == null) {
                data[i - 1][2] = "";

            }
            else
            {
                garageEmailCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] =garageEmailCell.getStringCellValue();
            }

            HSSFCell garageLandLineNoCell=row.getCell(3);
            if(garageLandLineNoCell==null)
            {
                data[i-1][3]="";

            }else
            {
                garageLandLineNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=garageLandLineNoCell.getStringCellValue();
            }

            HSSFCell garageContPerCell=row.getCell(4);
            if(garageContPerCell==null)
            {
                data[i-1][4]="";

            }else
            {
                garageContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=garageContPerCell.getStringCellValue();
            }

            HSSFCell garageContNoCell=row.getCell(5);
            if(garageContNoCell==null)
            {
                data[i-1][5]="";

            }else
            {
                garageContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][5]=garageContNoCell.getStringCellValue();
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









