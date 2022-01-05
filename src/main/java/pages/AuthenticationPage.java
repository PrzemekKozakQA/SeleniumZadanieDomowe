package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.clickWhenVisible;
import static utils.MethodUtils.typeInInput;

public class AuthenticationPage extends BasePage {
    @FindBy(id = "email_create")
    WebElement createAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreateAccountButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountWithEmail(String email) {
        typeInInput(createAccountEmailInput, email);
        clickWhenVisible(submitCreateAccountButton);
    }
}
