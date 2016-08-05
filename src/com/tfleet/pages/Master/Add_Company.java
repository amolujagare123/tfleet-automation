package com.tfleet.pages.Master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tct4 on 8/3/2016.
 */
public class Add_Company {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]//div[1]/h2")
    WebElement compname;

    @FindBy(xpath = "//*[@id='MainContent_txtCompName']")
    WebElement CompanyName;

    @FindBy(xpath = "//*[@id='MainContent_txtAddress']")
    WebElement CompanyAddress;

    @FindBy(xpath = "//*[@id='MainContent_txtEmail']")
    WebElement CompanyEmail;

    @FindBy(xpath = "//*[@id='MainContent_txtLandlineNo']")
    WebElement CompanyLandlineNo;

    @FindBy(xpath = "//*[@id='MainContent_txtPrimContPerson']")
    WebElement ContactPerson1;

    @FindBy(xpath = "//*[@id='MainContent_txtPrimContNo']")
    WebElement ContactNo1;

    @FindBy(xpath = "//*[@id='MainContent_txtSecContPerson']")
    WebElement ContactPerson2;

    @FindBy(xpath = "//*[@id='MainContent_txtSecContNo']")
    WebElement ContactNo2;

    @FindBy(xpath = "//*[@id='MainContent_txtContPerson_3']")
    WebElement ContactPerson3;

    @FindBy(xpath = ".//*[@id='MainContent_txtContNo_3']")
    WebElement ContactNo3;

    @FindBy(xpath = "//*[@id='MainContent_txtContPerson_4']")
    WebElement ContactPerson4;

    @FindBy(xpath = ".//*[@id='MainContent_txtContNo_4']")
    WebElement ContactNo4;

    @FindBy(xpath = ".//*[@id='MainContent_txtContPerson_5']")
    WebElement ContactPerson5;

    @FindBy(xpath = ".//*[@id='MainContent_txtContNo_5']")
    WebElement ContactNo5;

    @FindBy(xpath = ".//*[@id='MainContent_txtContPerson_6']")
    WebElement ContactPerson6;

    @FindBy(xpath = ".//*[@id='MainContent_txtContNo_6']")
    WebElement ContactNo6;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public Add_Company(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!compname.isDisplayed()) {
            throw new IllegalStateException("This is not a Add Company Page ");
        }
    }

    public void setTxtCompName(String cname) {
        CompanyName.sendKeys(cname);
    }

    public void setTxtCompAddress(String caddress) {
        CompanyAddress.sendKeys(caddress);
    }

    public void setTextCompEmail(String cemail) {
        CompanyEmail.sendKeys(cemail);
    }

    public void setTxtLandlineNo(String lno) {
        CompanyLandlineNo.sendKeys(lno);
    }

    public void setTxtPrimConPerson(String pcp) {
        ContactPerson1.sendKeys(pcp);
    }

    public void setTxtPrimConNo(String pcn) {
        ContactNo1.sendKeys(pcn);
    }

    public void setTxtSecConPerson(String scp) {
        ContactPerson2.sendKeys(scp);
    }

    public void setTxtSecConNo(String scn) {
        ContactNo2.sendKeys(scn);
    }

    public void setTxtTerConPerson(String tcp) {
        ContactPerson3.sendKeys(tcp);
    }

    public void setTxtTerConNo(String tcn) {
        ContactNo3.sendKeys(tcn);
    }

    public void setTxtFourthConPerson(String fourthcp) {
        ContactPerson4.sendKeys(fourthcp);
    }

    public void setTxtFourthConNo(String fourthcn) {
        ContactNo4.sendKeys(fourthcn);
    }

    public void setTxtFifthConPerson(String fifthcp) {
        ContactPerson5.sendKeys(fifthcp);
    }

    public void setTxtFifthConNo(String fifthcn) {
        ContactNo5.sendKeys(fifthcn);
    }

    public void setTxtsixthConPerson(String sixthcp) {
        ContactPerson6.sendKeys(sixthcp);
    }

    public void setTxtsixthConNo(String sixthcn) {
        ContactNo6.sendKeys(sixthcn);
    }

    public void clickSave() {
        btnSave.click();
    }

    public void clickCancel() {
        btnCancel.click();
    }

    public void clickEdit(String companyName)
   {
     driver.findElement(By.xpath("//tr[td//div[text()='"+companyName+"']]//input[@src='../../Images/pencil-128.png' ]")).click();
   }

    
}
