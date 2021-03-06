package com.tfleet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by TCT on 24-12-15.
 */
public class Menu
{
    WebDriver driver;

// Admin
    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[1]/a")
    WebElement Admin ;

    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[1]/ul/li[1]/a")
    WebElement AddEmployee ;

    @FindBy(xpath=".//*[@id='A1']")
    WebElement AddFleetUser ;

    @FindBy(xpath="//*[ text()='Permission']")
    WebElement Permission ;

    @FindBy(xpath=".//*[@id='A3']")
    WebElement Email ;

    @FindBy(xpath=".//*[@id='A4']")
    WebElement addClientUser ;

    @FindBy(xpath=".//*[@id='A43']")
    WebElement changeAdminPassword ;

    @FindBy(xpath= ".//*[@id='A51']")
    WebElement FleetAverage;

    @FindBy(xpath = ".//*[@id='A56']")
    WebElement SMSCredit;


// Resevation

    @FindBy(xpath=".//*[text()='Reservation']")
    WebElement ReservationLnk;

// Dispatch

    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[3]/a")
    WebElement Dispatch;

    @FindBy(xpath="//*[text()='Create Duty Slip']")
    WebElement createDutySlip;

    @FindBy(xpath="//*[text()='View Duty Slip']")
    WebElement viewDutySlip;

    @FindBy(xpath="//*[text()='Cancel Duty Slip']")
    WebElement cancelDutySlip;

//Billing

    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[4]/a")
    WebElement Billing;

    @FindBy(xpath="//*[text()='Close Duty Slip']")
    WebElement closeDutySlip;

    @FindBy(xpath="//*[text()='View Invoice']")
    WebElement viewInvoice;

    @FindBy(xpath="//*[text()='Cancel Invoice']")
    WebElement cancelInvoice;

    @FindBy(xpath="//*[text()='Company Billing'][@id='A13']")
    WebElement companyBilling;

    @FindBy(xpath="//*[text()='View Bill']")
    WebElement viewBill;

    @FindBy(xpath="//*[text() = 'Payment Voucher'][@id='A14']")
    WebElement paymentVoucher;

    @FindBy(xpath="//*[text()='Billing Ledger']")
    WebElement billingLedger;


//Quick Invoice

    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[5]/a")
    WebElement quickInvoice;

//Account

    @FindBy(xpath=".//*[@id='A6']")
    WebElement Account;

    @FindBy(xpath=".//*[@id='your-object']/div[2]/ul/li[6]/ul/li[1]/a")
    WebElement Expense;

    @FindBy(xpath="//*[@id='A9']")
    WebElement fuelConsumption;

    @FindBy(xpath=".//*[@id='A53']")
    WebElement Allowance;

    @FindBy(xpath="//*[@id='A15']")
    WebElement profitAndLoss;

    @FindBy(xpath="//*[@id='A44']")
    WebElement vehicleExpense;

    @FindBy(xpath="//*[@id='A11']")
    WebElement accountReports;

    @FindBy(xpath="//*[@href='../Reports/ExpensesRPT.aspx']")
    WebElement accountReportsExpense;

    @FindBy(xpath="//*[@href='../Reports/AllowancesRPT.aspx']")
    WebElement accountReportsAllowance;

    @FindBy(xpath="//*[@id='A37']")
    WebElement accountReportsFuelConsumption;

//Maintenance

    @FindBy(xpath=".//*[@id='A7']")
    WebElement Maintenance;

    @FindBy(xpath="//*[@id='A41']")
    WebElement subMaintenance;

    @FindBy(xpath="//*[@id='A8']")
    WebElement maintenanceVoucher;

    @FindBy(xpath="//*[@id='A17']")
    WebElement maintenanceReports;

    @FindBy(xpath="//*[@id='A18']")
    WebElement submaintenanceReports;

    @FindBy(xpath="//*[@id='A20']")
    WebElement maintenanceVoucherReports;

// Master

    @FindBy(xpath=".//*[@id='A28']")
    WebElement Master;

    @FindBy(xpath="//*[text()='Add Company']")
    WebElement addCompany;

    @FindBy(xpath="//*[text()='Add Vendor']")
    WebElement addVendor;

    @FindBy(xpath="//*[text()='Add/Edit Fleet']")
    WebElement addeditFleet;

    @FindBy(xpath=".//*[@id='A31']")
    WebElement masterPackage ;

   // @FindBy(xpath="//*[@id='A45']")
   // WebElement vendorPackageMaster;

    @FindBy(xpath=".//*[@id='A23']")
    WebElement Add_PetrolPump;

    @FindBy(xpath = ".//*[text()='Add Garage']")
    WebElement Add_Garage;


// Reports

    @FindBy(xpath=".//*[@id='A19']")
    WebElement Reports;

    @FindBy(xpath="//*[@id='your-object']/div[2]/ul/li[9]/ul/li[1]/a")
    WebElement reservationReports;

    @FindBy(xpath="//*[text()='Cancel Reservation']")
    WebElement cancelReservationReport;

    @FindBy(xpath="//*[text()='Pending Reservation']")
    WebElement pendingReservationReport;

    @FindBy(xpath="//*[text()='Pending Duty Slip']")
    WebElement pendingDutySlipReport;

    @FindBy(xpath="//*[text()='Cancel Duty Slip'][@id='A23']")
    WebElement cancelDutySlipReport ;

    @FindBy(xpath="//*[text()='Sales']")
    WebElement salesReport;

    @FindBy(xpath="//*[text()='Owned Fleet Sale']")
    WebElement ownedFleetSaleReport;

    @FindBy(xpath="//*[text()='Vendor Fleet Sale']")
    WebElement vendorFleetSaleReport;

    @FindBy(xpath="//*[text()='Cancelled Invoice']")
    WebElement cancelledInvoiceReport;

    @FindBy(xpath="//*[text()='Company Billing'][@id='A40']")
    WebElement companyBillingReport;

    @FindBy(xpath="//*[@id='A39']")
    WebElement paymentVoucherReport;

    @FindBy(xpath="//*[text()='Driver Duty Report']")
    WebElement driverDutyReport;


    public Menu(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Admin

    public void clickAddEmployee()
    {
        Admin.click();
        AddEmployee.click();
    }

    public void clickAddFleetUser()
    {
        Admin.click();
        AddFleetUser.click();
    }

    public void clickPermission()
    {
        Admin.click();
        Permission.click();
    }

    public void clickEmail()
    {
        Admin.click();
        Email.click();
    }
    public void clickFleetAverage()
    {
        Admin.click();
        //driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        FleetAverage.click();
    }

    public void clickAddClientUser()
    {
        Admin.click();
        addClientUser.click();
    }

    public void clickChangePassword()
    {
        Admin.click();
        changeAdminPassword.click();
    }

    public void clickSMSCredit()
    {
        Admin.click();
        SMSCredit.click();
    }

//Reservation

    public  void clickReservation()

    {
        ReservationLnk.click();
    }

    public  void clickCreateDutySlip()
    {
        Dispatch.click();
        createDutySlip.click();
    }

    public void clickViewDutySlip()
    {
        Dispatch.click();
        viewDutySlip.click();
    }

    public void clickCancelDutySlip()
    {
        Dispatch.click();
        cancelDutySlip.click();
    }


    public void clickCloseDutySlip()
    {
        Billing.click();
        closeDutySlip.click();
    }

    public void clickViewInvoice()
    {
        Billing.click();
        viewInvoice.click();
    }

    public void clickCancelInvoice()
    {
        Billing.click();
        cancelInvoice.click();
    }

    public void clickCompanyBilling()
    {
        Billing.click();
        companyBilling.click();
    }

    public void clickViewBill()
    {
        Billing.click();
        viewBill.click();
    }

    public void clickPaymentVoucher()
    {
        Billing.click();
        paymentVoucher.click();
    }

    public void clickBillingLedger()
    {
        Billing.click();
        billingLedger.click();
    }

    //QuickInvoice

    public void clickQuickInvoice()

    {
        quickInvoice.click();
    }



    public void clickAccount_Expense()
    {
        Account.click();
        Expense.click();
    }

    public void clickAccount_FuelConsumption()
    {
        Account.click();
        fuelConsumption.click();
    }
    public void clickAccount_Allowance()
    {
        Account.click();
        Allowance.click();
    }

    public void clickProfitAndLoss()
    {
        Account.click();
        profitAndLoss.click();
    }

    public void clickVehicleExpense()
    {
        Account.click();
        vehicleExpense.click();
    }

    public void clickAccountReports()
    {
        Account.click();
        accountReports.click();
    }

    public void clickAccountReportsExpense()
    {
        Account.click();
        accountReports.click();
        accountReportsExpense.click();
    }

    public void clickAccountReportsAllowance()
    {
        Account.click();
        accountReports.click();
        accountReportsAllowance.click();
    }

    public void clickAccountReportsFuelConsumption()
    {
        Account.click();
        accountReports.click();
        accountReportsFuelConsumption.click();
    }

    public void clickMaintenance()
    {
        Maintenance.click();
    }

    public void clickSubMaintenance()
    {
        Maintenance.click();
        subMaintenance.click();
    }

    public void clickMaintenanceVoucher()
    {
        Maintenance.click();
        maintenanceVoucher.click();
    }

    public void clickMaintenanceReports()
    {
        Maintenance.click();
        maintenanceReports.click();
    }

    public void clickSubMaintenanceReports()
    {
        Maintenance.click();
        maintenanceReports.click();
        submaintenanceReports.click();
    }

    public void clickMaintenanceVoucherReports()
    {
        Maintenance.click();
        maintenanceReports.click();
        maintenanceVoucherReports.click();
    }

    public void clickAddCompany()
    {
       Master.click();
       addCompany.click();
    }

    public void clickAddVendor()
    {
        Master.click();
        addVendor.click();
    }

    public void clickAddEditFleet()
    {
        Master.click();
        addeditFleet.click();
    }
    public void clickPackage()
    {
        Master.click();
        masterPackage.click();
    }
   /* public void clickVendorPackageMaster()
    {
        Master.click();
        vendorPackageMaster.click();
    }
*/
    public void clickPetrolPump()
    {
        Master.click();
        Add_PetrolPump.click();
    }
    public void clickAddGarage()
    {
        Master.click();
        Add_Garage.click();
    }
    public void clickReports()
    {
      Reports.click();
    }

    public void clickReservationReports()
    {
        Reports.click();
        reservationReports.click();
    }

    public void clickCancelReservationReport()
    {
        Reports.click();
        cancelReservationReport.click();
    }

    public void clickPendingReservationReport()
    {
        Reports.click();
        pendingReservationReport.click();
    }

    public void clickPendingDutySlipReport()
    {
        Reports.click();
        pendingDutySlipReport.click();

    }

    public void clickCancelDutySlipReport()
    {
        Reports.click();
        cancelDutySlipReport.click();
    }

    public void clickSales()
    {
        Reports.click();
        salesReport.click();
    }

    public void clickOwnedFleetSaleReport()
    {
        Reports.click();
        ownedFleetSaleReport.click();
    }

    public void clickVendorFleetSaleReport()
    {
        Reports.click();
        vendorFleetSaleReport.click();
    }

    public void clickCancelledInvoiceReport()
    {
        Reports.click();
        cancelledInvoiceReport.click();
    }

    public void clickCompanyBillingReport()
    {
        Reports.click();
        companyBillingReport.click();
    }

    public void clickPaymentVoucherReport()
    {
        Reports.click();
        paymentVoucherReport.click();
    }

    public void clickDriverDutyReport()
    {
        Reports.click();
        driverDutyReport.click();
    }


}
