package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/16/2016.
 */
public class FuelConsumption {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Form1']//div[1]/section//div[1]/h2")
    WebElement fuelConsumptionHeading;

    @FindBy(xpath = ".//*[@id='MainContent_txtDate']")
    WebElement selectDate;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetNo']")
    WebElement selectFleetNo;

    @FindBy(xpath = ".//*[@id='MainContent_txtLocation']")
    WebElement txtLocation;

    @FindBy(xpath = ".//*[@id='MainContent_txtMeterReading']")
    WebElement txtMeterReading;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotalLtrs']")
    WebElement txtTotalLiter;

    @FindBy(xpath = ".//*[@id='MainContent_txtLtrCost']")
    WebElement txtCostPerLiter;

    @FindBy(xpath = ".//*[@id='MainContent_txtChaufNm']")
    WebElement txtChaufferName;

    @FindBy(xpath = ".//*[@id='MainContent_ddlEmployee']")
    WebElement selectApprovalManager;

    @FindBy(xpath = ".//*[@id='MainContent_txtPNR_No']")
    WebElement txtPNRNo;

    @FindBy(xpath = ".//*[@id='MainContent_ddlPump']")
    WebElement selectPump;

    @FindBy(xpath = ".//*[@id='MainContent_txtDes']")
    WebElement txtDescription;

    @FindBy(xpath = ".//*[@id='MainContent_chkPaid']")
    WebElement selectPaid;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public FuelConsumption(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!fuelConsumptionHeading.isDisplayed()) {
            throw new IllegalStateException("This is not a Fuel Consumption page");
        }
    }

    public void setTxtLocation(String location) {
        txtLocation.sendKeys(location);
    }

    public void setTxtMeterReading(String reading) {
        txtMeterReading.sendKeys(reading);
    }

    public void setTxtTotalLiter(String totalLiter) {
        txtTotalLiter.sendKeys(totalLiter);
    }

    public void setTxtCostPerLiter(String costPerLiter) {
        txtCostPerLiter.sendKeys(costPerLiter);
    }

    public void setTxtChaufferName(String chaufferName) {
        txtChaufferName.sendKeys();
    }

    public void setTxtDescription(String description) {
        txtDescription.sendKeys(description);
    }

    public void setTxtPNRNo(String pnr) {
        txtPNRNo.sendKeys(pnr);
    }

    /*public void setSelectDate()
    {

    }*/
    public void setSelectFleetNo(String fleetNo)
    {
        Select fleetNoCombo=new Select(selectFleetNo);
        fleetNoCombo.selectByVisibleText(fleetNo);
    }
    public void setSelectPump(String pumpName)
    {
        Select pumpNameCombo=new Select(selectPump);
        pumpNameCombo.selectByVisibleText(pumpName);
    }
    public void clickSelectPaid()
    {
        selectPaid.click();
    }
    public void setSelectApprovalManager(String approvalManager)
    {
        Select approvalManagerCombo=new Select(selectApprovalManager);
        approvalManagerCombo.selectByVisibleText(approvalManager);
    }

    public void clickbtnSave() {
        btnSave.click();
    }
    public void clickbtnCancel()
    {
        btnCancel.click();
    }
}
