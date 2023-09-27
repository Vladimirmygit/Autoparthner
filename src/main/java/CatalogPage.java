import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;



import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage extends BaseTest {
    private Locators locators = new Locators();


    @Step("Открываем страницу каталога Шины")
    public void openCatalogPageTyres() {
        open("tyres");
    }

    @Step("Кликаем на кнопку сортировки на странице каталога с шинами")
    public void clickTyresSortButton() {
        SelenideElement Element = $(locators.getClickTyresSortButton());
        Element.shouldBe(Condition.visible).click();
    }

    @Step("Кликаем на кнопку сортировки на странице каталога с дисками")
    public void clickDiskSortButton() {
        SelenideElement Element = $(locators.getClickDisksSortButton());
        Element.shouldBe(Condition.visible).click();
    }

    @Step("Кликаем на кнопку сортировки на странице каталога с аккумуляторами")
    public void clickAccumSortButton() {
        SelenideElement Element = $(locators.getClickAccumSortButton());
        Element.shouldBe(Condition.visible).click();
    }

    @Step("Выбираем сортировку товаров \"Сначала с акциями\"")
    public void clickSortSalesButton() {
        SelenideElement Element = $(locators.getClickSalesSortButton());
        Element.shouldBe(Condition.visible).click();

    }

    @Step("Открываем страницу каталога Дисков")
    public void openCatalogPageDisks() {
        open("disks");
    }

    @Step("Выбираем сортировку товаров \"Сначала популярные\"")
    public void clickPopularSortButton() {
        SelenideElement Element = $(locators.getClickPopularSortButton());
        Element.shouldBe(Condition.visible).click();
    }

    @Step("Открываем страницу каталога Аккумуляторов")
    public void openCatalogPageAccum() {
        open("accums");
    }

    @Step("Выбираем сортировку товаров \"Сначала дешевые\"")
    public void clickCheapSortButton() {
        SelenideElement Element = $(locators.getClickCheapSortButton());
        Element.shouldBe(Condition.visible).click();
    }

    @Step("Получаем список цен товаров")
    public List<Double> getProductPrices() {
        ElementsCollection priceElements = $$(locators.getCatalogItemPrice());
        List<Double> prices = new ArrayList<>();

        for (SelenideElement element : priceElements) {
            String priceText = element.getText().replaceAll("[^\\d.]", ""); // Извлекаем числовое значение цены
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        return prices;
    }

    @Step("Проверяем, что товары расположены в порядке возрастания или могут быть равны")
    public void checkPricesAscendingOrEqual() {
        List<Double> prices = getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            double currentPrice = prices.get(i);
            double nextPrice = prices.get(i + 1);

            // Проверяем, что текущая цена меньше или равна следующей
            boolean isAscendingOrEqual = currentPrice <= nextPrice;
            Assert.assertTrue("Цены товаров не расположены в порядке возрастания или равны", isAscendingOrEqual);
        }
    }

    @Step("Нажимаем на кнопку добавить в избранное")
    public void clickFavoriteButton() {
        SelenideElement element = $(locators.getFirstItemLocator());
        element.scrollTo();
        element.hover();
        Selenide.sleep(1000);
        SelenideElement element1 = $(locators.getCatalogItemPrice());
        element1.hover();
        SelenideElement element2 = $(locators.getCatalogFavoriteItem());
        element2.shouldBe(Condition.visible).click();
    }

    @Step("Нажимаем на кнопку добавить в сравнение")
    public void clickComparisonButton() {
        SelenideElement Element = $(locators.getFirstItemLocator());
        Element.scrollTo();
        Element.hover();
        Selenide.sleep(1000);
        SelenideElement element1 = $(locators.getCatalogItemPrice());
        element1.hover();
        SelenideElement Element2 = $(locators.getCatalogCompareItem());
        Element2.shouldBe(Condition.visible).click();
    }
    @Step("Нажимаем на кнопку товары в сравнении")
    public void clickAllComparisonItemsButton() {
        SelenideElement Element = $(locators.getCatalogAllCompareItems());
        Element.scrollTo();
        Element.shouldBe(Condition.visible).click();

    }
    @Step("Нажимаем на кнопку товары в избранном")
    public void clickAllFavoriteItemsButton() {
        SelenideElement Element = $(locators.getCatalogAllFavoriteItems());
        Element.scrollTo();
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Проверяем, что в сравнении товаров есть товар")
    public void checkItemsInCompose() {
        SelenideElement Element = $(locators.getFirstItemLocator());
        Element.shouldBe(Condition.exist);
    }
    @Step("Проверяем, что в избранном есть товар")
    public void checkItemsInFavorite() {
        SelenideElement Element = $(locators.getFirstItemLocator());
        Element.shouldBe(Condition.visible);
    }
        @Step("Нажимаем на кнопку \"Удалить текущий список\"")
    public void clickDeleteCompareButton() {
        SelenideElement Element = $(locators.getCatalogDeleteCompareButton());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Проверка наличия текста \"В списке сравнения нет товаров\"")
    public void checkVisibilityEmptyCompareText() {
        SelenideElement Element = $(locators.getTextEmptyItems());
        Element.shouldHave(Condition.text("В списке сравнения нет товаров"));
    }
}