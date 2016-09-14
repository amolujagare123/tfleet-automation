package regression.Master;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import static  com.tfleet.pages.Menu.*;
import static com.tfleet.utilities.TakeScreenshot.takeScreenshot;

import com.tfleet.pages.Master.Add_Company;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import com.tfleet.utilities.initExtentReport;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
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
        DashBoard dashBoard = loginPage.Login("akshay85pokley@gmail.com", "123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test
    public void addCompanyTest() throws IOException { ExtentTest test = extent.startTest("Test Add company | save record", "To test the save button functionality");

        try {
           Menu menu = new Menu(driver);
           test.log(LogStatus.INFO, "Menu Driver initialised");
           menu.clickAddCompany();
           test.log(LogStatus.INFO, "Add company page opened");

           Add_Company addcompany = new Add_Company(driver);
           test.log(LogStatus.INFO, "Add company page object creayed");
           addcompany.setTxtCompName("TCS");
           test.log(LogStatus.INFO, "comapany name set ");
           addcompany.setTextCompEmail("tcsinfotech@gmail.com");
           addcompany.setTxtCompAddress("Pune");
           addcompany.setTxtLandlineNo("1234867890");
           addcompany.setTxtPrimConPerson("Lina");
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
            test.log(LogStatus.INFO, "save button clicked");

           String expected = "Company Added Successfully";

           Alert alert = driver.switchTo().alert();



           String Actual = alert.getText();

            alert.accept();
           test.log(LogStatus.INFO, "alert displayed as " + Actual);

          try{
              Assert.assertEquals(Actual, expected, "Test fail");
              test.log(LogStatus.PASS, "Company Added successfully");
          }
          catch (AssertionError e)
          {
              test.log(LogStatus.ERROR, "Add company page object creayed");
              test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

          }
           // driver.manage()
       }
       catch(Throwable e)
       {
           test.log(LogStatus.ERROR,"There is exception"+e);
           test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
       }
        extent.endTest(test);
        extent.flush();
    }
    @Test
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


    }
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
