package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 08/08/2016.
 */
public class Permission {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement AdminLnk;

    @FindBy(xpath = ".//*[@id='A2']")
    WebElement PermissionLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div[1]/div[1]/div[1]/h2")
    WebElement PermissionHeading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlEmployee']")
    WebElement EmployeeName;

    @FindBy(xpath = ".//*[@id='MainContent_btnSelectAll']")
    WebElement SelectAllBtn;

    @FindBy(xpath = ".//*[@id='MainContent_HplAddFleetUser']/h6")
    WebElement AddUserLnk;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement SaveBtn;

   /* @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement CancelBtn;*/

    public Permission(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if (!PermissionHeading.isDisplayed()){
            throw new IllegalStateException("This is not Permission Page");
        }
    }


    public void setAdminLnk(String adminLnk)
    {
        AdminLnk.sendKeys(adminLnk);
    }

    public void setPermissionLnk(String permissionLnk)
    {
        PermissionLnk.sendKeys(permissionLnk);
    }

    public void setPermissionHeading(String permissionHeading)
    {
        PermissionLnk.sendKeys(permissionHeading);
    }

    public void setSelectEmployeeName(String setEmployeeName)
    {
        Select employeeNameCombo = new Select(EmployeeName);
        employeeNameCombo.selectByVisibleText(setEmployeeName);
    }

    public void setSelectAllBtn(String selectAllBtn)
    {
        SelectAllBtn.sendKeys(selectAllBtn);
    }

    public void setAddUserLnk(String addUserLnk)
    {
        AddUserLnk.sendKeys(addUserLnk);
    }

    public void clickSave()
    {
        SaveBtn.click();
    }

   /* public void clickCancel()
    {
        CancelBtn.click();
    }*/


}
