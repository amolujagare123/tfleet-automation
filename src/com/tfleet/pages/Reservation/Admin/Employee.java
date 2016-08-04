package com.tfleet.pages.Reservation.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 28/06/2016.
 */
public class Employee {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement MenuHeadingText;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/ul/li[1]/a")
    WebElement SubmenuText;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement HeadingText;

    @FindBy(xpath = ".//*[@id='MainContent_UpdatePanel2']/div[1]/div[2]/p")
    WebElement textEmp;

    @FindBy(xpath = ".//*[@id='MainContent_txtContactNo']")
    WebElement textContNo;

    @FindBy(xpath = ".//*[@id='MainContent_ddlDesignation']")
    WebElement selectDesignation;

    @FindBy(xpath = ".//*[@id='MainContent_ddlBranch']")
    WebElement selectBranch;

    @FindBy(xpath = ".//*[@id='MainContent_txtEmail']")
    WebElement textEmail;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    /*@FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btncancel;*/

    public Employee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!HeadingText.isDisplayed()) {
            throw new IllegalStateException("This is not Employee page");
        }
    }

    public void setTextEmp(String employee) {
        textEmp.sendKeys(employee);
    }

    public void setTextContNo(String contactNo) {
        textContNo.sendKeys(contactNo);
    }

    public void setTextEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void setSelectBranch(String setBranch)
    {
        Select branchCombo = new Select(selectBranch);
        branchCombo.selectByVisibleText(setBranch);
    }

    public void setSelectDesignation(String setDesignation)
    {
        Select designationCombo= new Select(selectDesignation);
        designationCombo.selectByVisibleText(setDesignation);
    }
}








