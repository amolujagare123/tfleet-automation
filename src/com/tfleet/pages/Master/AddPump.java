package com.tfleet.pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tct4 on 8/4/2016.
 */
public class AddPump {

    WebDriver driver;

    @FindBy(xpath="")
    WebElement PgHead;

    @FindBy(xpath="")
    WebElement PumpName;

    @FindBy(xpath="")
    WebElement PumpAddress;

    @FindBy(xpath="")
    WebElement Email;

    @FindBy(xpath="")
    WebElement LandlineNo;

    @FindBy(xpath="")
    WebElement ContactNo;

    @FindBy(xpath="")
    WebElement ContactPerson;

    public AddPump(WebDriver driver)
    {
        this.driver=driver;
    }
}
