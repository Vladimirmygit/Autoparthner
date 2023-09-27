import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(JUnitParamsRunner.class)
public class CatalogTests extends BaseTest {
    CatalogPage catalogPage = new CatalogPage();
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    @Test
    @DisplayName("Проверка функционала сортировки")
    @Description("Проверка возможности отсортировать товары Сначала с акциями - все товары с акциями)")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkSalesSort(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageTyres();
        catalogPage.clickTyresSortButton();
        catalogPage.clickSortSalesButton();
    }
    @Test
    @DisplayName("Проверка функционала сортировки")
    @Description("Проверка возможности отсортировать товары Сначала популярные - популярность липовая)))")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkPopularSort(String resolution) {
      //  WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageAccum();
        catalogPage.clickAccumSortButton();
        catalogPage.clickPopularSortButton();
    }
    @Test
    @DisplayName("Проверка функционала сортировки")
    @Description("Проверка возможности отсортировать товары в Сначала дешевые")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkCheapSort(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageDisks();
        catalogPage.clickDiskSortButton();
        catalogPage.clickCheapSortButton();
        catalogPage.getProductPrices();
        catalogPage.checkPricesAscendingOrEqual();
    }

    @Test
    @DisplayName("Проверка функционала сравнения")
    @Description("Проверка возможности Добавлять товары в сравнение")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkComparison(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageDisks();
        catalogPage.clickComparisonButton();
        catalogPage.clickAllComparisonItemsButton();
        catalogPage.checkItemsInCompose();
    }
    @Test
    @DisplayName("Проверка функционала сравнения")
    @Description("Проверка работы кнопки очистки списка товаров в сравнении \"Удалить текущий список\"")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkComparisonDeleteButton(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageDisks();
        catalogPage.clickComparisonButton();
        catalogPage.clickAllComparisonItemsButton();
        catalogPage.clickDeleteCompareButton();
        catalogPage.checkVisibilityEmptyCompareText();
    }


    @Test
    @DisplayName("Проверка функционала Избранное")
    @Description("Проверка возможности Добавлять товары в Избранное")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkFavorites(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageAccum();
        catalogPage.clickFavoriteButton();
        catalogPage.clickAllFavoriteItemsButton();
        catalogPage.checkItemsInFavorite();
    }
}
