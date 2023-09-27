import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class BaseTest {


    @Before
    public void setUp() {
        Configuration.baseUrl = "https://www.autopartner-perm.ru/";
        Configuration.timeout = 10000;
        Configuration.browser = "SelenoidDriverProvider";
    }
     @After
    public void tearDown() {
         Selenide.closeWebDriver();
         clearBrowserCookies();
     }}