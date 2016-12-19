package com.tfleet.pages.QuickInvoice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 16/12/2016.
 */
public class QuickInvoice {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div/h2")
    WebElement quickInvoice;             //Quick invoice heading

    @FindBy(xpath = ".//*[@id='MainContent_ddlInvoiceTemplate']")
    WebElement selectPreviousInvoice;

    @FindBy(xpath = ".//*[@id='MainContent_txtBookingNo']")
    WebElement bookingNo;

    @FindBy(xpath = ".//*[@id='MainContent_txtInvoiceDate']")
    WebElement selectInvoiceDate;

    @FindBy(xpath = ".//*[@id='MainContent_ddlCompany']")
    WebElement selectCompany;

    @FindBy(xpath = ".//*[@id='MainContent_txtRep_Address']")
    WebElement txtReportingAddress;

    @FindBy(xpath = ".//*[@id='MainContent_ddlRentalCity']")
    WebElement selectRentalCity;

    @FindBy(xpath = ".//*[@id='MainContent_txtNameOfGuest']")
    WebElement txtNameOfGuest;

    @FindBy(xpath = ".//*[@id='MainContent_lblUserName']")
    WebElement txtBookedBy;

    @FindBy(xpath = ".//*[@id='MainContent_lblUserName']")
    WebElement txtMobileno;

    @FindBy(xpath = ".//*[@id='MainContent_txtEmail']")
    WebElement txtEmail;

    @FindBy(xpath = ".//*[@id='MainContent_rdbF_OwnedType']/tbody/tr/td[1]/label")
    WebElement radioOwnedFleet;

    @FindBy(xpath = ".//*[@id='MainContent_rdbF_OwnedType']/tbody/tr/td[2]/label")
    WebElement radioVendorFleet;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetCategory']")
    WebElement selectFleetCategory;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetType']")
    WebElement selectFleetType;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetNo']")
    WebElement selectFleetNo;

    @FindBy(xpath = ".//*[@id='MainContent_ddlEmployee']")
    WebElement selectChauffeurName;

    @FindBy(xpath = ".//*[@id='MainContent_txtDateOut']")
    WebElement selectDateOut;

    @FindBy(xpath = ".//*[@id='MainContent_txtDateOut']")
    WebElement selectDateIn;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotalDays']")
    WebElement totalDays;

    @FindBy(xpath = ".//*[@id='MainContent_ddlHrOut']")
    WebElement selectTimeOutHr;

    @FindBy(xpath = ".//*[@id='MainContent_ddlminOut']                    ")
    WebElement selectTimeOutMin;

    @FindBy(xpath = ".//*[@id='MainContent_ddlHrIn']")
    WebElement selectTimeInHr;

    @FindBy(xpath = ".//*[@id='MainContent_ddlMinIn']")
    WebElement selectTimeInMin;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotalHrs']")
    WebElement totalHrs;

    @FindBy(xpath = ".//*[@id='MainContent_txtKmOut']")
    WebElement txtKmOut;

    @FindBy(xpath = ".//*[@id='MainContent_txtKmIn']")
    WebElement txtKmIn;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotKm']")
    WebElement totalKm;

    @FindBy(xpath = ".//*[@id='MainContent_ddlPackage']")
    WebElement selectPackageName;

    @FindBy(xpath = ".//*[@id='MainContent_txtFeedBack']")
    WebElement txtFeedBack;

    @FindBy(xpath = ".//*[@id='MainContent_txtBasicRate']")
    WebElement txtBasicRate;

    @FindBy(xpath = ".//*[@id='MainContent_txtExtraKmAmt']")
    WebElement txtExtraKmAmount;

    @FindBy(xpath = ".//*[@id='MainContent_txtExtraHrAmt']")
    WebElement txtExtraHrAmount;

    @FindBy(xpath = "")
    WebElement chkBoxOutStationAllowance;

    @FindBy(xpath = ".//*[@id='MainContent_txtOutStn_Allow']")
    WebElement txtOutStationAllowance;

    @FindBy(xpath = ".//*[@id='MainContent_ChkNight_Allow']")
    WebElement chkBoxNightAllowance;

    @FindBy(xpath = ".//*[@id='MainContent_txtNight_Allow']")
    WebElement txtNightAllowance;

    @FindBy(xpath = "")
    WebElement chkBoxParking;

    @FindBy(xpath = ".//*[@id='MainContent_txtParking']")
    WebElement txtParking;

    @FindBy(xpath = ".//*[@id='MainContent_ChkToll']")
    WebElement chkBoxToll;

    @FindBy(xpath = ".//*[@id='MainContent_txtToll']")
    WebElement txtToll;

    @FindBy(xpath = "")
    WebElement chkBoxOtherRecovery;

    @FindBy(xpath = ".//*[@id='MainContent_txtOther_Recover']")
    WebElement txtOtherRecovery;

    @FindBy(xpath = ".//*[@id='MainContent_ChkInterState_Tax']")
    WebElement chkBoxInterStateTax;

    @FindBy(xpath = ".//*[@id='MainContent_txtInterState_Tax']")
    WebElement txtInterStateTax;

    @FindBy(xpath = ".//*[@id='MainContent_chkService_Tax']")
    WebElement chkBoxServiceTax;

    @FindBy(xpath = ".//*[@id='MainContent_txtService_Tax_Amt']")
    WebElement txtServiceTaxAmount;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotal']")
    WebElement total;

    @FindBy(xpath = ".//*[@id='MainContent_txtGross_Amt']")
    WebElement txtGrossAmount;

    @FindBy(xpath = ".//*[@id='MainContent_chkemail']")
    WebElement chkSendEmailToClient;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnCreate;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement   btnReset;


    public QuickInvoice(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if (!quickInvoice.isDisplayed()){
            throw new IllegalStateException("This is not Quick Invoice Page");
        }
    }

    public void setQuickInvoice(String quickinvoice)
    {
        quickInvoice.sendKeys(quickinvoice);
    }
    public void setSelectPreviousInvoice(String previousInvoice)
    {
        Select previousInvoicecombo =new Select(selectPreviousInvoice);
        previousInvoicecombo.selectByVisibleText(previousInvoice);
    }
    public void setBookingNo(String bookingno)
    {
        bookingNo.sendKeys(bookingno);
    }
    /*public void setSelectInvoiceDate(String invoicedate)
    {

    }*/
    public void setSelectCompany(String company)
    {
        Select companycombo = new Select(selectCompany);
        companycombo.selectByVisibleText(company);
    }
    public void setTxtReportingAddress(String reportingAddress)
    {
        txtReportingAddress.sendKeys(reportingAddress);
    }
    public void setSelectRentalCity(String rentalCity)
    {
        Select rentalCitycombo = new Select(selectRentalCity);
        rentalCitycombo.selectByVisibleText(rentalCity);
    }
    public void setTxtNameOfGuest(String nameOfguest)
    {
       txtNameOfGuest.sendKeys(nameOfguest);
    }
    public void setTxtBookedBy(String bookedBy)
    {
        txtBookedBy.sendKeys(bookedBy);
    }
    public void setTxtMobileno(String mobileNo)
    {
        txtMobileno.sendKeys(mobileNo);
    }
    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }
    public void clickOwned()
    {
        radioOwnedFleet.click();
    }
    public void clickVendor()
    {
        radioVendorFleet.click();
    }
    public void setSelectFleetCategory(String fleetCategory)
    {
        Select fleetCategorycombo=new Select(selectFleetCategory);
        fleetCategorycombo.selectByVisibleText(fleetCategory);
    }
    public void setSelectFleetType(String fleetType)
    {
        Select fleetTypecombo = new Select(selectFleetType);
        fleetTypecombo.selectByVisibleText(fleetType);
    }
    public void setSelectFleetNo(String fleetNo)
    {
        Select fleetNocombo = new Select(selectFleetNo);
        fleetNocombo.selectByVisibleText(fleetNo);
    }
    public void setSelectChauffeurName(String chauffeurName)
    {
        Select chauffeurNamecombo = new Select(selectChauffeurName);
        chauffeurNamecombo.selectByVisibleText(chauffeurName);
    }
    /*public void setSelectDateOut(String dateOut)
    {

    }
    public void setSelectDateIn(String dateIn)
    {

    }
    public void setTotalDays(String totalDays)
    {

    }*/

    public void setSelectTimeOutHr(String timeOutHr)
    {
        Select timeOutHrcombo =new Select(selectTimeOutHr);
        timeOutHrcombo.selectByVisibleText(timeOutHr);
    }
    public void setSelectTimeOutMin(String timeOutMin)
    {
        Select timeOutMincombo =new Select(selectTimeOutMin);
        timeOutMincombo.selectByVisibleText(timeOutMin);
    }
    public void setSelectTimeInHr(String timeInHr)
    {
        Select timeInHrcombo =new Select(selectTimeInHr);
        timeInHrcombo.selectByVisibleText(timeInHr);
    }
    public void setSelectTimeInMin(String timeInMin)
    {
        Select timeInMincombo = new Select(selectTimeInMin);
        timeInMincombo.selectByVisibleText(timeInMin);
    }
    public void setTxtKmOut(String kmOut)
    {
        txtKmOut.sendKeys(kmOut);
    }
    public void setTxtKmIn(String kmIn)
    {
        txtKmIn.sendKeys(kmIn);
    }
    public void setTotalKm(String totalkm)
    {
        totalKm.sendKeys(totalkm);
    }
    public void setSelectPackageName(String packageName)
    {
        Select packageNamecombo = new Select(selectPackageName);
        packageNamecombo.selectByVisibleText(packageName);
    }
    public void setTxtFeedBack(String feedBack)
    {
        txtFeedBack.sendKeys(feedBack);
    }
    public void setTxtBasicRate(String basicRate)
    {
        txtBasicRate.sendKeys(basicRate);
    }
    public void setTxtExtraKmAmount(String extraKmAmount)
    {
        txtExtraKmAmount.sendKeys(extraKmAmount);
    }
    public void setTxtExtraHrAmount(String extraHrAmount)
    {
        txtExtraHrAmount.sendKeys(extraHrAmount);
    }
    public void clickchkBoxOutstation()
    {
        chkBoxOutStationAllowance.click();
    }
    public void setTxtOutStationAllowance(String outStationAllowance)
    {
        txtOutStationAllowance.sendKeys(outStationAllowance);
    }
    public void clickchkNightAllowance()
    {
        chkBoxNightAllowance.click();
    }
    public void setTxtNightAllowance(String nightAllowance)
    {
        txtNightAllowance.sendKeys(nightAllowance);
    }
    public void clickchkParking()
    {
        chkBoxParking.sendKeys();
    }
    public void setTxtParking(String parking)
    {
        txtParking.sendKeys(parking);
    }
    public void clickchkToll()
    {
        chkBoxToll.click();
    }
    public void setTxtToll(String toll)
    {
        txtToll.sendKeys(toll);
    }
    public void clickchkOtherRecovery()
    {
        chkBoxOtherRecovery.click();
    }
    public void setTxtOtherRecovery(String otherRecovery)
    {
        txtOtherRecovery.sendKeys(otherRecovery);
    }
    public void clickchkInterStateTax()
    {
        chkBoxInterStateTax.click();
    }
    public void setTxtInterStateTax(String interStateTax)
    {
        txtInterStateTax.sendKeys(interStateTax);
    }
    public void clickchkServiceTax()
    {
        chkBoxServiceTax.click();
    }
    public void setTxtServiceTaxAmount(String serviceTaxAmount)
    {
        txtServiceTaxAmount.sendKeys(serviceTaxAmount);
    }
    public void setTotal(String total1)
    {
        total.sendKeys(total1);
    }
    public void setTxtGrossAmount(String grossAmount)
    {
        txtGrossAmount.sendKeys(grossAmount);
    }
    public void clickchkSendEmailToClient()
    {
        chkSendEmailToClient.click();
    }
    public void clickCreate()
    {
        btnCreate.click();
    }
    public void clickReset()
    {
        btnReset.click();
    }








}

