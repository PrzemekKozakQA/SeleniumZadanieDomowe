package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.clickWhenVisible;

@Getter
public class CreateAccountPage extends BasePage {
    PersonalInformationPage personalInformationPage;
    AddressPage addressPage;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        addressPage = new AddressPage(driver);
    }

    public void submitRegistration() {
        clickWhenVisible(registerButton, wait);
    }
}
