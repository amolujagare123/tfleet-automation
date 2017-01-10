package regression.Admin;


        import com.relevantcodes.extentreports.ExtentReports;
        import com.relevantcodes.extentreports.ExtentTest;
        import com.relevantcodes.extentreports.LogStatus;
        import com.tfleet.pages.Admin.AddEmployee;
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
        import org.openqa.selenium.UnhandledAlertException;
        import org.openqa.selenium.WebDriver;
        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.concurrent.TimeUnit;

        import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;

/**
 * Created by Sai Ram on 29/07/2016.
 */

public class AddEmployeetest {

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
        public void AddEmployeetest(String employeeName, String contactNo, String email, String designation,
                                     String branch,String expected) throws IOException {

            ExtentTest test = extent.startTest("Test Add employee | save record", "To test the save button functionality");
            try {
                Menu menu = new Menu(driver);
                test.log(LogStatus.INFO, "Menu Driver initialised");
                
                menu.clickAddEmployee();
                test.log(LogStatus.INFO, "Add Emloyee page opened");

                AddEmployee addemployee = new AddEmployee(driver);
                test.log(LogStatus.INFO, "Add Employee page objet created");

                addemployee.setEmpNameText(employeeName);
                test.log(LogStatus.INFO, "Employee name set");

                addemployee.setSelectDesignation(designation);
                test.log(LogStatus.INFO, "Designation set");


                addemployee.setContactNoText(contactNo);
                test.log(LogStatus.INFO, "Contact no set");

                addemployee.setEmailText(email);
                test.log(LogStatus.INFO, "Email set");

                addemployee.setSelectBranch(branch);
                test.log(LogStatus.INFO, "Branch set");

                addemployee.clickSave();
                test.log(LogStatus.INFO, "Save button click");

                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                Alert alert = driver.switchTo().alert();


                String actual = alert.getText();

                alert.accept();
                test.log(LogStatus.INFO, "alert displayed as " + actual);


                Assert.assertEquals(actual.trim(), expected.trim());
                test.log(LogStatus.PASS, "Employee Added Successfully");

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
        public Object[][] getdata() throws IOException

        {
            FileInputStream fileInputStream = new FileInputStream("Excelsheet/Regression_admin.xls");

            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet Worksheet = workbook.getSheet("Regression_admin");
            int rowCount = Worksheet.getPhysicalNumberOfRows();
            String[][] data = new String[rowCount - 1][6];
            for (int i = 1; i < rowCount; i++) {
                HSSFRow row = Worksheet.getRow(i);

                HSSFCell EmployeeNameCell = row.getCell(0);
                if (EmployeeNameCell == null) {
                    data[i - 1][0] = "";
                } else {
                    EmployeeNameCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][0] = EmployeeNameCell.getStringCellValue();
                }

                HSSFCell ContactNoCell = row.getCell(1);
                if (ContactNoCell == null) {
                    data[i - 1][1] = "";
                } else {
                    ContactNoCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][1] = ContactNoCell.getStringCellValue();
                }

                HSSFCell EmailCell = row.getCell(2);
                if (EmailCell == null) {
                    data[i - 1][2] = "";
                } else {
                    EmailCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][2] = EmailCell.getStringCellValue();
                }

                HSSFCell DesignationCell = row.getCell(3);
                if (DesignationCell == null) {
                    data[i - 1][3] = "";
                } else {
                    DesignationCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][3] = DesignationCell.getStringCellValue();
                }

                HSSFCell BranchCell = row.getCell(4);
                if (BranchCell == null) {
                    data[i - 1][4] = "";
                } else {
                    BranchCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][4] = BranchCell.getStringCellValue();
                }
                HSSFCell expectedResultCell = row.getCell(5);
                if (expectedResultCell == null) {
                    data[i - 1][5] = "";
                } else {
                    expectedResultCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i - 1][5] = expectedResultCell.getStringCellValue();
                }



            }
            return data;

        }
    }


    /*@Test
    public void emloyeeTestcancel() {
        Menu menu = new Menu(driver);
        menu.clickAddEmployee();

        AddEmployee addemployee = new AddEmployee(driver);
        addemployee.setEmpNameText("Om");
        addemployee.setContactNoText("7894561230");
        addemployee.setEmailText("om@gmail.com");
        addemployee.setSelectBranch("PUNE");
        addemployee.setSelectDesignation("MANAGER");

        addemployee.clickCancel();

        String strempname = addemployee.getEmName();
        String strcontactno = addemployee.getContactNo();
        String stremail = addemployee.getEmail();
        String strbranch = addemployee.getSelectBranch();
        String strdesignation = addemployee.getSelectDesignation();


        //ArrayList<String> listActual = new ArrayList<~>();
        ArrayList<String> listActual =new ArrayList<String>();
        listActual.add(strempname);
        listActual.add(strcontactno);
        listActual.add(stremail);
        listActual.add(strbranch);
        listActual.add(strdesignation);


        ArrayList<String> listexpected = new ArrayList<String>();
        listexpected.add("");
        listexpected.add("");
        listexpected.add("");
        listexpected.add("");
        listexpected.add("");

        Assert.assertEquals(listActual,listexpected,"Test Fail");
        driver.quit();
    }

    }*/

