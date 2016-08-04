package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 03/08/2016.
 */
public class Employee {
    WebDriver Driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement Admin;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/ul/li[1]/a")
    WebElement AddEmployee;

    @FindBy(xpath = "//div[@class='left_grid']/h2")
    WebElement AEHeadingText;

    @FindBy(xpath = "//input[@id='MainContent_txtEmployeeName']")
    WebElement EmpName;

    @FindBy(xpath = "//input[@id='MainContent_ddlDesignation']")
    WebElement Designation;

    @FindBy(xpath = "//input[@id='MainContent_txtContactNo']")
    WebElement ContactNo;

    @FindBy(xpath = "//input[@id='MainContent_txtEmail']")
    WebElement Email;

    @FindBy(xpath = "//input[@id='MainContent_ddlBranch']")
    WebElement Branch;

    @FindBy(xpath = "//input[@id='MainContent_btnSave']")
    WebElement Savebtn;

   /* @FindBy(xpath = "//input[@id='MainContent_btnCancel']")
    WebElement Cancelbtn;*/

    public Employee(WebDriver driver){
        this.Driver=driver;
        PageFactory.initElements(driver,this);
        if(!AEHeadingText.isDisplayed())
        {
            throw new IllegalStateException("This is not Add employee page");
        }
    }

        public void setAEHeadingText(String aeHeading)

        {
            AEHeadingText.sendKeys(aeHeading);
        }

        public void setEmpNameText(String empName)
        {
            EmpName.sendKeys(empName);
        }

        public void setContactNoText(String contactNo)
        {
            ContactNo.sendKeys(contactNo);
        }

        public void setEmailText(String email)
        {
            Email.sendKeys(email);
        }

         public void clickSave()
         {
             Savebtn.click();
         }


        public void setSelectDesignation(String setDesignation)
            {
                Select designationCombo = new Select(Designation);
                designationCombo.selectByVisibleText(setDesignation);
            }
        public void setSelectBranch(String setBranch)
        {
            Select branchCombo = new Select(Branch);
            branchCombo.selectByVisibleText(setBranch);
        }

    }
