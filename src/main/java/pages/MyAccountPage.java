package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.awaitUntilElementIsDisplayed;
import static utils.MethodUtils.isWebElementDisplayed;

public class MyAccountPage extends BasePage {
    @FindBy(className = "info-account")
    WebElement welcomeToAccountInfo;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomeMessageDisplayed() {
        awaitUntilElementIsDisplayed(welcomeToAccountInfo);
        return isWebElementDisplayed(welcomeToAccountInfo);
    }
}
