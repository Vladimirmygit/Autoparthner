import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(JUnitParamsRunner.class)
public class FilterItemsParameterizedTests extends BaseTest {
    CatalogPage catalogPage = new CatalogPage();
    OrderPage orderPage = new OrderPage();
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    @Test
    @DisplayName("Проверка функционала Фильтра")
    @Description("Проверка возможности отфильтровать товары по быстрому выбору)")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkSalesSort(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        catalogPage.openCatalogPageTyres();
        orderPage.clickQuickFilterFirstLevelButton();
        orderPage.clickQuickFilterSecondLevelButtonAndGetText();
        orderPage.checkQuickFilterResult();
    }
}
