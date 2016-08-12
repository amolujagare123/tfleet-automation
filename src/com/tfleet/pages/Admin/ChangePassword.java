package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sai Ram on 08/08/2016.
 */
public class ChangePassword {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement AdminLnk;

    @FindBy(xpath = ".//*[@id='A43']")
    WebElement ChangePasswordLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement ChangePasswordHeading;

    @FindBy(xpath = ".//*[@id='MainContent_txtUserName']")
    WebElement UserName;

    @FindBy(xpath = ".//*[@id='MainContent_txtOldPassword']")
    WebElement OldPassword;

    @FindBy(xpath = ".//*[@id='MainContent_txtPassword']")
    WebElement NewPassword;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement ChangePasswordBtn;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement CancelBtn;

    public ChangePassword(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!ChangePasswordHeading.isDisplayed()){
            throw new IllegalStateException("This is not Change Password page");
        }
    }

    public void setAdminLnk(String adminLnk)
    {
        AdminLnk.sendKeys(adminLnk);
    }

    public void setChangePasswordLnk(String changePasswordLnk)
    {
        ChangePasswordLnk.sendKeys(changePasswordLnk);
    }

    public void setChangePasswordHeading(String changePasswordHeading)
    {
        ChangePasswordHeading.sendKeys(changePasswordHeading);
    }

    public void setUserName(String userName)
    {
        UserName.sendKeys(userName);
    }

    public void setOldPassword(String oldPassword)
    {
        OldPassword.sendKeys(oldPassword);
    }

    public void setNewPassword(String newPassword)
    {
        NewPassword.sendKeys(newPassword);
    }

    public void ClickChangePassword()
    {
      ChangePasswordBtn.click();
    }

    /*public void ClickCancel()
    {
        CancelBtn.click();
    }*/
}
