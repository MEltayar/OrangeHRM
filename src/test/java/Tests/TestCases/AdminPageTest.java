package Tests.TestCases;

import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTest {

    SHAFT.GUI.WebDriver driver;

        String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        @BeforeMethod
        public void setDriver(){
            driver = new SHAFT.GUI.WebDriver();
            driver.browser().navigateToURL(baseURL);
        }

        @Description("When User Enter Valid Credentials, User is Logged in")
        @Story("Login")
        @Severity(SeverityLevel.CRITICAL)
        @Test
        public void numberOfRecords(){
            new LoginPage(driver)
                    .loginWithUserCredentials("Admin","admin123")
                    .clickOnAdminButton()
                    .getNumberOfRecordsFoundBeforeAddingUser();
        }

        @AfterMethod
        public void tearDown(){
            //driver.quit();
        }
}
