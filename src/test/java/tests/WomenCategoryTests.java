package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.TopMenuPage;
import pages.ItemsListPage;

import java.math.BigDecimal;

public class WomenCategoryTests extends BaseTesty {
    @Test
    public void shouldEveryItemInWomenCategoryHasPriceGreaterThanZero() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        ItemsListPage itemsListPage = new ItemsListPage(driver);
        //Act
        topMenuPage.clickOnWomenCategoryLink();
        boolean isAllPricesAboveZero = itemsListPage
                .getItemsPricesList()
                .stream()
                .anyMatch(price -> price.compareTo(BigDecimal.ZERO) > 0);
        //Assert
        Assertions.assertThat(isAllPricesAboveZero).isTrue();
    }
}
