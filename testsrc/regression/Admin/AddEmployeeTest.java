package regression.Admin;

import com.tfleet.pages.Admin.AddEmployee;
import com.tfleet.pages.DashBoard;
import regression.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sai Ram on 29/07/2016.
 */


public class AddEmployeeTest
{
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    @BeforeClass

    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage =new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DashBoard dashBoard = loginPage.Login("akshay85pokley@gmail.com","tcraft123");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Test
    public void employeeTestsave()
    {
        Menu menu = new Menu(driver);
        menu.clickAddEmployee();

        AddEmployee addemployee= new AddEmployee(driver);
        addemployee.setEmpNameText("Om");
        addemployee.setContactNoText("7894561230");
        addemployee.setEmailText("om@gmail.com");
        addemployee.setSelectBranch("PUNE");
        addemployee.setSelectDesignation("MANAGER");
        addemployee.clickSave();

        String expected ="Employee Added Successfully";

        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();

        Assert.assertEquals(actual,expected,"Test Fail");
    }
    @Test
    public void emloyeeTestcancel()
    {
        Menu menu = new Menu(driver);
        menu.clickAddEmployee();

        AddEmployee addemployee= new AddEmployee(driver);
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
    }


}
