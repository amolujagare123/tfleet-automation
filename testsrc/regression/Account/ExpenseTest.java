package regression.Account;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.Account.Expense;
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
public class ExpenseTest {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();
    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        DashBoard dashboard=loginPage.Login("akshu.pokley@gmail.com","123");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }

    @Test(dataProvider = "getExpenceData")
    public void expenseTest(String pnrNo, String fleetNo, String expenditureType, String employeeName, String paidtoParty
    String description,String paymentMode,String amount,String additionalInformation,String expected) throws IOException {
        ExtentTest test = extent.startTest("Test Expence page | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            menu.clickAccountExpense();
            driver.manage().timeouts().implicitlyWait(40,SECONDS);
            Expense expense = new Expence(driver);
            expense.setTxtPNRNo(pnrNo);
            expense.setSelectFleetNo(fleetNo);
            Thread.sleep(3000);
            expense.setSelectExpenditureType(expenditureType);
            Thread.sleep(3000);
            expense.setSelectEmployee(employeeName);
            Thread.sleep(3000);
            expense.setTxtpaidToParty(paidtoParty);
            expense.setSelectPaymentMode(paymentMode);
            Thread.sleep(3000);
            expense.setTxtAmount(amount);
            expense.setTxtAdditionalInformation(additionalInformation);
            expense.clickBtnSave();
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
    public Object[][] getExpenceData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Account.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("ExpenseData");
        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][9];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);

            HSSFCell pnrNoCell = row.getCell(0);
            if (pnrNoCell == null) {
                data[i - 1][0] = "";
            } else {
                pnrNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = pnrNoCell.getStringCellValue();
            }
            HSSFCell fleetNoCell = row.getCell(1);
            if (fleetNoCell == null) {
                data[i - 1][1] = "";
            } else {
                fleetNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = fleetNoCell.getStringCellValue();
            }
            HSSFCell expenditureTypeCell = row.getCell(2);
            if (expenditureTypeCell == null) {
                data[i - 1][2] = "";
            } else {
                expenditureTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = expenditureTypeCell.getStringCellValue();
            }
            HSSFCell employeeNameCell = row.getCell(3);
            if (employeeNameCell == null) {
                data[i - 1][3] = "";
            } else {
                employeeNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = employeeNameCell.getStringCellValue();
            }
            HSSFCell paidToParty = row.getCell(4);
            if (paidToParty == null)
            {
                data[i - 1][4] = "";
            } else
            {
                paidToParty.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] =paidToParty.getStringCellValue();
            }
            HSSFCell descriptionCell = row.getCell(5);
            if (descriptionCell == null) {
                data[i - 1][5] = "";
            } else {
                descriptionCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][5] = descriptionCell.getStringCellValue();
            }
            HSSFCell paymentModeCell = row.getCell(6);
            if (paymentModeCell == null) {
                data[i - 1][6] = "";
            } else {
                paymentModeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][6] =paymentModeCell.getStringCellValue();
            }
            HSSFCell amountCell = row.getCell(7);
            if (amountCell == null) {
                data[i - 1][7] = "";
            } else {
                amountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][7] = amountCell.getStringCellValue();
            }
            HSSFCell additionalInformationCell = row.getCell(8);
            if (additionalInformationCell == null) {
                data[i - 1][8] = "";
            } else {
                additionalInformationCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][8] = additionalInformationCell.getStringCellValue();
            }
            HSSFCell expectedCell = row.getCell(9);
            if (expectedCell == null)
            {
                data[i - 1][9] = "";
            } else
            {
                expectedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][9] =expectedCell.getStringCellValue();
            }


        }
        return data;

    }



}







