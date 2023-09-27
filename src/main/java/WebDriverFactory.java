import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    public static WebDriver createDriver(String resolution) {
        SelenoidDriverProvider driverProvider = new SelenoidDriverProvider(resolution);
        WebDriver driver = driverProvider.createDriver(new DesiredCapabilities());
        WebDriverRunner.setWebDriver(driver);
        return driver;
    }
}
