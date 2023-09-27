import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class SelenoidDriverProvider implements WebDriverProvider {
    private String defaultResolution = "1920x1080";

    public SelenoidDriverProvider() {
    }
    public SelenoidDriverProvider(String resolution) {
        this.defaultResolution = resolution;
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Google chrome");
            put("enableVNC", true);
            put("screenResolution", defaultResolution);
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                        put("manual", "true");
                    }}
            );
            put("enableVideo", true);
        }});

        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), options);
            WebDriverRunner.setWebDriver(driver);
            driver.manage().window().maximize();
            Configuration.browserSize = defaultResolution;
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
