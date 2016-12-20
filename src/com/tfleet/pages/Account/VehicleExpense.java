package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 12/20/2016.
 */
public class VehicleExpense {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']//div[1]/section//div[1]/div/h2")
    WebElement vehicleExpenseHeading;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetNo']")
    WebElement selectFleetNo;

    @FindBy(xpath=".//*[@id='MainContent_txtFromDate']")
    WebElement selectFromDate;

    @FindBy(xpath=".//*[@id='MainContent_txtTodate']")
    WebElement selectToDate;

    @FindBy(xpath=".//*[@id='MainContent_txtPNRNo']")
    WebElement txtPNRNo;

    @FindBy(xpath=".//*[@id='MainContent_btnShow']")
    WebElement btnShow;

    @FindBy(xpath=".//*[@id='MainContent_btnCancelShow']")
    WebElement btnCancel;

    public VehicleExpense(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!vehicleExpenseHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Vehicle expense page");
        }
    }
    public void setTxtPNRNo(String pnrNo)
    {
        txtPNRNo.sendKeys(pnrNo);
    }
    public void setSelectFleetNo(String fleetNo)
    {
        Select fleetNoCombo=new Select(selectFleetNo);
        fleetNoCombo.selectByVisibleText(fleetNo);
    }
    /*public void setSelectFromDate()
    {

    }
    public void setSelectToDate()
    {

    }*/
    public void clickbtnShow()
    {
        btnShow.click();
    }
    public void  clickbtnCancel()
    {
        btnCancel.click();
    }

}
