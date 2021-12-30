package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MethodUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsListPage extends BasePage {
    @FindBy(xpath = "//div[@class='right-block']//span[@class='price product-price']")
    List<WebElement> itemsPrices;

    @FindBy(className = "product-count")
    WebElement itemsCounter;

    @FindBy(className = "product-container")
    List<WebElement> itemsList;

    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name']")
    List<WebElement> itemsNamesWebElementList;

    public ItemsListPage(WebDriver driver) {
        super(driver);
    }

    public List<BigDecimal> getItemsPricesList() {
        itemsPrices.forEach(el -> wait.until(ExpectedConditions.visibilityOf(el)));
        return itemsPrices.stream()
                .map(WebElement::getText)
                .map(el -> el.replaceAll("[^0-9.]", ""))
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }

    public Boolean isItemsCounterDisplayed() {
        return MethodUtils.isWebElementDisplayed(itemsCounter, wait);
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public List<String> getItemsNames() {
        return itemsNamesWebElementList.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public Boolean isAllItemsPricesDisplayed() {
        return itemsList.stream()
                .allMatch(price -> MethodUtils.isWebElementDisplayed(price, wait));
    }
}
