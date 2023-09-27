import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
@RunWith(JUnitParamsRunner.class)
public class FormTests extends BaseTest {
    Form form = new Form();
    HomePage homePage = new HomePage();
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    @Test
    @DisplayName("Проверка заказа звонка с валидным номером")
    @Description("Проверка возможности заказа звонка с валидным номером телефона")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void testOrderCallWithValidData(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        homePage.openHomePage();
        homePage.clickOrderCallButton();
        form.enterValidDataAndSubmit(TestData.VALID_PHONE_NUMBER);
        form.clickSendButton();
        $(byText("Заявка успешно отправлена")).shouldHave(Condition.text("Заявка успешно отправлена"));

        $(".btn-close").click();
        // Проверка, что текст исчез
        $(".success-message").shouldNotBe(Condition.visible);
    }

    @Test
    @DisplayName("Проверка заказа звонка с невалидным номером")
    @Description("Проверка обработки заказа звонка с невалидными данными")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void testFormCallInvalidData(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        homePage.openHomePage();
        homePage.clickOrderCallButton();
        form.enterInvalidDataAndSubmit(TestData.INVALID_PHONE_NUMBER);
        form.clickSendButton();
        $(byText("Заявка успешно отправлена")).shouldNotBe(Condition.visible);
        $(".btn-close").click();
        $(".error-message").shouldNotBe(Condition.visible);
    }

    @Test
    @DisplayName("Проверка формы помощи на странице \"Шины\"")
    @Description("Проверка функциональности формы помощи на странице каталога \"Шины\"")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void testFormHelpYouCatalog(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        homePage.openHomePage();
        homePage.clickButtonCatalogTyres();
        form.scrollFormHelpYou();
        homePage.enterValidDataInFormHelpYou();
        form.clickConsentButton();
        form.clickButtonSendHelp();
        sleep(2000);
        form.checkFormHelpYou();
    }

    @Test
    @DisplayName("Проверка формы помощи на главной странице")
    @Description("Проверка функциональности формы помощи на главной странице")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void testFormHelpYou(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        homePage.openHomePage();
        homePage.scrollToFormHelpYou();
        homePage.enterValidDataInFormHelpYou();
        Selenide.sleep(1000);
        form.clickButtonSendHelp();
        sleep(2000);
        form.checkMainFormHelpYou();
    }

    @Test
    @DisplayName("Проверка функциональности чат-бота")
    @Description("Проверка функциональности чат-бота")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void testFormChat(String resolution) {
        WebDriver driver = webDriverFactory.createDriver(resolution);
        homePage.openHomePage();
        homePage.clickButtonChatCarrotQuest();
        form.enterTextCarrotQuest();
        form.clickSendMessageCarrotQuestButton();
    }
}
