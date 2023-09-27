import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class Locators {
    // Локатор поля для ввода номера телефона в форме обратной связи
    public By getPhoneInput() {
        return By.name("CallbackForm[phone]");
    }

    // Локатор кнопки "Отправить" в форме обратной связи
    public By getSendButton() {
        return By.xpath(".//button[text()='Отправить']");
    }

    // Локатор вспомогательной кнопки
    public By getSecondaryButton() {
        return By.xpath("//button[@class='btn btn-lg btn-secondary']");
    }

    // Локатор формы с сообщением об успешной отправке (главная страница)
    public By getMainFormLocator() {
        return By.xpath("//*[@id=\"w115\"]");
    }

    // Локатор формы с сообщением об успешной отправке
    public By getFormLocator() {
        return By.xpath("//*[@id=\"w12\"]");
    }

    // Локатор формы "Вам помочь"
    public By getHelpFormLocator() {
        return By.xpath("//form[@class='section-margin widget-help-form style-red size-md']");
    }

    // Локатор кнопки согласия с обработкой персональных данных
    public By getConsentButtonLocator() {
        return By.xpath("//button[@class='up-cookwarn__btn']");
    }

    // Локатор поля ввода для Carrot Quest
    public By getCarrotQuestInputLocator() {
        return By.xpath("//*[@id=\"opened-textfield\"]");
    }

    // Локатор категории "Шины"
    public By getCatalogTyresLocator() {
        return By.xpath("//a[@class='categ tyres']");
    }

    // Локатор для категории по её ID
    public By getCatalogCategoryByIdLocator(String categoryId) {
        return By.xpath("//a[@class='categ " + categoryId + "']");
    }
    // Локатор первого товара в листинге
    public By getFirstItemLocator() {
        return By.xpath("//a[@class='name'][1]");
    }

    // Локатор кнопки "Купить в 1 клик"
    public By getBuyOneClickButtonLocator() {
        return By.xpath("//button[@class='btn btn-lg btn-secondary widget-quick-buy-button']");
    }

    // Локатор поля "Контактное лицо" при покупке в 1 клик
    public By getNameInputLocator() {
        return By.xpath("//input[@id='quickbuyform-name']");
    }

    // Локатор кнопки "Отправить" при покупке в 1 клик
    public By getSendOrderButton() {
        return By.xpath("(//button[@type='submit' and contains(@class, 'btn btn-primary')])[2]\n");
    }

    // Локатор поля "Телефон" при покупке в 1 клик
    public By getPhoneInputBuyOneClickLocator() {
        return By.xpath("//input[@id='quickbuyform-phone']");
    }

    // Локатор уведомления об успешном заказе
    public By getSuccessNotificationLocator() {
        return By.xpath("/html/body/section/div/div/div[1]/div");
    }

    // Условие для проверки уведомления об успешном заказе
    public Condition getSuccessNotificationCondition() {
        return Condition.text("Успешный заказ");
    }

    // Локатор кнопки "Закрыть" у уведомления
    public By getCloseButtonLocator() {
        return By.xpath("/html/body/section/div/div/div[3]/button");
    }

    // Локатор поисковой строки
    public By getSearchLineButton() {
        return By.xpath("//input[@name='search']");
    }

    // Локатор кнопки сортировки на странице с аккумуляторами
    public By getClickAccumSortButton() {
        return By.xpath("//a[@class='value nav-item nav-link dropdown-toggle style-accums']");
    }
    // Локатор кнопки сортировки на странице с дисками
    public By getClickDisksSortButton() {
        return By.xpath("//a[@class='value nav-item nav-link dropdown-toggle style-disks']");
    }
    // Локатор кнопки сортировки на странице с шинами
    public By getClickTyresSortButton() {
        return By.xpath("//a[@class='value nav-item nav-link dropdown-toggle style-tyres']");
    }
    // Локатор кнопки сортировки Сначала с акциями
    public By getClickSalesSortButton() {
            return By.xpath("//*[@id=\"w13\"]/nav/div[2]/div/a[2]");
    }

    // Локатор кнопки сортировки Сначала популярные
     public By getClickPopularSortButton() {
        return By.xpath("//*[@id=\"w10\"]/nav/div[2]/div/a[1]");
    }

    // Локатор кнопки сортировки Сначала дешевые
    public By getClickCheapSortButton() {
        return By.xpath("//*[@id=\"w15\"]/nav/div[2]/div/a[3]");
    }

    // Локатор цены товара в каталоге
    public By getCatalogItemPrice() {
        return By.xpath("//div[@class='price']");
    }

    // Локатор кнопки добавить в избранное в каталоге
    public By getCatalogFavoriteItem() {
        return By.xpath("//div[@class='ico wish']");
    }

    // Локатор кнопки добавить в сравнение в каталоге
    public By getCatalogCompareItem() {
        return By.xpath("//div[@class='ico compare']");
    }

    // Локатор кнопки перехода к товарам в сравнении
    public By getCatalogAllCompareItems() {
        return By.xpath("/html/body/header/nav[1]/div/div/a[4]");
    }

    // Локатор кнопки перехода к товарам в избранном
    public By getCatalogAllFavoriteItems() {
        return By.xpath("//span[@class='val'][1]");
    }

    // Локатор кнопки удаления список товаров сравнения
    public By getCatalogDeleteCompareButton() {
        return By.xpath("//button[@class='remove-current-btn']");
    }

    // Локатор элемента с текстом "В списке сравнения нет товаров" на странице сравнения товаров
    public By getTextEmptyItems() {
        return By.xpath("/html/body/main/div/div/div/div");
    }

    // Локатор кнопки отправки сообщения в форме carrot quest
    public By getClickSendMessageCarrotQuestButton() {
        return By.xpath("//span[@class='button__icon cqi-chat cqi-arrow-up svelte-n3a0ou']");
    }
    // Локатор кнопки быстрого фильтра первого уровня
    public By getClickQuickFilterFirstLevelButton() {
        return By.xpath("//label[@for='w0-din-0']");
    }

    // Локатор кнопки быстрого фильтра второго уровня
    public By getClickQuickFilterSecondLevelButton() {
        return By.xpath("//div[@class='links']");
    }

    // Локатор текста кнопок быстрого фильтра второго уровня
    public By getTextQuickFilterSecondLevelButton() {
        return By.xpath("//*[@id=\"w0\"]/div/a[1]");
    }

    // Локатор текста на странице отображения результатов быстрого фильтра
    public By getResultQuickFilterText() {
        return By.xpath("/html/body/div[3]");
    }
}