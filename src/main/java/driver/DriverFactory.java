package driver;

import exceptions.TargetNotValidException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.GLOBAL_LOGGER_NAME;
import static java.util.logging.Logger.getGlobal;

public class DriverFactory {
    private static final Logger logger = Logger.getLogger(getGlobal().getName());
    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(GLOBAL_LOGGER_NAME));

    // REMOTE DRIVER
    public WebDriver createInstance(String browser, String mTarget, String mProjectName) throws MalformedURLException {
        Target target = Target.valueOf(mTarget.toUpperCase());
        LOGGER.get().info("============ THIS IS MY PROJECT NAME : " + mProjectName);
        LOGGER.get().info("============ THIS IS MY TARGET : " + target);
        LOGGER.get().info("============ THIS IS MY BROWSER : " + browser);
        WebDriver driver;

        switch (target) {
            case LOCAL:
                driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                driver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return driver;
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", "localhost", "4444");
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        }
        catch (MalformedURLException e) {
            logger.log(Level.SEVERE, " ========= GRID URL IS INVALID OR GRID ID is NOT AVAILABLE =========");
            logger.log(Level.SEVERE, String.format(" ========= BROWSER : %s", capability.getBrowserName()), e);
        }
        catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, String.format(" ========= BROWSER %s IS NOT VALID OR RECOGNIZED", capability.getBrowserName()), e);
        }
        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
