package regression.QuickInvoice;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.pages.QuickInvoice.QuickInvoice;
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
 * Created by SAI RAM on 1/9/2017.
 */
public class QuickInvoiceTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();

    @BeforeClass
    public void init() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getdata")
    public void QuickInvoiceTest(String previousInvoice, String bookingNumber, String invoiceDate, String company, String reportingAddress,
                                 String rentalCity, String nameOfGuest, String bookedBy, String mobileNo, String email, String owned,
                                 String fleetCategory, String fleetType, String fleetNumber, String chauffeurName, String dateOut,
                                 String dateIn, String totalDays, String timeOut, String timeIn, String totalHrs, String kmOut,
                                 String kmIn, String totalKm, String packageName, String feedBack, String basicRate, String extraKmAmount,
                                 String extraHrAmount, String outStationAllowence, String nightAllowence, String parking, String toll,
                                 String otherRecoverable, String interStateTax, String total, String serviceTaxAmount, String grossAmount,
                                 String expected)
            throws IOException {

        ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver initialised");
            menu.clickQuickInvoice();
            test.log(LogStatus.INFO, "Quick Invoice page opened");

            QuickInvoice quickInvoice = new QuickInvoice(driver);
            test.log(LogStatus.INFO, "Quick Invoice page object created");

            quickInvoice.setSelectPreviousInvoice(previousInvoice);
            test.log(LogStatus.INFO, "Previous Invoice Select");

            quickInvoice.setBookingNo(bookingNumber);
            test.log(LogStatus.INFO, "Booking No set");

            quickInvoice.setSelectCompany(company);
            test.log(LogStatus.INFO, "company name select");

            quickInvoice.setTxtReportingAddress(reportingAddress);
            test.log(LogStatus.INFO, "Reporting address set");

            quickInvoice.setSelectRentalCity(rentalCity);
            test.log(LogStatus.INFO, "Rental City Select");

            quickInvoice.setTxtNameOfGuest(nameOfGuest);
            test.log(LogStatus.INFO, "Name of guest set");

            quickInvoice.setTxtBookedBy(bookedBy);
            test.log(LogStatus.INFO, "Booked by set");

            quickInvoice.setTxtMobileno(mobileNo);
            test.log(LogStatus.INFO, "Mobile no set");

            quickInvoice.setTxtEmail(email);
            test.log(LogStatus.INFO, "Email set");

            quickInvoice.clickOwned();
            test.log(LogStatus.INFO, "Clicked Owned");

            quickInvoice.setSelectFleetCategory(fleetCategory);
            test.log(LogStatus.INFO, "Fleet Category select");

            quickInvoice.setSelectFleetType(fleetType);
            test.log(LogStatus.INFO, "Fleet Type select");

            quickInvoice.setSelectFleetNo(fleetNumber);
            test.log(LogStatus.INFO, "Fleet No select");

            quickInvoice.setSelectChauffeurName(chauffeurName);
            test.log(LogStatus.INFO, "Chauffeur Name select");

            quickInvoice.setSelectTimeOutHr(timeOut);
            test.log(LogStatus.INFO, "TimeOutHr Select");

            quickInvoice.setSelectTimeOutMin(timeOut);
            test.log(LogStatus.INFO, "TimeOutMin Select");

            quickInvoice.setSelectTimeInHr(timeIn);
            test.log(LogStatus.INFO, "TimeinHr select ");

            quickInvoice.setSelectTimeInMin(timeIn);
            test.log(LogStatus.INFO, "TimeinMin select");

            quickInvoice.setTotalHrs(totalHrs);
            test.log(LogStatus.INFO, "Total Hrs set");

            quickInvoice.setTxtKmOut(kmOut);
            test.log(LogStatus.INFO, "KM out set");

            quickInvoice.setTxtKmIn(kmIn);
            test.log(LogStatus.INFO, "KmIn set");

            quickInvoice.setTotalKm(totalKm);
            test.log(LogStatus.INFO, "Total KM set");

            quickInvoice.setSelectPackageName(packageName);
            test.log(LogStatus.INFO, "Package Name Select");

            quickInvoice.setTxtFeedBack(feedBack);
            test.log(LogStatus.INFO, "FeedBack set");

            quickInvoice.setTxtBasicRate((basicRate));
            test.log(LogStatus.INFO, "Basic Rate set");

            quickInvoice.setTxtExtraKmAmount(extraKmAmount);
            test.log(LogStatus.INFO, "Extra KM Amount set");

            quickInvoice.setTxtExtraHrAmount(extraHrAmount);
            test.log(LogStatus.INFO, "Extra HR Amount set");

            quickInvoice.setTxtOutStationAllowance(outStationAllowence);
            test.log(LogStatus.INFO, "Out Station Allowance set");

            quickInvoice.setTxtNightAllowance(nightAllowence);
            test.log(LogStatus.INFO, "Night Station Allowance set");

            quickInvoice.setTxtParking(parking);
            test.log(LogStatus.INFO, "Parking Allowance set");

            quickInvoice.setTxtToll(toll);
            test.log(LogStatus.INFO, "Toll set");

            quickInvoice.setTxtOtherRecovery(otherRecoverable);
            test.log(LogStatus.INFO, "Other Recovereable set");

            quickInvoice.setTxtInterStateTax(interStateTax);
            test.log(LogStatus.INFO, "InterStateTax set");

            quickInvoice.clickchkServiceTax();
            test.log(LogStatus.INFO, "Service tax checked");

            quickInvoice.setTotal(total);
            test.log(LogStatus.INFO, "Total set");

            quickInvoice.setTxtServiceTaxAmount(serviceTaxAmount);
            test.log(LogStatus.INFO, "service Tax Amount set");

            quickInvoice.setTxtGrossAmount(grossAmount);
            test.log(LogStatus.INFO, "Gross Amount set");

            quickInvoice.clickchkSendEmailToClient();
            test.log(LogStatus.INFO, "Send email to client Checked");

            quickInvoice.clickCreate();
            test.log(LogStatus.INFO, "Create clicked");


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Alert alert = driver.switchTo().alert();


            String actual = alert.getText();

            alert.accept();
            test.log(LogStatus.INFO, "alert displayed as " + actual);


            Assert.assertEquals(actual.trim(), expected.trim());
            test.log(LogStatus.PASS, "Company Added Successfully");

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
    public Object[][] getdata() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_Master.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet = workbook.getSheet("AddCompanyData");
        int rowCount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][40];
        for (int i = 1; i < rowCount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell previousInvoiceCell = row.getCell(0);
            if (previousInvoiceCell == null) {
                data[i - 1][0] = "";
            } else {
                previousInvoiceCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = previousInvoiceCell.getStringCellValue();
            }

            HSSFCell bookingNumberCell = row.getCell(1);
            if (bookingNumberCell == null) {
                data[i - 1][1] = "";
            } else {
                bookingNumberCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = bookingNumberCell.getStringCellValue();
            }

            HSSFCell CompanyCell = row.getCell(2);
            if (CompanyCell == null) {
                data[i - 1][2] = "";
            } else {
                CompanyCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = CompanyCell.getStringCellValue();
            }

            HSSFCell reportingAddressCell = row.getCell(3);
            if (reportingAddressCell == null) {
                data[i - 1][3] = "";
            } else {
                reportingAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = reportingAddressCell.getStringCellValue();
            }

            HSSFCell rentalCityCell = row.getCell(4);
            if (rentalCityCell == null) {
                data[i - 1][4] = "";
            } else {
                rentalCityCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][4] = rentalCityCell.getStringCellValue();
            }

            HSSFCell nameOfGuestCell = row.getCell(5);
            if (nameOfGuestCell == null) {
                data[i - 1][5] = "";
            } else {
                nameOfGuestCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][5] = nameOfGuestCell.getStringCellValue();
            }

            HSSFCell bookedByCell = row.getCell(6);
            if (bookedByCell == null) {
                data[i - 1][6] = "";
            } else {
                bookedByCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][6] = bookedByCell.getStringCellValue();
            }

            HSSFCell mobileNoCell = row.getCell(7);
            if (mobileNoCell == null) {
                data[i - 1][7] = "";
            } else {
                mobileNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][7] = mobileNoCell.getStringCellValue();
            }

            HSSFCell emailCell = row.getCell(8);
            if (emailCell == null) {
                data[i - 1][8] = "";
            } else {
                emailCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][8] = emailCell.getStringCellValue();
            }

            HSSFCell fleetCategoryCell = row.getCell(9);
            if (fleetCategoryCell == null) {
                data[i - 1][9] = "";
            } else {
                fleetCategoryCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][9] = fleetCategoryCell.getStringCellValue();
            }

            HSSFCell fleetTypeCell = row.getCell(10);
            if (fleetTypeCell == null) {
                data[i - 1][10] = "";
            } else {
                fleetTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][10] = fleetTypeCell.getStringCellValue();
            }

            HSSFCell fleetNumberCell = row.getCell(11);
            if (fleetNumberCell == null) {
                data[i - 1][11] = "";
            } else {
                fleetNumberCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][11] = fleetNumberCell.getStringCellValue();
            }

            HSSFCell chauffeurNameCell = row.getCell(12);
            if (chauffeurNameCell == null) {
                data[i - 1][12] = "";
            } else {
                chauffeurNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][12] = chauffeurNameCell.getStringCellValue();
            }

            HSSFCell dateOutCell = row.getCell(13);
            if (dateOutCell == null) {
                data[i - 1][13] = "";
            } else {
                dateOutCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][13] = dateOutCell.getStringCellValue();
            }

            HSSFCell dateInCell = row.getCell(14);
            if (dateInCell == null) {
                data[i - 1][14] = "";
            } else {
                dateInCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][14] = dateInCell.getStringCellValue();
            }

            HSSFCell timeOutHrCell = row.getCell(15);
            if (timeOutHrCell == null) {
                data[i - 1][15] = "";
            } else {
                timeOutHrCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][15] = timeOutHrCell.getStringCellValue();
            }

            HSSFCell timeOutMinCell = row.getCell(16);
            if (timeOutMinCell == null) {
                data[i - 1][16] = "";
            } else {
                timeOutMinCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][16] = timeOutMinCell.getStringCellValue();
            }

            HSSFCell timeInHrCell = row.getCell(17);
            if ( timeInHrCell == null) {
                data[i - 1][17] = "";
            } else {
                timeInHrCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][17] =  timeInHrCell.getStringCellValue();
            }

            HSSFCell timeInMinCell = row.getCell(18);
            if ( timeInMinCell == null) {
                data[i - 1][18] = "";
            } else {
                timeInMinCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][18] =  timeInMinCell.getStringCellValue();
            }














        }
    }
