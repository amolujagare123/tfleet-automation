package com.tfleet.pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tct4 on 8/4/2016.
 */
public class Add_Vendor {
    WebDriver driver;

    @FindBy(xpath="")
    WebElement PgHead;

    @FindBy(xpath=".//*[@id='MainContent_txtVendor']")
    WebElement VendorName;

    @FindBy(xpath=".//*[@id='MainContent_txtAddress']")
    WebElement VendorAddress;

    @FindBy(xpath=".//*[@id='MainContent_txtEmail']")
    WebElement VendorEmail;

    @FindBy(xpath=".//*[@id='MainContent_txtLandlineNo']")
    WebElement LandlineNo;

    @FindBy(xpath=".//*[@id='MainContent_txtPrimContNo']")
    WebElement ContactNo;

    @FindBy(xpath=".//*[@id='MainContent_txtPrimContPerson']")
    WebElement ContactPerson;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;


    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;


    public Add_Vendor(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!PgHead.isDisplayed())
        {
            throw new IllegalStateException("This is not Add Vendor page.");
        }

    }
    public void setTxtVendorName(String cname)
    {
        VendorName.sendKeys(cname);
    }
    public void setTxtVendorAddress(String caddress)
    {
        VendorAddress.sendKeys(caddress);
    }
    public void setTextVendorEmail(String Vemail)
    {
        VendorEmail.sendKeys(Vemail);
    }
    public void setTxtLandlineNo(String lno)
    {
        LandlineNo.sendKeys(lno);
    }
    public void setTxtConPerson(String cp)
    {
        ContactPerson.sendKeys(cp);
    }
    public void setTxtConNo(String cn)
    {
        ContactNo.sendKeys(cn);
    }
    public void clickSave(){btnSave.click();}
    public void clickCancel(){btnCancel.click();}

}
