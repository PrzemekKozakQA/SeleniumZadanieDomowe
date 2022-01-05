package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.MethodUtils.awaitUntilElementIsDisplayed;

@Getter
public class WomenCategoryPage extends BasePage {
    private ItemsListPage itemsListPage;
    @FindBy(className = "cat-name")
    WebElement categoryName;

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
        itemsListPage = new ItemsListPage(driver);
    }

    public String getCategoryName() {
        awaitUntilElementIsDisplayed(categoryName);
        return categoryName.getText();
    }
}
