package com.tfleet.pages.Dispatch;

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
 * Created by tcraft on 26/12/2015.
 */
public class CreateDutySlip {

    WebDriver driver;

    @FindBy(xpath="//*[@id='MainContent_lblBookingNo']")
    WebElement dsno;

    @FindBy(xpath="//*[@id='MainContent_rdbF_OwnedType_0']")
    WebElement ownRadio;

    @FindBy(xpath="//*[@id='MainContent_rdbF_OwnedType_1']")
    WebElement vendorRadio;

    @FindBy(xpath="//*[@id='MainContent_ddlFleetCategory']")
    WebElement vendorSelect;

    @FindBy(xpath="//*[@id='MainContent_ddlFleetCategory']")
    WebElement fleetTypeSelect;

    @FindBy(xpath="//*[@id='MainContent_ddlFleetType']")
    WebElement fleetCategorySelect;

    @FindBy(xpath="//*[@id='MainContent_ddlFleetNo']")
    WebElement fleetNoSelect;

    @FindBy(xpath="//*[@id='MainContent_ddlEmployee']")
    WebElement chaufferNameSelect;

    @FindBy(xpath="//*[@id='MainContent_txtKmOut']")
    WebElement kmOutText;

    @FindBy(xpath="//*[@id='MainContent_txtPhyDS_No']")
    WebElement physicalDSText;



    @FindBy(xpath="//*[@id='MainContent_ddlHr']")
    WebElement dispatchTimeHrSelect;

    @FindBy(xpath="//*[@id='MainContent_ddlmin']")
    WebElement dispatchTimeMinSelect;

    @FindBy(xpath="//*[@id='MainContent_txtDispatchDate']")
    WebElement dispathDateText;

    @FindBy(xpath="//*[@id='MainContent_chkemail']")
    WebElement senMailText;



    public CreateDutySlip(WebDriver driver,String ds) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!dsno.getText().equals(ds))
        {
            throw new IllegalStateException("This is not a Create DutySlip Page or wrong DS is opened ");
        }
    }

    public void clickSendMail()
    {
       senMailText.click();
    }
    public void clickFleetTypeOwned()
    {
        ownRadio.click();
    }

    public void clickFleetTypeVendor()
    {
        vendorRadio.click();
    }

    public void selectVendor(String vendor)
    {
        Select companyCombo = new Select(vendorSelect);
        companyCombo.selectByVisibleText(vendor);
    }

    public void selectFleetCategory(String fleetCategory)
    {
        Select companyCombo = new Select(fleetCategorySelect);
        companyCombo.selectByVisibleText(fleetCategory);
    }

    public void selectFleetType(String fleetType)
    {
        Select companyCombo = new Select(fleetTypeSelect);
        companyCombo.selectByVisibleText(fleetType);
    }

    public void selectFleetNo(String fleetNo)
    {
        Select companyCombo = new Select(fleetNoSelect);
        companyCombo.selectByVisibleText(fleetNo);
    }

    public void selectChauffer(String chauffer)
    {
        Select companyCombo = new Select(chaufferNameSelect);
        companyCombo.selectByVisibleText(chauffer);
    }

    public void setKmOut(String kmOut)
    {
        kmOutText.sendKeys(kmOut);
    }

    public void setPhysicalDS(String pds)
    {
        physicalDSText.sendKeys(pds);
    }


    public void selectHr(String hr)
    {
        Select companyCombo = new Select(dispatchTimeHrSelect);
        companyCombo.selectByVisibleText(hr);
    }

    public void selectMin(String min)
    {
        Select companyCombo = new Select(dispatchTimeMinSelect);
        companyCombo.selectByVisibleText(min);
    }


    public void setDispatchDate(String date) throws ParseException {


        dispathDateText.click();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM, yyyy");
        Date setNewDate = myDateFormat.parse(date);
        System.out.println(setNewDate);
        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='MainContent_txtDate_CalendarExtender_title']")).getText());
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setNewDate).withDayOfMonth(1)).getMonths();
        System.out.println(monthDiff);
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff *= -1;
        }

        for (int i = 1; i <= monthDiff; i++) {
            driver.findElement(By.xpath(" .//*[@id='MainContent_txtDate_CalendarExtender_" + (isFuture ? "next" : "prev") + "Arrow']")).click();
        }

        driver.findElement(By.xpath("//div[@id='MainContent_txtDate_CalendarExtender_container']//div[@title='" + new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(setNewDate) + "']")).click();

    }



}
