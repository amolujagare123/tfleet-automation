package regression.Account;

import com.tfleet.pages.DashBoard;
import com.tfleet.pages.LoginPage;
import com.tfleet.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

/**
 * Created by tct4 on 1/17/2017.
 */
public class ExpenseTest {

    WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    @BeforeClass
    public void init()
    {
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver,"http://test.tfleet.in/login.aspx");
        DashBoard dashboard=loginPage.Login("akshu.pokley@gmail.com","123");




    }
}
