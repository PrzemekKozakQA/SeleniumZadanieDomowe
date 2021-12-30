package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuPage extends BasePage {
    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenCategory;

    @FindBy(id = "search_query_top")
    WebElement searchingInput;

    @FindBy(name = "submit_search")
    WebElement submitSearchButton;

    @FindBy(className = "login")
    WebElement signInButton;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnWomenCategoryLink() {
        womenCategory.click();
    }

    public void searchItemByName(String itemName) {
        searchingInput.sendKeys(itemName);
        submitSearchButton.click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }
}
