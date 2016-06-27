package com.tfleet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import test.Reservation;

/**
 * Created by vaishali on 4/19/2015.
 */
public class DashBoard {
    WebDriver driver;
    @FindBy(xpath="//a[@href='../Reservation/Reservation.aspx']")
    WebElement lnkNewPo;
    @FindBy(xpath = "//a[@href='../../Login.aspx']")
    WebElement imgLogout;

    public DashBoard(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        if(!imgLogout.isDisplayed())
        {
            throw new IllegalStateException("This is not Dash board");
        }
    }

   /* public Reservation getNewPO() {

        return new Reservation(driver);
    }*/
}
