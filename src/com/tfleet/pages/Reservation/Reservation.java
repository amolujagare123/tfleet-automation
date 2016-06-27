package com.tfleet.pages.Reservation;


import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vaishali on 4/19/2015.
 */
public class Reservation {
    WebDriver driver;
    @FindBy(id="//a[@href='NewRQ.do']")
    WebElement lnkNewPo;


    @FindBy(xpath = "//div[@class='left_grid']/h2")
    WebElement poHeadingText;

    @FindBy(xpath = "//a[@href='../../Login.aspx']")
    WebElement imgLogout;

    @FindBy(xpath = "//textarea[@id='MainContent_txtRep_Address']")
    WebElement textAddress;


    @FindBy(xpath = "//input[@id='MainContent_txtNameOfGuest']")
    WebElement txtNameofGuest;

    @FindBy(xpath = "//input[@id='MainContent_txtEmail']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='MainContent_txtMobileNo']")
    WebElement txtMoblile;

    @FindBy(xpath = "//select[@id='MainContent_ddlRentalCity']")
    WebElement selectCity;

    @FindBy(xpath = "//select[@id='MainContent_ddlFleetCategory']")
    WebElement selectFleetCategory;


    @FindBy(xpath = "//select[@id='MainContent_ddlFleetType']")
    WebElement selectFleetType;

    @FindBy(xpath = "//select[@id='MainContent_ddlPackage']")
    WebElement selectPackage;

    @FindBy(xpath = "//input[@id='MainContent_txtDateOfrequirement']")
    WebElement selectDate;

    @FindBy(xpath = "//input[@id='MainContent_btnSave']")
    WebElement btnSave;


    public Reservation(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!poHeadingText.isDisplayed())
        {
            throw new IllegalStateException("This is not a Reservation page");
        }
    }


    public void setTextAddress(String address)
    {
        textAddress.sendKeys(address);
    }

    public void setTxtNameofGuest(String guestName)
    {
        txtNameofGuest.sendKeys(guestName);
    }

    public void setTxtMoblile(String moblile)
    {
        txtMoblile.sendKeys(moblile);
    }

    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void clickSave()
    {
        btnSave.click();
    }


    public void setSelectCity(String setCity)
    {
        Select cityCombo = new Select(selectCity);
        cityCombo.selectByVisibleText(setCity);

    }

    public void setSelectFleetCategory(String setFleetCategory)
    {
        Select cityCombo = new Select(selectFleetCategory);
        cityCombo.selectByVisibleText(setFleetCategory);

    }
    public void setSelectFleetType(String setFleetType)
    {

        Select cityCombo = new Select(selectFleetType);
        cityCombo.selectByVisibleText(setFleetType);

    }

    public void setSelectPackage(String setPackage)
    {

        Select cityCombo = new Select(selectPackage);
        cityCombo.selectByVisibleText(setPackage);

    }

    public void setDate(String date) throws ParseException {
        selectDate.click();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM, yyyy");
        Date setNewDate=myDateFormat.parse(date);

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath("//div[@id='MainContent_CalendarExtender2_title']")).getText());
        // Joda org.joda.time.Months class to calculate difference
        // to do this converted Date to joda DatTime
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setNewDate).withDayOfMonth(1)).getMonths();

        boolean isFuture = true;
        // decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath("//div[@id='MainContent_CalendarExtender2_" + (isFuture ? "next" : "prev") + "Arrow']")).click();
       }
        // Click on Day of Month from table



        //String dateXpath="//div[@id='MainContent_CalendarExtender2_days']/table//td/div[text()='"+new SimpleDateFormat("dd").format(setNewDate)+"' AND contains(@title,'"+ new SimpleDateFormat("MMMM").format(setNewDate)+"')]";
        //String dateXpath= "//div[@class='ajax__calendar_body']/div[1]/table//div[text()='"+new SimpleDateFormat("dd").format(setNewDate)+"' AND contains(@title,'"+ new SimpleDateFormat("MMMM").format(setNewDate)+"')]";
       // driver.findElement(By.xpath(dateXpath)).click();

        driver.findElement(By.xpath("//div[@id='MainContent_CalendarExtender2_popupDiv']//div[text()='" + new SimpleDateFormat("dd").format(setNewDate) + "' and contains(@title,'" +
                "" + new SimpleDateFormat("MMMM").format(setNewDate) + "')]")).click();


    }

    public static void main(String args[])
    {
        System.out.print("hi");
    }
}


