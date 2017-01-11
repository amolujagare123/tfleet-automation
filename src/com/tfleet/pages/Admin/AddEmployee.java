package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Sai Ram on 09/08/2016.
 */
public class AddEmployee {


    WebDriver driver;

   /* @FindBy(xpath = "./*//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement Admin;

    @FindBy(xpath = "./*//*[@id='your-object']/div[2]/ul/li[1]/ul/li[1]/a")
    WebElement AddEmployee;*/

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement AddEmployee;

    @FindBy(xpath = "//input[@id='MainContent_txtEmployeeName']")
    WebElement EmpName;

    @FindBy(xpath = "//select[@id='MainContent_ddlDesignation']")
    WebElement Designation;

    @FindBy(xpath = "//input[@id='MainContent_txtContactNo']")
    WebElement ContactNo;

    @FindBy(xpath = "//input[@id='MainContent_txtEmail']")
    WebElement Email;

    @FindBy(xpath = "//select[@id='MainContent_ddlBranch']")
    WebElement Branch;

    @FindBy(xpath = "//input[@id='MainContent_btnSave']")
    WebElement Savebtn;

    /*@FindBy(xpath = "//input[@id='MainContent_btnCancel']")
    WebElement Cancelbtn;*/

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!AddEmployee.isDisplayed()) {
            throw new IllegalStateException("This is not Employee Page ");
        }
    }
/*
    public void setAdminLnk(String adminLnk)
    {
        Admin.sendKeys(adminLnk);
    }
    public void setAddEmployeeLnk(String addEmployeeLnk)
    {
        AddEmployee.sendKeys(addEmployeeLnk);
    }
    public void setAEHeadingText(String aeHeading) {
        AEHeadingText.sendKeys(aeHeading);
    }
*/

    public void setEmpNameText(String empName) {
        EmpName.sendKeys(empName);
    }

    public void setContactNoText(String contactNo) {
        ContactNo.sendKeys(contactNo);
    }

    public void setEmailText(String email) {
        Email.sendKeys(email);
    }

    public void setSelectDesignation(String setDesignation)
    {
        Select designationCombo = new Select(Designation);
        designationCombo.selectByValue(setDesignation);
    }

    public void setSelectBranch(String setBranch)
    {
        Select branchCombo = new Select(Branch);
        branchCombo.selectByValue(setBranch);
    }

    public void clickSave()
    {
        Savebtn.click();

    }
}
   /* public void clickCancel()
    {
        Cancelbtn.click();
    }*/


    /*public String getEmName()
    {
        return EmpName.getAttribute("Value");
    }
    public String getContactNo()
    {
        return ContactNo.getAttribute("Value");
    }
    public String getEmail()
    {
        return Email.getAttribute("Value");
    }
    public String getSelectDesignation()
    {
        return Designation.getText();
    }
    public String getSelectBranch()
    {
        return Branch.getText();
    }

    }*/
