package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/16/2016.
 */
public class FuelPayment {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Form1']//div[1]/section/div//div[1]/h2")
    WebElement fuelPaymentHeading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlPumpfilter']")
    WebElement selectPetrolPump;

    @FindBy(xpath = ".//*[@id='MainContent_txtPNRNo']")
    WebElement txtPNRNo;

    @FindBy(xpath = ".//*[@id='MainContent_ddlvoucherType']")
    WebElement selectVoucherType;

    @FindBy(xpath = ".//*[@id='MainContent_txtDate']")
    WebElement selectDate;

    @FindBy(xpath = ".//*[@id='MainContent_ddlPayMode']")
    WebElement selectPaymentMode;

    @FindBy(xpath = ".//*[@id='MainContent_txtCheckDate']")
    WebElement selectDDDate;

    @FindBy(xpath = ".//*[@id='MainContent_txtCheckNo']")
    WebElement selectDDNo;

    @FindBy(xpath = ".//*[@id='MainContent_txtCashDetails']")
    WebElement txtPaymentDetails;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotalAmount']")
    WebElement txtTotalAmount;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public FuelPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!fuelPaymentHeading.isDisplayed()) {
            throw new IllegalStateException("This is not a Fuel Payment page");
        }

    }

    public void setTxtPNRNo(String pnr)
    {
        txtPNRNo.sendKeys(pnr);
    }

    public void setTxtTotalAmount(String amount)
    {
        txtTotalAmount.sendKeys(amount);
    }
    public void setTxtPaymentDetails(String paymentDetails)
    {
        txtPaymentDetails.sendKeys(paymentDetails);
    }
    public void setSelectPetrolPump(String petrolPumpName)
    {
        Select petrolPumpCombo=new Select(selectPetrolPump);
        petrolPumpCombo.selectByVisibleText(petrolPumpName);
    }
    /*public void setSelectDate(String date)
    {

    }*/
    public void setSelectPaymentMode(String paymentMode)
    {
        Select paymentModeCombo=new Select(selectPaymentMode);
        paymentModeCombo.selectByVisibleText(paymentMode);
    }
    public void setSelectVoucherType(String voucherType)
    {
        Select voucherTypeCombo=new Select(selectVoucherType);
        voucherTypeCombo.selectByVisibleText(voucherType);
    }
    public void setSelectDDDate(String DDDate)
    {
        Select DDdateCombo=new Select(selectDDDate);
        DDdateCombo.selectByVisibleText(DDDate);
    }
    public void setSelectDDNo(String DDNo)
    {

        Select DDNoCombo = new Select(selectDDNo);
        DDNoCombo.selectByVisibleText(DDNo);
    }
    public void clickbtnSave()
    {
        btnSave.click();
    }
    public void clickbtnCancel()
    {
        btnCancel.click();
    }

}
