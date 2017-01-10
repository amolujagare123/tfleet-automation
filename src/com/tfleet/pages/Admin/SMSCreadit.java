package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 08/08/2016.
 */
public class SMSCreadit {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement AdminLnk;

    @FindBy(xpath = ".//*[@id='A56']")
    WebElement SMSCreaditLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement SMSCreaditHeading;

    @FindBy(xpath = ".//*[@id='MainContent_txtComp_Nm']")
    WebElement CompanyName;

    @FindBy(xpath = ".//*[@id='MainContent_ddlNo_Of_SMS']")
    WebElement NoOfSMS;

    @FindBy(xpath = ".//*[@id='MainContent_txtSMS_Amt']")
    WebElement Amount;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement SaveBtn;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement CancelBtn;

    public SMSCreadit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        if(!SMSCreaditHeading.isDisplayed()){
            throw new IllegalStateException("This is not SMS creadit Page");
        }
    }

    public void setAdminLnk(String adminLnk)
    {
        AdminLnk.sendKeys(adminLnk);
    }

    public void setSMSCreaditLnk(String smsCreaditLnk)
    {
        SMSCreaditHeading.sendKeys(smsCreaditLnk);
    }

    public void setSMSCreaditHeading(String smsCreaditHeading)
    {
        SMSCreaditHeading.sendKeys(smsCreaditHeading);
    }

    public void setCompanyName(String companyName)
    {
        CompanyName.sendKeys(companyName);
    }

    public void setNoOfSMS (String setNoOfSMS)
    {
        Select noofSMSCombo = new Select(NoOfSMS);
        noofSMSCombo.selectByVisibleText(setNoOfSMS);
    }

    public void setAmount(String amount)
    {
        Amount.sendKeys(amount);
    }
    public void clickSave()
    {
        SaveBtn.click();
    }

}
