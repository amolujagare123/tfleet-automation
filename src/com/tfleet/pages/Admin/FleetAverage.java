package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 08/08/2016.
 */
public class FleetAverage {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement AdminLnk;

    @FindBy(xpath = ".//*[@id='A51']")
    WebElement FleetAverageLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement FleetAverageHeading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetNo']")
    WebElement FleetNo;

    @FindBy(xpath = ".//*[@id='MainContent_lblAverage']")
    WebElement AverageLnk;

    public FleetAverage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        if(!FleetAverageHeading.isDisplayed()){
            throw new IllegalStateException("This is not FleetAvrage Page");
        }
    }

        public void setAdminLnk (String adminLnk)
        {
            AdminLnk.sendKeys(adminLnk);
        }

        public void setFleetAverageLnk(String fleetAverageLnk)
        {
            FleetAverageLnk.sendKeys(fleetAverageLnk);
        }

        public void setFleetAverageHeading(String fleetAverageHeading)
        {
            FleetAverageHeading.sendKeys(fleetAverageHeading);
        }

        public void setselectFleetNo(String setFleetNo)
        {
            Select fleetNoCombo = new Select(FleetNo);
            fleetNoCombo.selectByVisibleText(setFleetNo);
        }

        public void setAverageLnk(String averageLnk)
        {
            AverageLnk.sendKeys(averageLnk);
        }
}
