package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Hello world!
 *
 */
public class LoginPage
{

    //Locators
    By userNameLocator = By.name("username");
    By passwordLocator = By.name("password");
    By loginButtonLocator = By.cssSelector("button[type=submit]");

    //Driver
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Enter UserName")
    public LoginPage enterUserName(String userName){
        driver.element().type(userNameLocator,userName);
        return this;
    }

    @Step("Enter Password")
    public LoginPage enterPassword(String password){
        driver.element().type(passwordLocator,password);
        return this;
    }

    @Step("Click On Login Button")
    public HomePage clickOnLoginButton(){
        driver.element().click(loginButtonLocator);
        return new HomePage(driver);
    }

    @Step("Login With User Credentials")
    public HomePage loginWithUserCredentials(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
        return new HomePage(driver);
    }
}
