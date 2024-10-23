package Tests.TestCases;

import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest
{
    String homePageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    //Driver
    SHAFT.GUI.WebDriver driver;

    public LoginPageTest(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod
    public void setDriver(){
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(baseURL);
    }

    @Description("When User Enter Valid Credentials, User is Logged in")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userLoginWithValidCredentials(){
        new LoginPage(driver).loginWithUserCredentials("Admin","admin123");
    }

    //Assertion method --> Check if user logged in successfully
    public void assertThatUserLoggedIn(){
        String currentURL = driver.browser().getCurrentURL();
        Assert.assertEquals(currentURL,homePageURL);
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
