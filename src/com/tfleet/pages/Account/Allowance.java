package com.tfleet.pages.Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tct4 on 12/16/2016.
 */
public class Allowance {

    WebDriver driver;

    @FindBy(xpath="")
    WebElement AllowanceHeading;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    @FindBy(xpath="")
    WebElement ;

    public Allowance(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!AllowanceHeading.isDisplayed())
        {
            throw new IllegalStateException("This is not a Allowance page");
        }
    }
}
