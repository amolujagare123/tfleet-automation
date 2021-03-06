package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/14/2016.
 */
public class Expense {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']//div[1]/section/div//div[1]/h2")
    WebElement expenseHeading;

    @FindBy(xpath=".//*[@id='MainContent_txtPNRNo']")
    WebElement txtPNRNo;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetNo']")
    WebElement selectFleetNo;

    @FindBy(xpath=".//*[@id='MainContent_ddlExpenseType']")
    WebElement selectExpenditureType;

    @FindBy(xpath=".//*[@id='MainContent_ddlEmployeeNm']")
    WebElement selectEmployee;

    @FindBy(xpath=".//*[@id='MainContent_txtPaidToParty']")
    WebElement txtpaidToParty;

    @FindBy(xpath=".//*[@id='MainContent_txtDescription']")
    WebElement txtDescription;

    @FindBy(xpath=".//*[@id='MainContent_ddlPayMode']")
    WebElement selectPaymentMode;

    @FindBy(xpath=".//*[@id='MainContent_txtChequeNo']")
    WebElement txtChqOrDDNO;

    @FindBy(xpath=".//*[@id='MainContent_txtAmount']")
    WebElement txtAmount;

    @FindBy(xpath=".//*[@id='MainContent_txtAdditionalInfo']")
    WebElement txtAdditionalInformation;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public Expense(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!expenseHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Expense page");
        }
    }
    public void setTxtPNRNo(String PNR)
    {
        txtPNRNo.sendKeys(PNR);
    }

    public void setTxtpaidToParty(String partyName)
    {
        txtpaidToParty.sendKeys(partyName);
    }
    public void setTxtDescription(String description){txtDescription.sendKeys(description);}
    public void setTxtAmount(String amount){txtAmount.sendKeys(amount);}
    public void setTxtAdditionalInformation(String information){txtAdditionalInformation.sendKeys(information);}
   public void setTxtChequeOrDDNo(String chqNo){txtChqOrDDNO.sendKeys(chqNo);}
    public void setSelectFleetNo(String fleetNo)
    {
        Select fleetNoCombo=new Select(selectFleetNo);
        fleetNoCombo.selectByVisibleText(fleetNo);
    }
    public void setSelectExpenditureType(String expenditureType)
    {
        Select expenditureTypeCombo=new Select(selectExpenditureType);
        expenditureTypeCombo.selectByVisibleText(expenditureType);
    }
    public void setSelectEmployee(String employeeName)
    {
        Select employeeNameCombo=new Select(selectEmployee);
        employeeNameCombo.selectByVisibleText(employeeName);
    }
    public void setSelectPaymentMode(String paymentMode)
    {
        Select paymentModeCombo=new Select(selectPaymentMode);
        paymentModeCombo.selectByVisibleText(paymentMode);
    }
    public void clickSave()
    {
        btnSave.click();
    }
    public void clickCancel()
    {
        btnCancel.click();
    }
}
