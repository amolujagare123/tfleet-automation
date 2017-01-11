package com.tfleet.pages.Reservation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Reservation{

    WebDriver driver;


    @FindBy(xpath=".//*[@id='Form1']//div[1]/section/div//div[2]/h2")
    WebElement ReservationHeading;

    @FindBy(xpath=".//*[@id='MainContent_txtPNRNo']")
    WebElement txtPNRNo;

    @FindBy(xpath=".//*[@id='MainContent_txtResDate']")
    WebElement selectDate;

    @FindBy(xpath=".//*[@id='MainContent_ddlCompany']")
    WebElement selectCompanyName;

    @FindBy(xpath=".//*[@id='MainContent_txtRep_Address']")
    WebElement txtReportingAddress;

    @FindBy(xpath=".//*[@id='MainContent_ddlRentalCity']")
    WebElement selectRentalCity;

    @FindBy(xpath=".//*[@id='MainContent_txtNameOfGuest']")
    WebElement txtNameOfGuest;

    @FindBy(xpath=".//*[@id='MainContent_txtBookedBy']")
    WebElement txtBookedBy;

    @FindBy(xpath=".//*[@id='MainContent_txtMobileNo']")
    WebElement txtMobileNo;

    @FindBy(xpath=".//*[@id='MainContent_txtEmail']")
    WebElement txtEmail;

    @FindBy(xpath=".//*[@id='MainContent_txtOthrMobNo']")
    WebElement txtOnotherMobNoForSMS;

    @FindBy(xpath=".//*[@id='MainContent_ChkSMS']")
    WebElement txtOnotherMobNoCheckSMS;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetCategory']")
    WebElement selectFleetCategory;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetType']")
    WebElement selectFleetType;

    @FindBy(xpath=".//*[@id='MainContent_txtDateOfrequirement']")
    WebElement selectRequirementDate;

    @FindBy(xpath=".//*[@id='MainContent_ddlPackage']")
    WebElement selectPackage;

    @FindBy(xpath=".//*[@id='MainContent_ddlHr']")
    WebElement selectReportingTimeHrs;

    @FindBy(xpath=".//*[@id='MainContent_ddlmin']")
    WebElement selectReportingTimeMin;

    @FindBy(xpath=".//*[@id='MainContent_txtpackageamt']")
    WebElement txtEstimateAmount;

    @FindBy(xpath=".//*[@id='MainContent_ddlBillingMode']")
    WebElement selectBillingMode;

    @FindBy(xpath=".//*[@id='MainContent_txtSpecialInstr']")
    WebElement txtSpecialInstuction;

    @FindBy(xpath=".//*[@id='MainContent_txtExpDate']")
    WebElement selectExpiryDate;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public Reservation(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!ReservationHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Reservation page");
        }
    }

    public void setTxtReportingAddress(String reportingAddress)
    {
        txtReportingAddress.sendKeys(reportingAddress);
    }
    public void setTxtBookedBy(String bookedBy)
    {
        txtBookedBy.sendKeys((bookedBy));
    }
    public void setTxtNameOfGuest(String nameOfGuest)
    {
        txtNameOfGuest.sendKeys(nameOfGuest);
    }
    public void setTxtMobileNo(String mobileNo)
    {
        txtMobileNo.sendKeys(mobileNo);
    }
    public void setTxtEmail(String mail)
    {
        txtEmail.sendKeys(mail);
    }
    public void setTxtOnotherMobNoForSMS(String mobNo)
    {
        txtOnotherMobNoForSMS.sendKeys(mobNo);
    }
    public void setTxtEstimateAmount(String amount)
    {
        txtEstimateAmount.sendKeys(amount);
    }
    public void setTxtSpecialInstuction(String instuction)
    {
        txtSpecialInstuction.sendKeys(instuction);
    }

    public void setSelectBillingMode(String billingMode) {
        Select billingModeCombo=new Select(selectBillingMode);
        billingModeCombo.selectByVisibleText(billingMode);
    }
    /*public void setSelectDate(String date)
    {

    }*/
    public void setSelectRentalCity(String rentalCity)
    {
        Select rentalCityCombo=new Select(selectRentalCity) ;
        rentalCityCombo.selectByVisibleText(rentalCity);
    }
    public void setSelectCompanyName(String companyName)
    {
        Select companyNameCombo=new Select(selectCompanyName);
        companyNameCombo.selectByVisibleText(companyName);
    }
    public void setSelectFleetCategory(String fleetCategory)
    {
        Select fleetCategoryCombo=new Select(selectFleetCategory);
        fleetCategoryCombo.selectByVisibleText(fleetCategory);
    }
    public void setSelectFleetType(String fleetType)
    {
        Select fleetTypeCombo=new Select(selectFleetType);
                fleetTypeCombo.selectByVisibleText(fleetType);
    }
    /*public void setSelectRequirementDate(String requirementDate)
    {

    }*/
    /*public void setSelectExpiryDate(String expiryDate)
    {

    }*/
    public void setSelectPackage(String pakage)
    {
        Select pakageCombo=new Select(selectPackage);
        pakageCombo.selectByVisibleText(pakage);
    }
    public void setSelectReportingTimeHrs(String Hrs)
    {
        Select hrsCombo=new Select(selectReportingTimeHrs);
        hrsCombo.selectByVisibleText(Hrs);
    }
    public void setSelectReportingTimeMin(String min)
    {
        Select minCombo=new Select(selectReportingTimeMin);
        minCombo.selectByVisibleText(min);
    }
    public void clickOnotherMobNoForSMS()
    {
        txtOnotherMobNoCheckSMS.click();
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
