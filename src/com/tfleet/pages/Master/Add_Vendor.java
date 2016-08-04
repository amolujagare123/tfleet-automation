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

    public Add_Vendor(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!PgHead.isDisplayed())
        {
            throw new IllegalStateException("This is not Add Vendor page.");
        }

    }

}
