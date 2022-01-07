package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.TopMenuPage;
import pages.WomenCategoryPage;

public class WomenCategoryTest extends BaseTest {
    @Test
    public void shouldEveryItemInWomenCategoryHasPriceGreaterThanZero() {
        //Arrange
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        WomenCategoryPage womenCategoryPage = new WomenCategoryPage(driver);
        //Act
        topMenuPage.clickOnWomenCategoryLink();
        //Assert
        Assertions.assertThat(womenCategoryPage.getCategoryName().toLowerCase().contains("women")).isTrue();
        Assertions.assertThat(womenCategoryPage.getItemsListPage().isAllPricesAboveZero()).isTrue();
    }
}