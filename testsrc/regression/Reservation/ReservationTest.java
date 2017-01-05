package regression.Reservation;

import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.pages.Reservation.Reservation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ReservationTest {
    WebDriver driver;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        LoginPage loginpage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().window().maximize();
        DashBoard dashboard = loginpage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);

        driver.manage().timeouts().implicitlyWait(40, SECONDS);

    }

    @Test(dataProvider = "getReservationData")
    public void reservationTest(String date, String companyName, String reportingAddress, String rentalCity,
                                String nameOfGuest, String bookedBy, String mobileNo, String email, String otherMobNoForSMS,
                                String fleetCategory, String fleetType, String dateOfRequirement, String selectPackage,
                                String reportingTimeHr, String reportingTimeMin, String estimateAmount, String billingMode,
                                String specialInstruction, String expiryDate, String expected) throws IOException {

        try {


            Menu menu = new Menu(driver);
            menu.clickReservation();
            Reservation reservation = new Reservation(driver);

            reservation.setSelectCompanyName(companyName);
            reservation.setTxtReportingAddress(reportingAddress);
            reservation.setSelectRentalCity(rentalCity);
            reservation.setTxtNameOfGuest(nameOfGuest);
            reservation.setTxtBookedBy(bookedBy);
            reservation.setTxtMobileNo(mobileNo);
            reservation.setTxtEmail(email);
            reservation.setTxtOnotherMobNoForSMS(otherMobNoForSMS);
            reservation.setSelectFleetCategory(fleetCategory);
            reservation.setSelectFleetType(fleetType);
            reservation.setSelectPackage(selectPackage);
            reservation.setSelectReportingTimeHrs(reportingTimeHr);
            reservation.setSelectReportingTimeMin(reportingTimeMin);
            reservation.setTxtEstimateAmount(estimateAmount);
            reservation.setSelectBillingMode(billingMode);
            reservation.setTxtSpecialInstuction(specialInstruction);
            reservation.clickSave();
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
            Alert alert = driver.switchTo().alert();
            String actual = alert.getText();
            alert.accept();
            Assert.assertEquals(actual.trim(), expected.trim());

        } catch (Throwable e) {
            System.out.print("there is an error" + e);
        }
    }

    @DataProvider
    public Object[][] getReservationData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Reservation.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = hssfWorkbook.getSheet("Resevation");
        int rowCount = sheet.getPhysicalNumberOfRows();

        String[][] data = new String[rowCount - 1][22];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);


            HSSFCell reservationDateCell = row.getCell(0);
            if (reservationDateCell == null) {
                data[i - 1][0] = "";
            } else {
                reservationDateCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = reservationDateCell.getStringCellValue();
            }
            HSSFCell companyNameCell = row.getCell(1);
            if (companyNameCell == null) {
                data[i - 1][1] = "";
            } else {
                companyNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = companyNameCell.getStringCellValue();
            }
            HSSFCell reportingAddressCell = row.getCell(2);
            if (reportingAddressCell == null) {
                data[i - 1][2] = "";
            } else {
                reportingAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = reportingAddressCell.getStringCellValue();
            }
            HSSFCell rentalCityCell = row.getCell(3);
            if (rentalCityCell == null) {
                data[i - 1][3] = "";
            } else {
                rentalCityCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = rentalCityCell.getStringCellValue();
            }

        }

        return data;
    }

}
