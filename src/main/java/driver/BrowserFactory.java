package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import java.net.MalformedURLException;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }
        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(START_MAXIMIZED);
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--allow-file-access-from-files");
            chromeOptions.addArguments("--disable-notifications");
            return chromeOptions;
        }
    };

    private static final String START_MAXIMIZED = "--start-maximized";
    public abstract WebDriver createDriver() throws MalformedURLException;
    public abstract AbstractDriverOptions<?> getOptions();
}
