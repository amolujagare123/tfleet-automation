package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;

import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;

import com.tfleet.pages.Master.Add_Company;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by tct4 on 8/9/2016.
 */
public class AddCompanyTest
{
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    ExtentReports extent = initExtentReport.init();
    @BeforeClass
    public void init()
    {

        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshu.pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test(dataProvider = "getdata")
    public void addCompanyTest(String companyName, String companyEmail, String companyAddress, String companyLandLineNo,
                               String priContPers, String priContNo, String secContPer, String secContNo, String thirdContPer,
                               String thirdContNo, String fourthContPer, String fourthContNo,String fifthContPer, String fifthContNo,
                               String sixthContactPer, String sixthContactNo)
                               throws IOException {

        ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");

        try {
            Menu menu = new Menu(driver);
            test.log(LogStatus.INFO, "Menu Driver initialised");
            menu.clickAddCompany();
            test.log(LogStatus.INFO, "Add company page opened");

            Add_Company addcompany = new Add_Company(driver);
            test.log(LogStatus.INFO, "Add company page object created");
            addcompany.setTxtCompName(companyName);
            test.log(LogStatus.INFO, "Comapany name set ");
            addcompany.setTextCompEmail(companyEmail);
            test.log(LogStatus.INFO, "Comapany Email set ");
            addcompany.setTxtCompAddress(companyAddress);
            test.log(LogStatus.INFO, "Comapany Address set ");
            addcompany.setTxtLandlineNo(companyLandLineNo);
            test.log(LogStatus.INFO, "Comapany Landline no set ");
            addcompany.setTxtPrimConPerson(priContPers);
            test.log(LogStatus.INFO, "Comapany Primary Contact Person set ");
            addcompany.setTxtPrimConNo(priContNo);
            test.log(LogStatus.INFO, "Comapany Primary no set ");
            addcompany.setTxtSecConPerson(secContPer);
            test.log(LogStatus.INFO, "Comapany Secondary Contact Person set ");
            addcompany.setTxtSecConNo(secContNo);
            test.log(LogStatus.INFO, "Comapany Secondary Contact no set ");
            addcompany.setTxtTerConPerson(thirdContPer);
            test.log(LogStatus.INFO, "Comapany Third Contact Person set ");
            addcompany.setTxtTerConNo(thirdContNo);
            test.log(LogStatus.INFO, "Comapany Third Contact no set ");
            addcompany.setTxtFourthConPerson(fourthContPer);
            test.log(LogStatus.INFO, "Comapany Fourth Contact Person set ");
            addcompany.setTxtFourthConNo(fourthContNo);
            test.log(LogStatus.INFO, "Comapany Fourth Contact no set ");
            addcompany.setTxtFifthConPerson(fifthContPer);
            test.log(LogStatus.INFO, "Comapany Fifth Contact Person set ");
            addcompany.setTxtFifthConNo(fifthContNo);
            test.log(LogStatus.INFO, "Comapany Fifth Contact no set ");
            addcompany.setTxtsixthConPerson(sixthContactPer);
            test.log(LogStatus.INFO, "Comapany Sixth Contact Person set ");
            addcompany.setTxtsixthConNo(sixthContactNo);
            test.log(LogStatus.INFO, "Comapany Sixth Contact no set ");
            addcompany.clickSave();
            test.log(LogStatus.INFO, "save button clicked");

           String expected = "Company Added Successfully";
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
           Alert alert = driver.switchTo().alert();


           String Actual = alert.getText();

            alert.accept();
           test.log(LogStatus.INFO, "alert displayed as " + Actual);


              Assert.assertEquals(Actual.trim(), expected.trim());
              test.log(LogStatus.PASS, "Company Added Successfully");

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
      /*  catch (UnhandledAlertException e)
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();

            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

*//*
            Assert.assertEquals(Actual.trim(), expected.trim(), "Test fail");
            test.log(LogStatus.PASS, "Company Added Successfully");
*//*
        }*/
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
        FileInputStream fileInputStream=new FileInputStream("Excelsheet/addCompanyData.xls");

        HSSFWorkbook workbook=new HSSFWorkbook(fileInputStream);

        HSSFSheet worksheet=workbook.getSheet("Sheet1");
        int rowCount=worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount-1][16];
        for(int i=1;i<rowCount;i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell companyNameCell = row.getCell(0);
            if (companyNameCell == null) {
                data[i - 1][0] = "";
            } else {
                companyNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = companyNameCell.getStringCellValue();
            }

            HSSFCell companyEmailCell = row.getCell(1);
            if (companyEmailCell == null) {
                data[i - 1][1] = "";
            } else {
                companyEmailCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = companyEmailCell.getStringCellValue();
            }

            HSSFCell companyAddressCell = row.getCell(2);
            if (companyAddressCell == null) {
                data[i - 1][2] = "";

            }
            else
            {
                companyAddressCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = companyAddressCell.getStringCellValue();
            }

            HSSFCell companyLandLineNoCell=row.getCell(3);
            if(companyLandLineNoCell==null)
            {
                data[i-1][3]="";

            }else
            {
                companyLandLineNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=companyLandLineNoCell.getStringCellValue();
            }

            HSSFCell companyPrimContPerCell=row.getCell(4);
            if(companyPrimContPerCell==null)
            {
                data[i-1][4]="";

            }else
            {
               companyPrimContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=companyPrimContPerCell.getStringCellValue();
            }

            HSSFCell companyPrimContNoCell=row.getCell(5);
            if(companyPrimContNoCell==null)
            {
                data[i-1][5]="";

            }else
            {
                companyPrimContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][5]=companyPrimContNoCell.getStringCellValue();
            }

            HSSFCell companySecContPerCell=row.getCell(6);
            if(companySecContPerCell==null)
            {
                data[i-1][6]="";

            }else
            {
                companySecContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][6]=companySecContPerCell.getStringCellValue();
            }

            HSSFCell companySecContNoCell=row.getCell(7);
            if(companySecContNoCell==null)
            {
                data[i-1][7]="";

            }else
            {
                companySecContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][7]=companySecContNoCell.getStringCellValue();
            }

            HSSFCell companyThirdContPerCell=row.getCell(8);
            if(companyThirdContPerCell==null)
            {
                data[i-1][8]="";

            }else
            {
                companyThirdContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][8]=companyThirdContPerCell.getStringCellValue();
            }

            HSSFCell companyThirdContNoCell=row.getCell(9);
            if(companyThirdContNoCell==null)
            {
                data[i-1][9]="";

            }else
            {
                companyThirdContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][9]=companyThirdContNoCell.getStringCellValue();
            }


            HSSFCell companyFourthContPerCell=row.getCell(10);
            if(companyFourthContPerCell==null)
            {
                data[i-1][10]="";

            }else
            {
                companyFourthContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][10]=companyFourthContPerCell.getStringCellValue();
            }

            HSSFCell companyFourthContNoCell=row.getCell(11);
            if(companyFourthContNoCell==null)
            {
                data[i-1][11]="";

            }else
            {
                companyFourthContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][11]=companyFourthContNoCell.getStringCellValue();
            }


            HSSFCell companyFifthContPerCell=row.getCell(12);
            if(companyFifthContPerCell==null)
            {
                data[i-1][12]="";

            }else
            {
                companyFifthContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][12]=companyFifthContPerCell.getStringCellValue();
            }

            HSSFCell companyFifthContNoCell=row.getCell(13);
            if(companyFifthContNoCell==null)
            {
                data[i-1][13]="";

            }else
            {
                companyFifthContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][13]=companyFifthContNoCell.getStringCellValue();
            }


            HSSFCell companySixthContPerCell=row.getCell(14);
            if(companySixthContPerCell==null)
            {
                data[i-1][14]="";

            }else
            {
                companySixthContPerCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][14]=companySixthContPerCell.getStringCellValue();
            }

            HSSFCell companySixthContNoCell=row.getCell(15);
            if(companySixthContNoCell==null)
            {
                data[i-1][15]="";

            }else
            {
                companySixthContNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][15]=companySixthContNoCell.getStringCellValue();
            }

        }



        return data;
    }
    /*@Test
    public void cancelCompanyTest()
    {
        Menu menu=new Menu(driver);
        menu.clickAddCompany();


        Add_Company addcompany = new Add_Company(driver);
        addcompany.setTxtCompName("TCT1");
        addcompany.setTextCompEmail("tctinfotech1@gmail.com");
        addcompany.setTxtCompAddress("Pune");
        addcompany.setTxtLandlineNo("1234567890");
        addcompany.setTxtPrimConPerson("Beena");
        addcompany.setTxtPrimConNo("5765576787");
        addcompany.setTxtSecConPerson("Priya");
        addcompany.setTxtSecConNo("2662424244");
        addcompany.setTxtTerConPerson("Sneha");
        addcompany.setTxtTerConNo("5568787898");
        addcompany.setTxtFourthConPerson("Praju");
        addcompany.setTxtFourthConNo("1234567899");
        addcompany.setTxtFifthConPerson("Ruhi");
        addcompany.setTxtFifthConNo("9876543210");
        addcompany.setTxtsixthConPerson("Neha");
        addcompany.setTxtsixthConNo("6767778987");

        addcompany.clickCancel();

        String strName=addcompany.getCompanyName();
        String strAddress=addcompany.getCompanyAddress();
        String strEmail=addcompany.getCompanyEmail();
        String strLandlineNo=addcompany.getCompanyLandlineNo();
        String strPrimConPer=addcompany.getPrimContactPer();
        String strSecConPer=addcompany.getSecContactPerson();
        String strThirdConPer=addcompany.getThirdContactPerson();
        String strFourthContPer=addcompany.getFourthContactPerson();
        String strFifthContPer=addcompany.getFifthContactPerson();
        String strSixthContPer=addcompany.getSixthContactPerson();
        String strPrimConNo=addcompany.getPrimContactNo1();
        String strSecConNo=addcompany.getSecContactNo();
        String strThirdConNo=addcompany.getThirdContactNo();
        String strFourthConNo=addcompany.getFourthContactNo();
        String strFifthConNo=addcompany.getFifthContactNo();
        String strSixthConNo=addcompany.getSixthContactNo();


        ArrayList<String>  listActual = new ArrayList<String>();
        listActual.add(strName);
        listActual.add(strAddress);
        listActual.add(strEmail);
        listActual.add(strLandlineNo);
        listActual.add(strPrimConPer);
        listActual.add(strSecConPer);
        listActual.add(strThirdConPer);
        listActual.add(strFifthContPer);
        listActual.add(strFourthContPer);
        listActual.add(strSixthContPer);
        listActual.add(strPrimConNo);
        listActual.add(strSecConNo);
        listActual.add(strThirdConNo);
        listActual.add(strFourthConNo);
        listActual.add(strFifthConNo);
        listActual.add(strSixthConNo);

        ArrayList<String>  listExpected = new ArrayList<String>();
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");
        listExpected.add("");

        Assert.assertEquals(listActual,listExpected,"Test Fail");


    }*/
   /* public void editCompanyTest()
    {
        Menu menu=new Menu(driver);
        menu.clickAddCompany();

        Add_Company addcompany=new Add_Company(driver);

        addcompany.clickEdit("TCT");

        addcompany.setTxtCompName("");
        addcompany.setTextCompEmail("");
        addcompany.setTxtCompAddress("");
        addcompany.setTxtLandlineNo("");
        addcompany.setTxtPrimConPerson("");
        addcompany.setTxtPrimConNo("");
        addcompany.setTxtSecConPerson("");
        addcompany.setTxtSecConNo("");
        addcompany.setTxtTerConPerson("");
        addcompany.setTxtTerConNo("");
        addcompany.setTxtFourthConPerson("");
        addcompany.setTxtFourthConNo("");
        addcompany.setTxtFifthConPerson("");
        addcompany.setTxtFifthConNo("");
        addcompany.setTxtsixthConPerson("");
        addcompany.setTxtsixthConNo("");

        addcompany.setTxtCompName("Wipro");
        addcompany.setTextCompEmail("wiprofotech1@gmail.com");
        addcompany.setTxtCompAddress("Mumbai");
        addcompany.setTxtLandlineNo("1122334455");
        addcompany.setTxtPrimConPerson("Beena");
        addcompany.setTxtPrimConNo("5765576787");
        addcompany.setTxtSecConPerson("Priya");
        addcompany.setTxtSecConNo("2662424244");
        addcompany.setTxtTerConPerson("Sneha");
        addcompany.setTxtTerConNo("5568787898");
        addcompany.setTxtFourthConPerson("Praju");
        addcompany.setTxtFourthConNo("1234567899");
        addcompany.setTxtFifthConPerson("Ruhi");
        addcompany.setTxtFifthConNo("9876543210");
        addcompany.setTxtsixthConPerson("Neha");
        addcompany.setTxtsixthConNo("6767778987");

        addcompany.clickSave();


    }*/
}
