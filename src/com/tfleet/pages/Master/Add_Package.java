package com.tfleet.pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tct4 on 8/4/2016.
 */
public class Add_Package {

    WebDriver driver;

    @FindBy(xpath="")
    WebElement Pkg_Name;

    @FindBy(xpath="")
    WebElement Total_Hrs;

    @FindBy(xpath="")
    WebElement Total_Kms;

    @FindBy(xpath="")
    WebElement Extra_Hrs;

    @FindBy(xpath="")
    WebElement Extra_Kms;

    @FindBy(xpath="")
    WebElement Pkg_amnt;

    @FindBy(xpath="")
    WebElement btnSave;

    @FindBy(xpath="")
    WebElement btnCancel;

}
