package com.tfleet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by vaishali on 4/19/2015.
 */
public class LoginPage {
    @FindBy(xpath = "//*[@id='txtUserName']")
    WebElement txtUserName;
    @FindBy(xpath = "//*[@id='txtPassword']")
    WebElement txtPassword;
    @FindBy(xpath = "//*[@id='btnLogIn']")
    WebElement btnLogin;
    WebDriver driver;

    public LoginPage(WebDriver driver,String url) {
        this.driver=driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
        if(!btnLogin.isDisplayed()){
            throw new IllegalStateException("This is not Login Page");
        }
    }

    public DashBoard Login(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return new DashBoard(driver);
    }
}
