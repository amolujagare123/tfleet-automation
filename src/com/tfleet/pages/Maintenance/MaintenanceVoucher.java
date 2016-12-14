package com.tfleet.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 14/12/2016.
 */
public class MaintenanceVoucher {

    WebDriver driver;

    @FindBy(xpath = "")
    WebElement maintenanceVoucher;        //maintenance voucher heading

    @FindBy(xpath = "")
    WebElement selectGarage;

    @FindBy(xpath = "")
    WebElement receiptNo;

    @FindBy(xpath = "")
    WebElement txtPnrNo;

    @FindBy(xpath = "")
    WebElement selectGarageName;

    @FindBy(xpath = "")
    WebElement selectVoucherType;

    @FindBy(xpath = "")
    WebElement date;

    @FindBy(xpath = "")
    WebElement selectModeofPayment;

    @FindBy(xpath = "")
    WebElement txtPaymentDetails;

    @FindBy(xpath = "")
    WebElement totalAmount;

    @FindBy(xpath = "")
    WebElement btnSave;

    @FindBy(xpath = "")
    WebElement btnCancel;


        public MaintenanceVoucher (WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
            if (! maintenanceVoucher.isDisplayed()){
                throw new IllegalStateException("This is not Maintenance Voucher Page");
            }
        }


            public void setSelectGarageName(String garageName)
            {
                Select garageNamecombo =new Select(selectGarageName);
                garageNamecombo.selectByVisibleText(garageName);
            }

}
