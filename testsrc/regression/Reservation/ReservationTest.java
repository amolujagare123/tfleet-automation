/*
package regression.Reservation;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.listners.NXGTestListner;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.pages.Menu;
import com.tfleet.pages.Reservation.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

*/
/**
 * Created by vaishali on 4/19/2015.
 *//*


@Listeners({NXGTestListner.class})

public class ReservationTest {

    {
        System.setProperty("KIRWA.reporter.config", "KIRWA.properties");
    }


    public static WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\Amol\\Tfleet-Activities\\automation\\tfleet\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        NXGReports.setWebDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }



    @Test
    public void Check_NewReservation() throws Throwable {
        NXGReports.setAuthorInfo("Amol Ujagare", "07/06/2015", "0.10");

        LoginPage loginPage = new LoginPage(driver, "http://test.tfleet.in/login.aspx");
        DashBoard dashBoard = loginPage.Login("tcraft@Khushal", "tcraft123");

         Menu menu = new Menu(driver);
        menu.clickReservation();
        Reservation reservation = new Reservation(driver);
        reservation.setTextAddress("Katraj,pune");
        reservation.setSelectCity("pune");
        reservation.setTxtNameofGuest("Amol");
        reservation.setTxtMoblile("9975709708");
        reservation.setTxtEmail("amolujagare@gmail.com");
        reservation.setSelectFleetCategory("ECONOMY");
        // driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        Thread.sleep(5000);
        reservation.setSelectFleetType("TATA INDICA");
        Thread.sleep(5000);
        reservation.setSelectPackage("8 hr 80 km");

        reservation.setDate("23/12/2015");
        reservation.clickSave();
        String alertText=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

try {
    assertEquals("Reservation Added Successfully1", alertText, "Reservation Unsuccessful");
    NXGReports.addStep("to test reservation page", "Reservation should be added", "Reservation is added", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.DESKTOP));

}
catch(Throwable e)
{
    NXGReports.addStep("to test reservation page", "Reservation should be added", e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.DESKTOP));
 throw e;
}


        //driver.close();
    }


   */
/* @Test
    public void testAlert() {
        driver.get("file:///D:/selenium/test-project/test.html");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        String name=driver.findElement(By.id("testText")).getText();
        assertEquals(name,"Amol","Strings are not equal");

    }*//*


    @Test
    public void testMsSql()
    {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://red.mysitehosted.com:1433;" +
                "databaseName=T_FLEET;user=tcraft;password=tcraft123";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT  * FROM FL_RESERVATION where Rep_Guest='Amol'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("PNR_No") + " " + rs.getString("Rep_Guest"));
            }
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/
