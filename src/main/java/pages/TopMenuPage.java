package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.clickWhenAvailable;
import static utils.MethodUtils.typeInInput;

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
        clickWhenAvailable(womenCategory);
    }

    public void searchItemByName(String itemName) {
        typeInInput(searchingInput, itemName);
        clickWhenAvailable(submitSearchButton);
    }

    public void clickSignIn() {
        clickWhenAvailable(signInButton);
    }
}
