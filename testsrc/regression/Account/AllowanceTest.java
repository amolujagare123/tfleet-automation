package regression.Account;

import com.tfleet.pages.Account.Allowance;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
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

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by tct4 on 1/17/2017.
 */
public class AllowanceTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    @BeforeClass
    public void init() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
    }

    @Test(dataProvider = "getAllowanceData")
    public void allowanceTest(String allowanceType, String employeeName, String description, String amount, String expected) throws IOException {
        try {
            Menu menu = new Menu(driver);
            menu.clickAccount();
            Allowance allowance = new Allowance(driver);
            allowance.setSelectAllowanceType(allowanceType);
            allowance.setSelectEmployee(employeeName);
            allowance.setTxtDescription(description);
            allowance.setTxtAmount(amount);
            allowance.clickBtnSave();
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
            Alert alert = driver.switchTo().alert();
            String actual = alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(), expexted.trim());

        } catch (AssertionError e) {

            System.out.print("there is an error" + e);
        } catch (NoSuchElementException e) {
            System.out.print("there is an error" + e);
        } catch (Throwable e) {
            System.out.print("there is an error" + e);
        }

    }
    @DataProvider
    public Object[][] getAllowanceData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Account.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("AllowanceData");
        int rowcount = sheet.getPhysicalNumberOfRows();
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
