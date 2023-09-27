import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.Collection;

public class TestData {
    public static final String VALID_PHONE_NUMBER = "9999999999";
    public static final String INVALID_PHONE_NUMBER = "ytdfkblys[";
    public static final String PAGE1_URL = "https://www.autopartner-perm.ru/";
    public static final String PAGE1_TITLE = "Купить шины в Перми, цены на авторезину в интернет-магазине Автопартнер";

    public static final String PAGE2_URL = "https://www.autopartner-perm.ru/tyres";
    public static final String PAGE2_TITLE = "Шины купить в Перми, цена на колеса для авто в интернет-магазине";

    public static final String PAGE3_URL = "https://www.autopartner-perm.ru/track-tyres";
    public static final String PAGE3_TITLE = "Купить автомобильные грузовые шины в Перми, цена в интернет-магазине Автопартнер";

    public static final String PAGE4_URL = "https://www.autopartner-perm.ru/privacy-policy";
    public static final String PAGE4_TITLE = "Политика конфиденциальности";

    public static final String PAGE5_URL = "https://www.autopartner-perm.ru/accums";
    public static final String PAGE5_TITLE = "Купить автомобильные аккумуляторы в Перми, цена в интернет-магазине авто аккумуляторов Автопартнер";

    public static final String PAGE6_URL = "https://www.autopartner-perm.ru/auto";
    public static final String PAGE6_TITLE = "Найти шины и диски по производителю авто";

    public static final String PAGE7_URL = "https://www.autopartner-perm.ru/promo";
    public static final String PAGE7_TITLE = "Акции";

    public static final String PAGE8_URL = "https://www.autopartner-perm.ru/about";
    public static final String PAGE8_TITLE = "О компании - Автопартнер";

    public static final String PAGE9_URL = "https://www.autopartner-perm.ru/deliveryandpayment";
    public static final String PAGE9_TITLE = "Оплата и доставка";

    public static final String PAGE10_URL = "https://www.autopartner-perm.ru/guarantee";
    public static final String PAGE10_TITLE = "Бессрочная расширенная гарантия";

    public static final String PAGE11_URL = "https://www.autopartner-perm.ru/keeping";
    public static final String PAGE11_TITLE = "Сезонное хранение автошин — Автопартнер в Перми";

    public static final String PAGE12_URL = "https://www.autopartner-perm.ru/calc";
    public static final String PAGE12_TITLE = "Шинный калькулятор";

    public static final String PAGE13_URL = "https://www.autopartner-perm.ru/vozvrat";
    public static final String PAGE13_TITLE = "Возврат и обмен";

    public static final String PAGE14_URL = "https://www.autopartner-perm.ru/tiremount";
    public static final String PAGE14_TITLE = " Шиномонтаж в Перми, цены на услуги шиномонтажа | Автопартнер";

    public static final String PAGE15_URL = "https://www.autopartner-perm.ru/shops";
    public static final String PAGE15_TITLE = "Магазины";
    public static Object[][] getOrderTestData() {
        return new Object[][]{
                {"ТестУм1", "899999999991", "tyres"},
                {"ТестУм2", "899999999992", "discs"},
                {"ТестУм3", "899999999993", "accum"},
                {"ТестУм4", "899999999994", "track"}
        };
    }
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Cordiant"},
                {"Forward"},
                {"ТЮМЕНЬ"},
                {"Диск"}
        });
    }
    public static final String company = "Cordian";
}

