package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 08/08/2016.
 */
public class AddClientsUser {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement AdminLnk;

    @FindBy(xpath = ".//*[@id='A4']")
    WebElement AddClientsUserLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement AddClientsUserHeading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlCompany']")
    WebElement Company;

    @FindBy(xpath = ".//*[@id='MainContent_txtEmail']")
    WebElement UserEmailId;

    @FindBy(xpath = ".//*[@id='MainContent_txtPassword']")
    WebElement Password;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement SaveBtn;

    /*@FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement CancelBtn;*/

    public  AddClientsUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!AddClientsUserHeading.isDisplayed()) {
            throw new IllegalStateException("This is not Add Clients User Page ");
        }
    }

        public void setAdminLnk(String adminLnk)
        {
            AdminLnk.sendKeys(adminLnk);
        }

        public void setAddClientsUserLnk(String addClientsUserLnk)
        {
            AddClientsUserLnk.sendKeys(addClientsUserLnk);
        }

        public void setAddClientsUserHeading(String addClientsUserHeading)
        {
            AddClientsUserHeading.sendKeys(addClientsUserHeading);
        }

        public void setCompany(String setCompany)
        {
            Select companyCombo = new Select(Company);
            companyCombo.selectByVisibleText(setCompany);
        }

        public void setUserEmailId(String userEmailId)
        {
            UserEmailId.sendKeys(userEmailId);
        }

        public void setPassword(String password)
        {
            Password.sendKeys(password);
        }

        public void ClickSave()
        {
            SaveBtn.click();
        }

        /*public void ClickCancel()
        {
            CancelBtn.Click
        }*/
    }



