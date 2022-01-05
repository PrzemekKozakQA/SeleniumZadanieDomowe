package tests;

import org.junit.jupiter.api.Test;
import pages.ItemsListPage;
import pages.TopMenuPage;
import utils.SearchItemUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.SearchItemUtils.*;


public class SearchItemTest extends BaseTest {
    @Test
    public void shouldSeeItemsWithSearchedNameAndPrice() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        ItemsListPage itemsListPage = new ItemsListPage(driver);
        //Act
        topMenuPage.searchItemByName(ITEM_TO_SEARCH);
        boolean isAllProductsContainSearchedName = itemsListPage
                .getItemsNames()
                .stream()
                .allMatch(name -> name.toLowerCase().contains(ITEM_TO_SEARCH.toLowerCase()));
        //Assert
        assertThat(itemsListPage.isItemsCounterDisplayed()).isTrue();
        assertThat(itemsListPage.getItemsList()).isNotEmpty();
        assertThat(isAllProductsContainSearchedName).isTrue();
        assertThat(itemsListPage.isAllItemsPricesDisplayed()).isTrue();
    }
}
