import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BaseTest {
    private Locators locators = new Locators();
    String company = "Cordiant";

    @Step("Открываем главную страницу")
    public void openHomePage() {
        open("");
    }
    @Step("Открываем страницу '{pageUrl}'")
    public void openPage(String pageUrl) {
        open(pageUrl);
    }

    @Step("Проверяем, что у страницы заголовок будет '{expectedTitle}'")
    public void verifyPageTitle(String expectedTitle) {
        $("title").shouldHave(attribute("text", expectedTitle));
    }
    @Step("Кликаем на строку поиска")
    public void clickSearchLine() {
        SelenideElement Element = $(locators.getSearchLineButton());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Вводим текст в строку поиска и нажимаем enter")
    public void enterTextSearchLine(String searchText) {
        SelenideElement Element = $(locators.getSearchLineButton());
        Element.setValue(searchText);
        Selenide.sleep(1000);
        Element.pressEnter();
    }
    @Step("Берем первое название товара и сравниваем вхождения слово из поиска с названием товара")
    public void checkCompareItemNameWithSearchResults(String expectedItemName) {
        SelenideElement Element = $(locators.getFirstItemLocator());
        String fullText = Element.getText();
        String textBeforeSpace = fullText.split(" ")[0];
        Assert.assertEquals("Тексты не совпадают", expectedItemName, textBeforeSpace);


    }

    @Step("Клик по кнопке Заказать звонок")
    public void clickOrderCallButton() {
        $(byText("Заказать звонок")).click();
        $(byText("Заказать звонок")).shouldHave(Condition.text("Заказать звонок"));
    }

    @Step("Скролл до формы Вам помочь")
    public void scrollToFormHelpYou() {
        int scrollDistance = 1100; // Расстояние для прокрутки (в пикселях)

        // Выполнить JavaScript для прокрутки на указанное расстояние
        Selenide.executeJavaScript("window.scrollBy(0, arguments[0]);", scrollDistance);
    }
    @Step("Нажимаем на категорию Шины")
    public void clickButtonCatalogTyres() {
        $(locators.getCatalogTyresLocator()).click();
    }
    @Step("Ввод данных в форму Вам помочь")
    public void enterValidDataInFormHelpYou() {
        SelenideElement modelInput = $(byName("HelpForm[auto]"));
        modelInput.setValue("Skoda");
        SelenideElement phoneInput = $(byName("HelpForm[phone]"));
        phoneInput.setValue("9999999999");
    }

    @Step("Нажимаем на кнопку виджета Carrot Quest")
    public void clickButtonChatCarrotQuest() {
        String iframeNameOrId = "carrot-messenger-bubble";
        Selenide.switchTo().frame(iframeNameOrId);
        SelenideElement Element = $(By.xpath("//div[@id='carrotquest-collapsed-text-text-cont']"));
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Нажимаем на категорию Диски с ID: {categoryId}")
    public void clickButtonCatalogCategory(String categoryId) {
        By categoryLocator = locators.getCatalogCategoryByIdLocator(categoryId);
        SelenideElement element = $(categoryLocator);
        element.scrollIntoView(true);
        Selenide.sleep(1500);
        element.shouldBe(Condition.visible).click();
    }
}