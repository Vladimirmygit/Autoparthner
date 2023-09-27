import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

@RunWith(Parameterized.class)
public class HomePageSearchParameterizedTests extends BaseTest {
    HomePage homePage = new HomePage();

    private String searchText;

    public HomePageSearchParameterizedTests(String searchText) {
        this.searchText = searchText;
    }

    @DisplayName("Параметризованный тест проверки работоспособности поиска на сайте")
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return TestData.data();
    }
    @Test
    public void checkSearch() {
        homePage.openHomePage();
        homePage.clickSearchLine();
        homePage.enterTextSearchLine(searchText);
        homePage.checkCompareItemNameWithSearchResults(searchText);
    }
}
