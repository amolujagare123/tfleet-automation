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

    @FindBy(xpath = "")
    WebElement maintenanceLedger;

    @FindBy(xpath = "")
    WebElement selectFromDate;

    @FindBy(xpath = "")
    WebElement selectToDate;

    @FindBy(xpath = "")
    WebElement selectGarage;

    @FindBy(xpath = "")
    WebElement txtMaintenanceBillNo;

    @FindBy(xpath = "")
    WebElement btnView;

    @FindBy(xpath = "")
    WebElement btnCancel;

    @FindBy(xpath = "")
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
