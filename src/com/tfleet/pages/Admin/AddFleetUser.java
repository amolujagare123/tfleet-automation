package com.tfleet.pages.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sai Ram on 04/08/2016.
 */
public class AddFleetUser {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement Adminlink;

    @FindBy(xpath = ".//*[@id='A1']")
    WebElement AFUlink;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement AFUHeading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlEmployee']")
    WebElement Employee;

    @FindBy(xpath = ".//*[@id='MainContent_txtEmail_Id']")
    WebElement Email;

    @FindBy(xpath = ".//*[@id='MainContent_txtPassword']")
    WebElement Password;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement Savebtn;

    /*@FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement Cancelbtn;*/

    public AddFleetUser(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if (!AFUHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not Add user fleet page");
        }
    }
    /*public void setAEHeadingText(String aeHeading)

    {
        AEHeadingText.sendKeys(aeHeading);
    }*/

    public  void setAFUHeadingText(String afuHeading)
    {
        AFUHeading.sendKeys(afuHeading);
    }
   /* public void setEmployee(String employee)
    {
        Employee.sendKeys(employee);
    }*/
    public void setEmail(String email)
    {
        Email.sendKeys(email);
    }
    public void setPassword(String password)
    {
        Password.sendKeys(password);
    }
    public void clickSave()
    {
        Savebtn.click();
    }

    public void setSelectEmployee(String setEmployee)
    {
        Select employeeCombo = new Select(Employee);
        employeeCombo.selectByVisibleText(setEmployee);
    }
}
