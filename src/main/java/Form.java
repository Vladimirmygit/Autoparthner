import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class Form extends BaseTest {
    private Locators locators = new Locators();
    @Step("Ввод Валидных данных в поле с номером телефона и отправка формы")
    public void enterValidDataAndSubmit(String phoneNumber) {
        SelenideElement phoneInput = $(locators.getPhoneInput());
        phoneInput.setValue(phoneNumber);
    }

    @Step("Ввод Невалидных данных в поле с номером телефона и отправка формы")
    public void enterInvalidDataAndSubmit(String invalidData) {
        SelenideElement phoneInput = $(locators.getPhoneInput());
        phoneInput.setValue(invalidData);
    }

    @Step("Клик на кнопку Отправить")
    public void clickSendButton() {
        $(locators.getSendButton()).click();
    }
    @Step("Клик на кнопку Отправить")
    public void clickButtonSendHelp() {
        try {
            Selenide.$(locators.getSecondaryButton()).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Ошибка: Кнопка не найдена на главной странице.");
            throw e; // Повторно бросаем исключение, чтобы сигнализировать об ошибке
        }
    }

    @Step("Сообщение об успешной отправке отображается")
    public void checkMainFormHelpYou() {
        String actualText = $(locators.getMainFormLocator()).getText();
        String expectedText = "Отправлено\n" +
                "Ваше сообщение успешно отправлено. Наш менеджер свяжется с Вами в рабочее время.";
        assertEquals(expectedText, actualText);
    }
    @Step("Сообщение об успешной отправке отображается")
    public void checkFormHelpYou() {
        String actualText = $(locators.getFormLocator()).getText();
        String expectedText = "Отправлено\n" +
                "Ваше сообщение успешно отправлено. Наш менеджер свяжется с Вами в рабочее время.";
        assertEquals(expectedText, actualText);
    }

    @Step("Скролим до формы Вам помочь вводим")
    public void scrollFormHelpYou() {
        SelenideElement scrollToElement = $(locators.getHelpFormLocator());
        scrollToElement.scrollTo();
    }
    @Step("Нажимаем на кнопку согласия с обработкой персональных данных")
    public void clickConsentButton() {
        SelenideElement Element = $(locators.getConsentButtonLocator());
        Element.shouldBe(Condition.visible).click();
    }
    @Step("Ввести текст в форму carrot quest и отправить его")
    public void enterTextCarrotQuest() {
        String iframeNameOrId = "carrot-messenger-frame";
        Selenide.switchTo().frame(iframeNameOrId);
        SelenideElement Element = $(locators.getCarrotQuestInputLocator());
        Element.shouldBe(Condition.visible).setValue("Тестовый текст 123,.! Тестовый текст 123,.! Тестовый текст 123,.! Тестовый текст 123,.! Тестовый текст 123,.! Тестовый текст 123,.!");
    }
    @Step("Нажимаем на кнопку отправки текста в фомре carrot quest")
    public void clickSendMessageCarrotQuestButton() {
        SelenideElement Element = $(locators.getClickSendMessageCarrotQuestButton());
        Element.shouldBe(Condition.visible).click();
    }
}