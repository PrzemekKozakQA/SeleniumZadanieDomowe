package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationPage extends BasePage {

    @FindBy(id = "email_create")
    WebElement createAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreateAccountButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountWithEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(createAccountEmailInput));
        createAccountEmailInput.sendKeys(email);
        submitCreateAccountButton.click();
    }
}
