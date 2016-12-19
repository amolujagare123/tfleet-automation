package com.tfleet.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 16/12/2016.
 */
public class MaintenanceLedger {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement maintenanceLedger;       //Maintenance Ledger Heading

    @FindBy(xpath = ".//*[@id='MainContent_txtFromDate']")
    WebElement selectFromDate;

    @FindBy(xpath = ".//*[@id='MainContent_txtToDate']")
    WebElement selectToDate;

    @FindBy(xpath = ".//*[@id='MainContent_ddlGarage']")
    WebElement selectGarage;

    @FindBy(xpath = ".//*[@id='MainContent_txtBillNo']")
    WebElement txtMaintenanceBillNo;

    @FindBy(xpath = ".//*[@id='MainContent_btnView']")
    WebElement btnView;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    @FindBy(xpath = ".//*[@id='MainContent_btnExportToExcel']")
    WebElement btnExportToExcel;

    public MaintenanceLedger(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!maintenanceLedger.isDisplayed()) {
            throw new IllegalStateException("This is not Maintenance Ledger Page");
        }
    }


   /* public void setSelectFromDate(String fromDate)
    {

    }
    public void setSelectToDate(String toDate)
    {

    }*/

    public void setSelectGarage(String garage)
    {
        Select garagecombo= new Select(selectGarage);
        garagecombo.selectByVisibleText(garage);
    }
    public void setTxtMaintenanceBillNo(String maintenanceBillNo)
    {
        txtMaintenanceBillNo.sendKeys(maintenanceBillNo);
    }
    public void ClickView()
    {
        btnView.click();
    }
    public void ClickCancel()
    {
        btnCancel.click();
    }
    public void ClickExportToExcel()
    {
        btnExportToExcel.click();
    }


}
