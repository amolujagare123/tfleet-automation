package com.tfleet.pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tct4 on 8/4/2016.
 */
public class Add_Garage {


    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']/div[3]/div[2]/div[1]//div[1]/h2")
    WebElement PgHead;

    @FindBy(xpath=".//*[@id='MainContent_txtGarage']")
    WebElement GarageName;

    @FindBy(xpath=".//*[@id='MainContent_txtAddress']")
    WebElement GarageAddress;

    @FindBy(xpath=".//*[@id='MainContent_txtEmail']")
    WebElement Email;

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

    public Add_Garage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!PgHead.isDisplayed())
        {
            throw new IllegalStateException("This is not Add Garage page");
        }

    }
    public void setTxtGarageName(String gname)
    {
        GarageName.sendKeys(gname);
    }
    public void setTxtPumpAddress(String gaddress)
    {
        GarageAddress.sendKeys(gaddress);
    }
    public void setTextEmail(String email)
    {
        Email.sendKeys(email);
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
