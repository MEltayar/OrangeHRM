package Tests.E2EScenarios;

import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyNumberOfRequestsIsChanged {

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
    public void verifyNumberOfRequestsIsChangedWheneverMakAnyChange() throws InterruptedException {
        new LoginPage(driver)
                .loginWithUserCredentials("Admin","admin123")
                .clickOnAdminButton()
                .getNumberOfRecordsFoundBeforeAddingUser()
                .clickOnAddButton()
                .fillUserDetails()
                .clickOnSave()
                .getNumberOfRecordsFoundAfterAddingUser()
                .verifyThatNumberOfRecordsIncreased1()
                .searchWithUserName()
                .deleteUser()
                .verifyThatNumberOfRecordsDecreasedBy1();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
