package com.tfleet.pages.Dispatch;

import com.tfleet.pages.Menu;
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
import java.util.concurrent.TimeUnit;

/**
 * Created by TCT on 15-12-15.
 */
public class DutySlip
{
    WebDriver driver;
    @FindBy(xpath = ".//*[@id='MainContent_txtFromDate']")
    WebElement fromDate;


    @FindBy(xpath = ".//*[@id='MainContent_txtTodate']")
    WebElement toDate;

    @FindBy(xpath = ".//*[@id='MainContent_ddlCompany']")
    WebElement selectCompany;

    @FindBy(xpath = ".//*[@id='MainContent_btnShow']")
    WebElement btnShow;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancelShow']")
    WebElement btnCancel;

    @FindBy(xpath = ".//*[@id='MainContent_grdRes_ob_grdResBodyContainer']//td[1]/div/div[1]")
    WebElement edit;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement headingText;

    public DutySlip(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!headingText.isDisplayed())
        {
            throw new IllegalStateException("This is not a Create DutySlip Page");
        }
    }

    public void clickShow()   {btnShow.click();}
       //public void clickEdit()    {edit.click();}
    public void clickCancel()  {btnCancel.click();}

    public void setSelectCompany(String setCompany)
    {
        Select companyCombo = new Select(selectCompany);
        companyCombo.selectByVisibleText(setCompany);

    }

    public void setFromDate(String date) throws ParseException {
        fromDate.click();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM, yyyy");
        Date setNewDate=myDateFormat.parse(date);
        System.out.println(setNewDate);
        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='MainContent_txtDateCalendarExtender_title']")).getText());
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setNewDate).withDayOfMonth(1)).getMonths();
        System.out.println(monthDiff);
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }

        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath(" .//*[@id='MainContent_txtDateCalendarExtender_" + (isFuture ? "next" : "prev") + "Arrow']")).click();
        }

//        driver.findElement(By.xpath("//div[@id='MainContent_txtDateCalendarExtender_container']//div[text()='"+new SimpleDateFormat("dd").format(setNewDate)+"' and contains(@title,'" + new SimpleDateFormat("MMMM").format(setNewDate)+"')]")).click();
//        driver.findElement(By.xpath("//div[@id='MainContent_txtDateCalendarExtender_container']//div[contains(@title,'"+ new SimpleDateFormat("MMMM").format(setNewDate)+", "+new SimpleDateFormat("dd").format(setNewDate)+"')]")).click();
        driver.findElement(By.xpath("//div[@id='MainContent_txtDateCalendarExtender_container']//div[@title='" + new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(setNewDate) + "']")).click();


    }

    public void setToDate(String date) throws ParseException {
        toDate.click();
        SimpleDateFormat myDateFormat  = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM, yyyy");
        Date setNewDate=myDateFormat.parse(date);
        System.out.println(setNewDate);
        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='MainContent_CalendarExtender1_title']")).getText());
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setNewDate).withDayOfMonth(1)).getMonths();
        System.out.println(monthDiff);
        boolean isFuture = true;
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }

        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath(" .//*[@id='MainContent_txtDateCalendarExtender1_" + (isFuture ? "next" : "prev") + "Arrow']")).click();
        }

//        driver.findElement(By.xpath("//div[@id='MainContent_txtDateCalendarExtender_container']//div[text()='"+new SimpleDateFormat("dd").format(setNewDate)+"' and contains(@title,'" + new SimpleDateFormat("MMMM").format(setNewDate)+"')]")).click();
//        driver.findElement(By.xpath("//div[@id='MainContent_txtDateCalendarExtender_container']//div[contains(@title,'"+ new SimpleDateFormat("MMMM").format(setNewDate)+", "+new SimpleDateFormat("dd").format(setNewDate)+"')]")).click();
        driver.findElement(By.xpath("//div[@id='MainContent_CalendarExtender1_container']//div[@title='" + new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(setNewDate) + "']")).click();

    }//MainContent_CalendarExtender1_container

    public void clickEditDS(String id,String status)
    {
        //td[contains(text(),'Joe')]/preceding-sibling::td/input[@name='chkNSelect']
        ////tr[td[div[div[contains(text(),'0054')]]]]/td//input[@type='image']
        //tr[td[div[div[contains(text(),'0054')]]] and td[div[div[contains(text(),'DS Not Created')]]]]/td//input[@type='image']

        WebElement edit= driver.findElement(By.xpath("//tr[td[div[div[contains(text(),'" + id + "')]]] and td[div[div[contains(text(),'" + status + "')]]]]/td//input[@type='image']"));
        edit.click();
    }

    public CreateDutySlip gotoDS(String ds)
    {
        Menu menu=new Menu(driver);
        DutySlip DS= new DutySlip(driver);
        menu.clickCreateDutySlip();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DS.clickEditDS(ds,"DS Not Created");
          return new CreateDutySlip(driver,ds);
    }
}