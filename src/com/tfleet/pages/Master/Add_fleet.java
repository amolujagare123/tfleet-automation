package com.tfleet.pages.Master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by tct4 on 8/4/2016.
 */
public class Add_fleet {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']/div[3]/div[2]/div[1]//div[1]/h2")
    WebElement PgHead;

    @FindBy(xpath=".//*[@id='MainContent_txtFleetNo']")
    WebElement fleetNumber;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetCategory']")
    WebElement fleetCategory;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetType']")
    WebElement fleetType;

    @FindBy(xpath="//*[@id='MainContent_rdbF_OwnedType']/tbody//td[1]/label")
    WebElement ownTypeFleet;

    @FindBy(xpath="//*[@id='MainContent_rdbF_OwnedType']/tbody//td[2]/label")
    WebElement vendorTypeFleet;

    @FindBy(xpath=".//*[@id='MainContent_ddlVendor']")
    WebElement selectVendorName;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    @FindBy(xpath=".//*[@id='MainContent_txtPUC_date']")
    WebElement pucDate;

    @FindBy(xpath=".//*[@id='MainContent_txtInsu_Date']")
    WebElement insuranceDate;

    @FindBy(xpath=".//*[@id='MainContent_txtPermitDate']")
    WebElement permitDate;

    @FindBy(xpath=".//*[@id='MainContent_txtFit_Date']")
    WebElement fitnessDate;

    @FindBy(xpath=".//*[@id='MainContent_txtTax_Date']")
    WebElement taxDate;

    @FindBy(xpath=".//*[@id='MainContent_txtPuc_Exp_Period']")
    WebElement pucExpDate;

    @FindBy(xpath=".//*[@id='MainContent_txtIns_Exp_Period']")
    WebElement insuranceExpDate;

    @FindBy(xpath=".//*[@id='MainContent_txtPer_Exp_Period']")
    WebElement permitExpDate;

    @FindBy(xpath=".//*[@id='MainContent_txtFit_Exp_Period']")
    WebElement fitnessExpDate;

    @FindBy(xpath=".//*[@id='MainContent_txtTax_Exp_Period']")
    WebElement taxExpDate;


    public Add_fleet(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!PgHead.isDisplayed()) {
            throw new IllegalStateException("This is not Add/Edit Fleet page.");
        }
    }
    public void ClickBtnSave() {
        btnSave.click();
    }
    public void ClickBtnCancel()
    {
        btnCancel.click();
    }
    public void selectFleetCategory(String fCategory)
    {
        Select fCategoryCombo=new Select(fleetCategory);
        fCategoryCombo.selectByVisibleText(fCategory);
    }
    public void selectFleetType(String fType)
    {
        Select fTypeCombo=new Select(fleetType);
        fTypeCombo.selectByValue(fType);
    }
    public void setSelectVendorName(String vendorName)
    {
        Select vendorNameCombo=new Select(selectVendorName);
        vendorNameCombo.selectByVisibleText(vendorName);
    }
    public void setFleetNumber(String fltNumber)
    {
        fleetNumber.sendKeys(fltNumber);

    }
    public void setOwnTypeFleet()
    {
        ownTypeFleet.click();

    }
    public void setVendorTypeFleet()
    {
        vendorTypeFleet.click();
    }
}
