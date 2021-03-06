package regression.Reservation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.pages.Reservation.Reservation;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ReservationTest {
    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();
    @BeforeClass
    public void init()
    {

        driver.manage().window().maximize();
        LoginPage loginpage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        DashBoard dashboard = loginpage.Login("akshu.pokley@gmail.com", "123");

        driver.manage().timeouts().implicitlyWait(40, SECONDS);

    }
    @Test(dataProvider = "getReservationData")
    public void reservationTest(String date,String companyName, String reportingAddress, String rentalCity,
                                String nameOfGuest, String bookedBy, String mobileNo, String email, String otherMobNoForSMS,
                                String fleetCategory, String fleetType, String dateOfRequirement, String selectPackage,
                                String reportingTimeHr, String reportingTimeMin, String estimateAmount, String billingMode,
                                String specialInstruction, String expiryDate, String expected) throws IOException {
        ExtentTest test = extent.startTest("Test to make Reservation | save record", "To test the save button functionality");

        try {

            Menu menu = new Menu(driver);
            driver.manage().timeouts().implicitlyWait(50, SECONDS);
            menu.clickReservation();
            driver.manage().timeouts().implicitlyWait(60, SECONDS);
            Reservation reservation = new Reservation(driver);

            reservation.setSelectCompanyName(companyName);
            Thread.sleep(8000);

            reservation.setTxtReportingAddress(reportingAddress);
            Thread.sleep(3000);

            reservation.setSelectRentalCity(rentalCity);
            Thread.sleep(5000);

            reservation.setTxtNameOfGuest(nameOfGuest);
            Thread.sleep(3000);

            reservation.setTxtBookedBy(bookedBy);
            Thread.sleep(5000);

            reservation.setTxtMobileNo(mobileNo);
            reservation.setTxtEmail(email);
            reservation.setTxtOnotherMobNoForSMS(otherMobNoForSMS);
            Thread.sleep(3000);

            reservation.clickOnotherMobNoForSMS();

            reservation.setSelectFleetCategory(fleetCategory);
            Thread.sleep(8000);

            reservation.setSelectFleetType(fleetType);
            Thread.sleep(8000);

            reservation.setSelectPackage(selectPackage);
            Thread.sleep(8000);


            reservation.setSelectReportingTimeHrs(reportingTimeHr);
            Thread.sleep(8000);

            reservation.setSelectReportingTimeMin(reportingTimeMin);
            Thread.sleep(8000);


            reservation.setTxtEstimateAmount(estimateAmount);


            reservation.setSelectBillingMode(billingMode);
            Thread.sleep(3000);

            reservation.setTxtSpecialInstuction(specialInstruction);

            reservation.clickSave();
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
            Alert alert = driver.switchTo().alert();
            String actual = alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(), expected.trim());

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
    public Object[][] getReservationData() throws IOException {


        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Reservation.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        String[][] data = new String[rowCount - 1][20];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);

            /*HSSFCell reservationDateCell = row.getCell(0);
            if (reservationDateCell == null) {
                data[i - 1][0] = "";
            } else {
                reservationDateCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = reservationDateCell.getStringCellValue();
            }*/
            HSSFCell companyNameCell = row.getCell(1);
            if (companyNameCell == null)
            {
                data[i - 1][1] = "";
            } else
            {
                companyNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = companyNameCell.getStringCellValue();
            }
            HSSFCell reportingAddressCell = row.getCell(2);
            if (reportingAddressCell == null)
            {
                data[i - 1][2] = "";
            } else
            {
                reportingAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = reportingAddressCell.getStringCellValue();
            }
            HSSFCell rentalCityCell = row.getCell(3);
            if (rentalCityCell == null)
            {
                data[i - 1][3] = "";
            } else
            {
                rentalCityCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = rentalCityCell.getStringCellValue();
            }
            HSSFCell nameOfGuestCell = row.getCell(4);
            if (nameOfGuestCell == null)
            {
                data[i - 1][4] = "";
            } else
            {
                nameOfGuestCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] = nameOfGuestCell.getStringCellValue();
            }
            HSSFCell bookedByCell = row.getCell(5);
            if (bookedByCell  == null) {
                data[i - 1][5] = "";
            } else {
                bookedByCell .setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][5] = bookedByCell.getStringCellValue();
            }
            HSSFCell mobileNoCell = row.getCell(6);
            if (mobileNoCell  == null) {
                data[i - 1][6] = "";
            } else {
                mobileNoCell .setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][6] = mobileNoCell.getStringCellValue();
            }
            HSSFCell emailCell = row.getCell(7);
            if (emailCell  == null) {
                data[i - 1][7] = "";
            } else {
               emailCell .setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][7] =emailCell.getStringCellValue();
            }
            HSSFCell otherMobNoForSMSCell = row.getCell(8);
            if (otherMobNoForSMSCell  == null) {
                data[i - 1][8] = "";
            } else {
                otherMobNoForSMSCell .setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][8]=otherMobNoForSMSCell.getStringCellValue();
            }
            HSSFCell fleetCategoryCell = row.getCell(9);
            if (fleetCategoryCell  == null) {
                data[i - 1][9] = "";
            } else {
                fleetCategoryCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][9] =fleetCategoryCell.getStringCellValue();
            }
            HSSFCell fleetTypeCell = row.getCell(10);
            if (fleetTypeCell  == null) {
                data[i - 1][10] = "";
            } else {
                fleetTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][10] =fleetTypeCell.getStringCellValue();
            }
            /*HSSFCell dateOfRequirementCell = row.getCell(11);
            if (dateOfRequirementCell  == null) {
                data[i - 1][11] = "";
            } else {
                dateOfRequirementCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][11] =dateOfRequirementCell.getStringCellValue();
            }*/
            HSSFCell selectPackageCell = row.getCell(12);
            if (selectPackageCell == null) {
                data[i - 1][12] = "";
            } else {
                selectPackageCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][12] =selectPackageCell.getStringCellValue();
            }
            HSSFCell reportingTimeHrCell = row.getCell(13);
            if (reportingTimeHrCell == null) {
                data[i - 1][13] = "";
            } else {
                reportingTimeHrCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][13] =reportingTimeHrCell.getStringCellValue();
            }
            HSSFCell reportingTimeMinCell = row.getCell(14);
            if (reportingTimeMinCell == null) {
                data[i - 1][14] = "";
            } else {
                reportingTimeMinCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][14] =reportingTimeMinCell.getStringCellValue();
            }
            HSSFCell estimateAmountCell = row.getCell(15);
            if (estimateAmountCell == null) {
                data[i - 1][15] = "";
            } else {
                estimateAmountCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][15] =estimateAmountCell.getStringCellValue();
            }
            HSSFCell billingModeCell = row.getCell(16);
            if (billingModeCell == null) {
                data[i - 1][16] = "";
            } else {
                billingModeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][16] =billingModeCell .getStringCellValue();
            }
            HSSFCell specialInstructionCell = row.getCell(17);
            if (specialInstructionCell == null) {
                data[i - 1][17] = "";
            } else {
                specialInstructionCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][17] =specialInstructionCell.getStringCellValue();
            }
            /*HSSFCell expiryDateCell = row.getCell(18);
            if (expiryDateCell == null) {
                data[i - 1][18] = "";
            } else {
                expiryDateCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][18] =expiryDateCell .getStringCellValue();
            }*/
            HSSFCell expectedCell = row.getCell(19);
            if (expectedCell == null)
            {
                data[i - 1][19] = "";
            } else
            {
                expectedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][19] =expectedCell.getStringCellValue();
            }
        }

        return data;
    }

}
