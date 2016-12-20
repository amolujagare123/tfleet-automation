package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/16/2016.
 */
public class Allowance {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']//div/section//div[1]/h2")
    WebElement AllowanceHeading;

    @FindBy(xpath=".//*[@id='MainContent_txtFDate']")
    WebElement selectDate;

    @FindBy(xpath=".//*[@id='MainContent_ddlAllowanceType']")
    WebElement selectAllowanceType ;

    @FindBy(xpath=".//*[@id='MainContent_ddlEmployeeNm']")
    WebElement selectEmployee ;

    @FindBy(xpath=".//*[@id='MainContent_txtDescription']")
    WebElement txtDescription ;

    @FindBy(xpath=".//*[@id='MainContent_txtDescription']")
    WebElement txtAmount ;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;



    public Allowance(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!AllowanceHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Allowance page");
        }
    }
    public void setTxtDescription(String description)
    {
        txtDescription.sendKeys(description);
    }
    public void setTxtAmount(String amount)
    {
        txtAmount.sendKeys(amount);
    }
    /*public void setSelectDate(String date)
    {

    }*/
    public void setSelectEmployee(String employeeName)
    {
        Select employeeNameCombo=new Select(selectEmployee);
        employeeNameCombo.selectByVisibleText(employeeName);
    }
    public void setSelectAllowanceType(String allowanceType)
    {
        Select allowanceTypeCombo=new Select(selectAllowanceType);
        allowanceTypeCombo.selectByVisibleText(allowanceType);
    }
    public void clickBtnSave()
    {
        btnSave.click();
    }
    public void clickCancel()
    {
        btnCancel.click();
    }
}
