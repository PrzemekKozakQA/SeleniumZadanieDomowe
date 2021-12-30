package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void submitRegistration() {
        registerButton.click();
    }
}
