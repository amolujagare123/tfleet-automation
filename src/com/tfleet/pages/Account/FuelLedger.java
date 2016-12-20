package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/16/2016.
 */
public class FuelLedger {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']//div[1]/section//div[1]/h2")
    WebElement FuelLedgerHeading ;

    @FindBy(xpath=".//*[@id='MainContent_txtFromDate']")
    WebElement selectFromDate;

    @FindBy(xpath=".//*[@id='MainContent_txtToDate']")
    WebElement selectToDate;

    @FindBy(xpath=".//*[@id='MainContent_ddlPump']")
    WebElement selectPump;

    @FindBy(xpath=".//*[@id='MainContent_txtFuelBillNo']")
    WebElement txtFuelBillNo;

    @FindBy(xpath=".//*[@id='MainContent_btnView']")
    WebElement btnView;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    @FindBy(xpath=".//*[@id='MainContent_btnExportToExcel']")
    WebElement btnExportToExcel;

    public FuelLedger(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!FuelLedgerHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Fuel Ledger page");
        }
    }
    public void setTxtFuelBillNo(String billNo)
    {
        txtFuelBillNo.sendKeys(billNo);
    }
    /*public void setSelectFromDate(String fromDate)
    {

    }*/
    /*public void setSelectToDate(String toDate)
    {

    }*/
    public void setSelectPump(String pumpName)
    {
        Select pumpNameCombo=new Select(selectPump);
        pumpNameCombo.selectByVisibleText(pumpName);
    }
    public void clickBtnExportToExcel()
    {
        btnExportToExcel.click();
    }
    public void clickbtnSave()
    {
        btnView.click();
    }
    public void clickbtnCacel()
    {
        btnCancel.click();
    }



}
