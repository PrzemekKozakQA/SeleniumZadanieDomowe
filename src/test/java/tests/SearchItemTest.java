package tests;

import org.junit.jupiter.api.Test;
import pages.ItemsListPage;
import pages.TopMenuPage;

import static org.assertj.core.api.Assertions.*;

public class SearchItemTest extends BaseTesty {
    protected final String ITEM_NAME = "Blouse";

    @Test
    public void shouldSeeItemsWithSearchedNameAndPrice() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        ItemsListPage itemsListPage = new ItemsListPage(driver);
        //Act
        topMenuPage.searchItemByName(ITEM_NAME);
        boolean isAllProductsContainSearchedName = itemsListPage
                .getItemsNames()
                .stream()
                .allMatch(name -> name.toLowerCase().contains(ITEM_NAME.toLowerCase()));
        //Assert
        assertThat(itemsListPage.isItemsCounterDisplayed()).isTrue();
        assertThat(itemsListPage.getItemsList()).isNotEmpty();
        assertThat(isAllProductsContainSearchedName).isTrue();
        assertThat(itemsListPage.isAllItemsPricesDisplayed()).isTrue();
    }
}
