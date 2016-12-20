package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tct4 on 12/20/2016.
 */
public class ProfitAndLoss {

    WebDriver driver;

    @FindBy(xpath="")
    WebElement profitLossLedgerHeading;

    @FindBy(xpath="")
    WebElement selectFromDate;

    @FindBy(xpath="")
    WebElement selectToDate;

    @FindBy(xpath="")
    WebElement btnShow;

    @FindBy(xpath="")
    WebElement btnExportToExcel;

    public ProfitAndLoss(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!profitLossLedgerHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Profit and Loss Ledger page");
        }
    }
    /*public void setSelectFromDate()
    {
    }
     */
    /*public void setSelectToDate()
     {
     }
      */
    public void clickBtnShow()
    {
        btnShow.click();
    }
    public void clickBtnExportToExcel()
    {
        btnExportToExcel.click();
    }
}
