package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class AngularWaits {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    private static WebDriver driver;

    public void waitUntilAngularReady() {
        try {
            Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll(20);
                    waitForAngularLoad();
                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void angularLoads(String angularReadyScript) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
            boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

            if (!angularReady) {
                jsWait.until(angularLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    //SET DRIVERS
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        jsWaitDriver = webDriver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(15));
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    public void waitAllRequest() {
        waitUntilAngularReady();
    }
    private void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }
    private void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
