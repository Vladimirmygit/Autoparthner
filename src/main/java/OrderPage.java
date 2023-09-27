import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage {
    private Locators locators = new Locators();
    private String text1;
    @Step("Нажимаем на первый товар в листинге")
    public void clickFirstItem() {
        SelenideElement Element = $(locators.getFirstItemLocator());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Нажимаем на кнопку \"Купить в 1 клик\"")
    public void clickButtonBuyOneClick() {
        SelenideElement Element = $(locators.getBuyOneClickButtonLocator());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Вводим валидные данные в поле Контактное лицо")
    public void enterNameBuyOneClick(String name) {
        SelenideElement Element = $(locators.getNameInputLocator());
        Element.setValue(name);
    }
    @Step("Вводим валидные данные в поле Телефон")
    public void enterPhoneBuyOneClick(String phoneNumber) {
        SelenideElement Element = $(locators.getPhoneInputBuyOneClickLocator());
        Element.setValue(phoneNumber);
    }

    @Step("Нажимаем на кнопку \"Отправить\"")
    public void clickButtonSendOrder() {
        SelenideElement Element = $(locators.getSendOrderButton());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Проверка появления уведомления \"Успешный заказ\"")
    public void checkNotificationSuccessOrder() {
        SelenideElement element = $(locators.getSuccessNotificationLocator());
        element.shouldHave(locators.getSuccessNotificationCondition());

    }
    @Step("Клик нна кнопку \"Закрыть\"")
    public void clickButtonClose() {
        SelenideElement Element = $(locators.getCloseButtonLocator());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Клик на элемент быстрого фильтра первого уровня")
    public void clickQuickFilterFirstLevelButton() {
        SelenideElement Element = $(locators.getClickQuickFilterFirstLevelButton());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Клик на элемент быстрого фильтра второго уровня")
    public String clickQuickFilterSecondLevelButtonAndGetText() {
        SelenideElement element = $(locators.getClickQuickFilterSecondLevelButton());
        element.shouldBe(Condition.visible);
        String text1 = element.getText();
        SelenideElement element2 = $(locators.getTextQuickFilterSecondLevelButton());
        Selenide.sleep(2000);
        element2.shouldBe(Condition.visible).click();
        return text1;
    }
    @Step("Проверка соответствия выдачи быстрого фильтра")
    public void checkQuickFilterResult() {
        SelenideElement Element = $(locators.getResultQuickFilterText());
        Element.shouldBe(Condition.visible);
        String text2 = Element.getText();
        String expectedText = "Шины 135/80 R12";
        Assert.assertEquals("Текст не совпадает с ожидаемым", expectedText, text2);
    }
}