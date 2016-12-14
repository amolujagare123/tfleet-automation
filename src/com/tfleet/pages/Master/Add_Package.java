package com.tfleet.pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tct4 on 8/4/2016.
 */
public class Add_Package {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='Form1']/div[3]/div[2]/div[1]//div[1]/h2")
    WebElement PgHead;

    @FindBy(xpath=".//*[@id='MainContent_txtPackage_Nm']")
    WebElement PkgName;

    @FindBy(xpath=".//*[@id='MainContent_txtBasic_Hr']")
    WebElement BasicHrs;

    @FindBy(xpath=".//*[@id='MainContent_txtBasic_Km']")
    WebElement BasicKms;

    @FindBy(xpath=".//*[@id='MainContent_txtExtraHr']")
    WebElement ExtraHrsAmt;

    @FindBy(xpath=".//*[@id='MainContent_txtExtraKm']")
    WebElement ExtraKmsAmt;

    @FindBy(xpath=".//*[@id='MainContent_txtPack_Amt']")
    WebElement PkgAmnt;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetCategory']")
    WebElement FleetCategory;

    @FindBy(xpath=".//*[@id='MainContent_ddlFleetType']")
    WebElement FleetType;

    @FindBy(xpath=".//*[@id='MainContent_Button1']")
    WebElement assignPkgToVendor;

    @FindBy(xpath=".//*[@id='MainContent_btnAddPackageToCompany']")
    WebElement assignPkgToCmp;

    @FindBy(xpath=".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath=".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public Add_Package(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!PgHead.isDisplayed())
        {
            throw new IllegalStateException("This is not a Add Package page");
        }

    }

    public void setPkgName(String pkgName) {
        PkgName.sendKeys(pkgName);
    }

    public void setBasicHrs(String basicHrs) {
        BasicHrs.sendKeys(basicHrs);
    }

    public void setBasicKms(String basicKms) {
        BasicKms.sendKeys(basicKms);
    }

    public void setExtraHrsAmt(String extraHrsAmt) {
        ExtraHrsAmt.sendKeys(extraHrsAmt);
    }

    public void setExtraKmsAmt(String extraKmsAmt) {
        ExtraKmsAmt.sendKeys(extraKmsAmt);
    }

    public void setPkgAmnt(String pkgAmnt) {
        PkgAmnt.sendKeys(pkgAmnt);
    }

    public void ClickBtnSave() {
        btnSave.click();
    }
    public void ClickBtnCancel()
    {
        btnCancel.click();
    }
    public void setAssignPkgToVendor()
    {
        assignPkgToVendor.click();

    }
    public void setAssignPkgToCmp()
    {
        assignPkgToCmp.click();
    }

    public void selectFleetCategory(String fCategory)
    {
        Select fCategoryCombo=new Select(FleetCategory);
        fCategoryCombo.selectByVisibleText(fCategory);
    }
    public void selectFleetType(String fType)
    {
        Select fTypeCombo=new Select(FleetType);
                fTypeCombo.selectByVisibleText(fType);
    }

}
