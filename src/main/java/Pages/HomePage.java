package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By adminButton = By.xpath("(//span[contains(.,\"Admin\")])[1]");


    //Methods
    public AdminPage clickOnAdminButton(){
        driver.element().click(adminButton);
        return new AdminPage(driver);
    }
}
