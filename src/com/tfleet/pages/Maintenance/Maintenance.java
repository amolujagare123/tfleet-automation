package com.tfleet.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

/**
 * Created by Sai Ram on 13/12/2016.
 */
public class Maintenance {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='A7']")
    WebElement Maintenancelnk;

    @FindBy(xpath = ".//*[@id='A41']")
    WebElement MaintenanceLnk;

    @FindBy(xpath = ".//*[@id='Form1']/div[3]/div[2]/div[1]/section/div/div[1]/div[1]/h2")
    WebElement Maintenance;       //Maintenance Heading Name

    @FindBy(xpath = ".//*[@id='MainContent_txtdate']")
    WebElement SelectDate;

    @FindBy(xpath = ".//*[@id='MainContent_txtMaintenanceNo']")
    WebElement MaintenanceNo;

    @FindBy(xpath = ".//*[@id='MainContent_txt_PNR_No']")
    WebElement txtPnrNo;

    @FindBy(xpath = ".//*[@id='MainContent_Label17']")
    WebElement MaintenanceDetail;  //maintenance detail heading

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetCategory']")
    WebElement selectFleetCategory;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetType']")
    WebElement selectFleetType;

    @FindBy(xpath = ".//*[@id='MainContent_ddlFleetNo']")
    WebElement selectFleetNo;

    @FindBy(xpath = ".//*[@id='MainContent_ddlEmployee']")
    WebElement selectAuthorisedPerson;

    @FindBy(xpath = ".//*[@id='MainContent_ddlType']")
    WebElement selectMaintenanceType;

    @FindBy(xpath = ".//*[@id='MainContent_ddlChauffeur']")
    WebElement selectChauffeurName;

    @FindBy(xpath = ".//*[@id='MainContent_txtmeterReading']")
    WebElement txtMeterReading;

    @FindBy(xpath = ".//*[@id='MainContent_ddlGarageNm']")
    WebElement selectGarageName;

    @FindBy(xpath = ".//*[@id='MainContent_chkPaid']")
    WebElement selectpaidChkBox;

    @FindBy(xpath = ".//*[@id='MainContent_grd_Maint_Det']/tbody/tr[2]/td[1]/p")
    WebElement srNo;

    @FindBy(xpath = ".//*[@id='MainContent_grd_Maint_Det_txtParticulars_0']")
    WebElement txtPerticular;

    @FindBy(xpath = ".//*[@id='MainContent_grd_Maint_Det_txtDescription_0']")
    WebElement txtDescription;

    @FindBy(xpath = ".//*[@id='MainContent_grd_Maint_Det_txtAmt_0']")
    WebElement txtAmount;

    @FindBy(xpath = ".//*[@id='MainContent_grd_Maint_Det_ButtonAdd']")
    WebElement btnAddNewRow;   //Add New Row Button

    @FindBy(xpath = ".//*[@id='MainContent_txtRemark']")
    WebElement txtRemark;

    @FindBy(xpath = ".//*[@id='MainContent_txtTotal']")
    WebElement Total;

    @FindBy(xpath = ".//*[@id='MainContent_btnSave']")
    WebElement btnSave;

    @FindBy(xpath = ".//*[@id='MainContent_btnCancel']")
    WebElement btnCancel;

    public Maintenance(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(! Maintenance.isDisplayed()){
            throw new IllegalStateException("This is not maintenance page");
        }
    }

            public void Maintenance(String maintenance)

            {
                Maintenance.sendKeys(maintenance);
            }
            public void SetDate(String date)
            {
             Select datecombo= new Select(SelectDate);
                datecombo.selectByVisibleText(date);
            }
            public void MaintenanceNo(String maintenanceno)
            {
                MaintenanceNo.sendKeys(maintenanceno);
            }
            public void SettxtPnrNo(String pnrno)

            {
               txtPnrNo.sendKeys(pnrno);
            }
            public void setMaintenanceDetail(String maintenanceDetail)
            {
                MaintenanceDetail.sendKeys(maintenanceDetail);
            }
            public void setSelectFleetCategory(String fleetCategory)
            {
                Select fleetCategorycombo =new Select(selectFleetCategory);
                fleetCategorycombo.selectByVisibleText(fleetCategory);
            }
            public void setSelectFleetType(String fleetType)
            {
               Select fleetTypecombo =new Select(selectFleetType);
                fleetTypecombo.selectByVisibleText(fleetType);
            }
            public void setSelectFleetNo(String fleetNo)
            {
               Select fleetNocombo =new Select(selectFleetNo);
                fleetNocombo.selectByVisibleText(fleetNo);
            }
            public void setSelectAuthorisedPerson(String authorisedPerson)
            {
               Select authorisedPersoncombo =new Select(selectAuthorisedPerson);
                authorisedPersoncombo.selectByVisibleText(authorisedPerson);
            }
            public void setSelectMaintenanceType(String maintenanceType)
            {
               Select maintenanceTypecombo =new Select(selectMaintenanceType);
                maintenanceTypecombo.selectByVisibleText(maintenanceType);
            }
            public void setSelectChauffeurName(String chauffeurName)
            {
                Select chauffeurNamecombo =new Select(selectChauffeurName);
                chauffeurNamecombo.selectByVisibleText(chauffeurName);
            }
            public void settxtMeterReading(String meterReading)
            {
                txtMeterReading.sendKeys(meterReading);
            }
            public void setSelectGarageName(String garageName)
            {
                Select garageNameCombo = new Select(selectGarageName);
                garageNameCombo.selectByVisibleText(garageName);
            }
            public void ClickpaidChkBox()
            {
               selectpaidChkBox.click();
            }
            public void setsrNo(String srno)
            {
                srNo.sendKeys(srno);
            }
            public void settxtPerticular(String perticular)
            {
                txtPerticular.sendKeys(perticular);
            }
            public void settxtDescription(String description)
            {
                txtDescription.sendKeys(description);
            }
            public void settxtAmount(String amount)
            {
                txtAmount.sendKeys(amount);
            }
            public void clickAddNewbtn()
            {
                btnAddNewRow.click();
            }
            public void settxtRemark(String remark)
            {
                txtRemark.sendKeys(remark);
            }
            public void Total(String total)
            {
                Total.sendKeys(total);
            }
            public void clickSave()
            {
                btnSave.click();
            }
            public void clickCancel()
            {
                btnCancel.click();
            }

}
