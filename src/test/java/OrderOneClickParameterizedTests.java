import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderOneClickParameterizedTests extends BaseTest {
    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage();
    private String name;
    private String phoneNumber;
    private String categoryId;

    public OrderOneClickParameterizedTests(String name, String phoneNumber, String categoryId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.categoryId = categoryId;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TestData.getOrderTestData());
    }

    @Test
    @DisplayName("Оформление заказа")
    @Description("Оформление заказа в 1 клик")
    public void testOrderBuyOneClick() {
        homePage.openHomePage();
        homePage.clickButtonCatalogCategory(categoryId);
        orderPage.clickFirstItem();
        orderPage.clickButtonBuyOneClick();
        orderPage.enterNameBuyOneClick(name);
        orderPage.enterPhoneBuyOneClick(phoneNumber);
        orderPage.clickButtonSendOrder();
        orderPage.checkNotificationSuccessOrder();
        orderPage.clickButtonClose();
    }
    @Test
    @DisplayName("Оформление заказа")
    @Description("Оформление заказа в 1 клик")
    public void testOrderBuy() {
        homePage.openHomePage();
        homePage.clickButtonCatalogCategory(categoryId);
        orderPage.clickFirstItem();
        orderPage.clickButtonBuyOneClick();
        orderPage.enterNameBuyOneClick(name);
        orderPage.enterPhoneBuyOneClick(phoneNumber);
        orderPage.clickButtonSendOrder();
        orderPage.checkNotificationSuccessOrder();
        orderPage.clickButtonClose();
    }
}
