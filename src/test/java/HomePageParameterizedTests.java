import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HomePageParameterizedTests extends BaseTest {
    HomePage homePage = new HomePage();
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    private String pageUrl;
    private String expectedTitle;

    public HomePageParameterizedTests(String pageUrl, String expectedTitle) {
        this.pageUrl = pageUrl;
        this.expectedTitle = expectedTitle;
    }


    @DisplayName("Параметризованный тест проверки работоспособности основных страниц сайта")
    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { TestData.PAGE1_URL, TestData.PAGE1_TITLE },
                { TestData.PAGE2_URL, TestData.PAGE2_TITLE },
                { TestData.PAGE3_URL, TestData.PAGE3_TITLE },
                { TestData.PAGE4_URL, TestData.PAGE4_TITLE },
                { TestData.PAGE5_URL, TestData.PAGE5_TITLE },
                { TestData.PAGE6_URL, TestData.PAGE6_TITLE },
                { TestData.PAGE7_URL, TestData.PAGE7_TITLE },
                { TestData.PAGE8_URL, TestData.PAGE8_TITLE },
                { TestData.PAGE9_URL, TestData.PAGE9_TITLE },
                { TestData.PAGE10_URL, TestData.PAGE10_TITLE },
                { TestData.PAGE11_URL, TestData.PAGE11_TITLE },
                { TestData.PAGE12_URL, TestData.PAGE12_TITLE },
                { TestData.PAGE13_URL, TestData.PAGE13_TITLE },
                { TestData.PAGE14_URL, TestData.PAGE14_TITLE },
                { TestData.PAGE15_URL, TestData.PAGE15_TITLE }
        });
    }
    @Test
    @DisplayName("Проверка работоспособности основных страниц сайта")
    @Description("Проверка заголовка страницы")
    @Parameters({ "1920x1080", "1366x768", "1280x1024", "768x1024", "375x850" })
    public void checkSearch() {
        homePage.openPage(pageUrl);
        homePage.verifyPageTitle(expectedTitle);
    }

}
