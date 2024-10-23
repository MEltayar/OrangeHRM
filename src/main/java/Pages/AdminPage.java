package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminPage {

    SHAFT.GUI.WebDriver driver;


    public AdminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By numberOfRecordsFoundText = By.xpath("//span[contains(., 'Records Found')]");
    By addButton = By.xpath("//button[contains(.,'Add')]");
    By userNameLocator = By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@class='oxd-input oxd-input--active']");
    By searchButton = By.cssSelector("[type='submit']");
    By trashButton = By.xpath("//i[contains(@class, 'bi-trash')]");
    By confirmDeleteButton = By.xpath("//button[contains(@class, 'oxd-button--medium') and contains(@class, 'oxd-button--label-danger')]");

    private static int numberOfRecordsBeforeAddingUser;
    private static int numberOfRecordsAfterAddingUser;
    private static int numberOfRecordsAfterDeletingUser;

    //Methods

    @Step("Get the Number of requests found before adding user")
    public AdminPage getNumberOfRecordsFoundBeforeAddingUser(){
        String recordsFoundText = driver.element().getText(numberOfRecordsFoundText);
        numberOfRecordsBeforeAddingUser = Integer.parseInt(recordsFoundText.replaceAll("\\D+", ""));
        System.out.println(numberOfRecordsBeforeAddingUser);
        return this;
    }

    @Step("Get the Number of requests found After adding user")
    public AdminPage getNumberOfRecordsFoundAfterAddingUser(){
        String recordsFoundText = driver.element().getText(numberOfRecordsFoundText);
        numberOfRecordsAfterAddingUser = Integer.parseInt(recordsFoundText.replaceAll("\\D+", ""));
        System.out.println(numberOfRecordsAfterAddingUser);
        return this;
    }
    @Step("Get the Number of requests found After deleting user")
    public AdminPage getNumberOfRecordsFoundAfterDeletingUser(){
        String recordsFoundText = driver.element().getText(numberOfRecordsFoundText);
        numberOfRecordsAfterDeletingUser = Integer.parseInt(recordsFoundText.replaceAll("\\D+", ""));
        System.out.println(numberOfRecordsAfterDeletingUser);
        return this;
    }

    @Step("Click on the Add button")
    public AddUserPage clickOnAddButton()
    {
        driver.element().click(addButton);
        return new AddUserPage(driver);
    }


    @Step("Search with user name")
    public AdminPage searchWithUserName(){
        driver.element().type(userNameLocator,new AddUserPage(driver).enteredUserName)
                .and().click(searchButton);
        return this;
    }

    @Step("Delete user")
    public AdminPage deleteUser(){
        driver.element().click(trashButton)
                .and().click(confirmDeleteButton);
        return this;
    }


    //Assertion
    @Step("Verify That Number Of Records Increased 1  after Adding user")
    public AdminPage verifyThatNumberOfRecordsIncreased1()

    {
        Assert.assertEquals(numberOfRecordsAfterAddingUser,numberOfRecordsBeforeAddingUser+1);
        return this;
    }
    @Step("Verify That Number Of Records decreased by 1  after deleting user")
    public AdminPage verifyThatNumberOfRecordsDecreasedBy1()
    {
        Assert.assertEquals(numberOfRecordsAfterDeletingUser,numberOfRecordsAfterAddingUser-1);
        return this;
    }
}
