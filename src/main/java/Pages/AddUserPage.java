package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.Name;
import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class AddUserPage {

    SHAFT.GUI.WebDriver driver;

    public AddUserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By userRoleDropDownMenu = By.xpath("(//label[text()='User Role']/ancestor::div[contains(@class, 'oxd-input-group')]//div[contains(@class, 'oxd-select-text')])[1]");
    By statusDropDownMenu = By.xpath("((//label)[text()='Status']/ancestor::div[contains(@class, 'oxd-input-group')]//div[contains(@class, 'oxd-select-text')])[1]");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameListBox = By.xpath("//div[@role='listbox']");
    By userNameLocator = By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@class='oxd-input oxd-input--active']");
    By passwordLocator = By.xpath("//label[text()='Password']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@type='password']");
    By confirmPasswordLocator = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@type='password']");
    By saveButton = By.xpath("//button[@type='submit']");
    By userNameInTheUpperRightCornerOfScreen = By.xpath("//p[contains(@class,'oxd-userdropdown-name')]");
    static String enteredUserName;

    //Methods
    @Step("Select Role")
    public AddUserPage selectRoleFromDropDownMenu()
    {
       driver.element().select(userRoleDropDownMenu,"Admin");
       return this;

    } @Step("Select Status")
    public AddUserPage selectStatusFromDropDownMenu()
    {
       driver.element().select(statusDropDownMenu,"Enabled");
       return this;
    }

    @Step("Enter Employee Name")
    public AddUserPage enterEmployeeName() throws InterruptedException {
        By selectFirstElement = By.xpath("//div[@role='option']");
        driver.element().type(employeeName,driver.element().getText(userNameInTheUpperRightCornerOfScreen));
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectFirstElement));
        driver.element().click(selectFirstElement);
       return this;

    }

    @Step("Enter User Name")
    public AddUserPage enterUserName()
    {
        String currentTime = String.valueOf(System.currentTimeMillis());
       driver.element().type(userNameLocator, ("user name" + currentTime))
               .and().click(passwordLocator);
       return this;
    }

    @Step("Get user name")
    public String saveUserNameIntoText()
    {
        enteredUserName = driver.element().getText(userNameLocator);
        return enteredUserName;
    }

    @Step("Enter Password")
    public AddUserPage enterPassword()
    {
       driver.element().type(passwordLocator, "t1234567");
       return this;
    }

    @Step("Confirm Password")
    public AddUserPage confirmPassword()
    {
       driver.element().type(confirmPasswordLocator, "t1234567");
       return this;
    }

    @Step("Fill User Details")
    public AddUserPage fillUserDetails() throws InterruptedException {
        selectRoleFromDropDownMenu();
        selectStatusFromDropDownMenu();
        enterEmployeeName();
        enterUserName();
        saveUserNameIntoText();
        enterPassword();
        confirmPassword();
        return this;
    }

    @Step("Click On Save Button")
    public AdminPage clickOnSave()
    {
        driver.element().click(saveButton);
        return new AdminPage(driver);
    }


}

