package utilities;

import components.Constants;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.FileAssert.fail;

public class SeleniumHelpers extends Constants {
    public DataGenerators dataGenerators;
    SoftAssert softAssert ;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;

    public SeleniumHelpers(WebDriver driver) throws MalformedURLException {
        this.driver = driver;
        dataGenerators = new DataGenerators();
        softAssert = new SoftAssert();
        interval = Duration.ofSeconds(1);
        timeout = Duration.ofSeconds(60);
        verificationWait = new FluentWait<>(this.driver).withTimeout(timeout).ignoring(NoSuchElementException.class)
                .pollingEvery(interval);
        general = new GeneralModels(this.driver);
    }

    // VERIFY TEXT TO BE
    public static ExpectedCondition<Boolean> textToBe(final WebElement element, final String value) {
        LOGGER.info("===== LOG : TEXTtoBE ON ELEMENT == " + element + " THE VALUE TO BE '" + value + " ====='");
        return new ExpectedCondition<Boolean>() {
            private String currentValue = null;
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    currentValue = element.getText();
                    LOGGER.info("===== LOG: A VALUE : '" + currentValue + " =====' ");
                    LOGGER.info("===== LOG: E VALUE : '" + value + " =====' ");
                    return currentValue.equals(value);
                } catch (Exception e) {
                    return false;
                }
            }
            @Override
            public String toString() {
                return String.format(" == ELEMENT FOUND BY %s TO HAVE TEXT \"%s\". CURRENT TEXT : \"%s\" ==",
                        element, value, currentValue);
            }
        };
    }

    // VERIFY ELEMENT TEXT CONTAINS
    public void customVerifyElementTextContains(final WebElement webelementToUse, String dataToUse){
        LOGGER.info("=== LOG : customVerifyElementTextContains ON ELEMENT = " + webelementToUse + " THE DATA TO USE IS '" + dataToUse +" ==='");
        try{
            if (dataToUse.toUpperCase().contains("GENERATED")) {
                String dataRequired = dataGenerators.GenerateRequiredData(dataToUse);
                dataToUse = dataRequired;
            }
            verificationWait.until(this.textToBePresentInElement(webelementToUse, dataToUse));
        }catch (AssertionError e){
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getLocalizedMessage() +"'");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getMessage() +"'");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getCause() +"'");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e +"'");
            fail();
        }
    }

    // VERIFY TEXT PRESENT IN ELEMENT
    public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element, final String text) {
        LOGGER.info("=== LOG : textToBePresentInElement ON ELEMENT === " + element);
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = element.getText();
                    LOGGER.info("=== LOG : textToBePresentInElement on ACTUAL TEXT IN ELEMENT === " + elementText);
                    LOGGER.info("=== LOG : textToBePresentInElement on EXPECTED TEXT IN ELEMENT === " + text);

                    return elementText.contains(text);
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            }
            @Override
            public String toString() {
                return String.format("TEXT ('%s') TO BE PRESENT IN ELEMENT %s", text, element);
            }
        };
    }

    // USER CUSTOM CLICK
    public void customClick(WebElement webelementToUse ) throws Exception {
        LOGGER.info("=== LOG : customClick ON ELEMENT === " + webelementToUse);
        try {
            boolean resultDisplay = webelementToUse.isDisplayed();
            softAssert.assertTrue(resultDisplay, "=== Assert: ELEMENT DISPLAYED");
            verificationWait.until(customVerifyElementToBeClickable(webelementToUse));
            webelementToUse.click();
            waitForPageLoaded(this.driver);

        } catch (Exception e) {
            LOGGER.info("=== LOG : customClick ON ELEMENT WITH EXCEPTION StaleElementReferenceException == " + webelementToUse + " ELEMENT & ERROR " + e.getMessage());
            if (e.getMessage().toLowerCase().contains("staleElementReference")){
                new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
                        .until(customVerifyElementToBeClickable(webelementToUse));
                webelementToUse.click();
            }else{
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.refreshed(this.visibilityOfElementLocated(webelementToUse)));
                webelementToUse.click();
            }
        }
    }

    // USER INPUT TEXT
    public void customInputText(WebElement webelementToUse, String dataToUse) throws Exception {
        LOGGER.info("=== LOG : customInputText ON ELEMENT = " + webelementToUse + " DATA TO USE " + dataToUse);
        scrollToElement(webelementToUse);
        try {
            webelementToUse.clear();
        } catch (NoSuchElementException e) {
            LOGGER.info("=== LOG: UNABLE TO CLEAR INPUT TEXT ON ELEMENT : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        try{
            if (dataToUse.toUpperCase().contains("GENERATED")) {
                String dataRequired = dataGenerators.GenerateRequiredData(dataToUse);
                webelementToUse.sendKeys(dataRequired);
            } else {
                webelementToUse.sendKeys(dataToUse);
            }
        }catch(NoSuchElementException e){
            LOGGER.info("=== LOG: UNABLE TO INPUT TEXT ON ELEMENT : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    // USER SET TEXT
    public void customSetText(WebElement webelementToUse, String dataToUse) throws Exception {
        LOGGER.info("=== LOG : customSetText ON ELEMENT = " + webelementToUse + " DATA TO USE " + dataToUse);
        try {
            webelementToUse.clear();
        } catch (NoSuchElementException e) {
            LOGGER.info("=== LOG : UNABLE TO CLEAR INPUT TEXT ON ELEMENT : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        try{
            if (dataToUse.toUpperCase().contains("GENERATED")) {
                String dataRequired = dataGenerators.GenerateRequiredData(dataToUse);
                webelementToUse.sendKeys(dataRequired);
            } else {
                webelementToUse.sendKeys(dataToUse);
            }
        }catch(NoSuchElementException e){
            LOGGER.info("=== LOG : UNABLE TO INPUT TEXT ON ELEMENT : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    // VERIFY ELEMENT PRESENT
    public void customVerifyElementText(WebElement webelementToUse, String dataToUse) throws Exception {
        LOGGER.info("=== LOG : customVerifyElementText ON ELEMENT = " + webelementToUse + " THE DATA TO USE is '" + dataToUse +"'");
        try{
            verificationWait.until(this.visibilityOfElementLocated(webelementToUse));
            if (dataToUse.toUpperCase().contains("GENERATED")) {
                String dataRequired = dataGenerators.GenerateRequiredData(dataToUse);
                dataToUse = dataRequired;
            }
            verificationWait.until(this.textToBe(webelementToUse, dataToUse));
        }
        catch (AssertionError e){
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getLocalizedMessage() +" ==='");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getMessage() +" ==='");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e.getCause() +" ==='");
            LOGGER.info("=== LOG: UNKNOWN customVerifyElementText ERROR \n : '" + e +" ==='");
            fail();
        }
    }

    // VERIFY ELEMENT VISIBLE
    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final WebElement element) {
        LOGGER.info("=== LOG : visibilityOfElementLocated ON ELEMENT = " + element);
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    return elementIfVisible(element);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }
            @Override
            public String toString() {
                return "VISIBILITY of element located BY " + element;
            }
        };
    }

    // VERIFY ELEMENT TO BE CLICKABLE
    public static ExpectedCondition<WebElement> customVerifyElementToBeClickable(WebElement webelementToUse) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = visibilityOfElementLocated(webelementToUse).apply(driver);
                try {
                    if (element != null && element.isEnabled()) {
                        return element;
                    }
                    return null;
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }
            @Override
            public String toString() {
                return "ELEMENT TO BE clickable: " + webelementToUse;
            }
        };
    }

    // ANGULAR WAITS - WAIT FOR PAGE TO LOAD
    public void waitForPageLoaded(WebDriver driver) {
        LOGGER.log(Level.INFO, " === START waitForPageLoaded : WAIT FOR PAGE TO HAVE loaded...");
        AngularWaits(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                LOGGER.info("CURRENT WINDOW STATE    : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
        LOGGER.log(Level.INFO, "=== END waitForPageLoaded : WAIT FOR PAGE TO HAVE loaded...");
    }

    // PRESENCE ELEMENT LOCATED
    public static ExpectedCondition<WebElement> presenceOfElementLocated(final WebElement element) {
        LOGGER.info("=== LOG : presenceOfElementLocated ON ELEMENT = " + element);
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return element;
            }
            @Override
            public String toString() {
                return "PRESENCE OF ELEMENT LOCATED BY : " + element;
            }
        };
    }

    // CUSTOM ASSERT FAILURE - THROWS EXCEPTION
    public void assertfailure(Exception e, @Optional WebElement element) throws IOException {
        LOGGER.info("=== LOG : assertFailure ===");
        Allure.addAttachment("Scenario/Step assertFailure || " + e.getLocalizedMessage(),  general.takeScreenshot(e.getLocalizedMessage()));
        if(e.getLocalizedMessage().contains("element")){
            Assert.fail("\n TEST ASSERT FAILURE : \n" + e.getLocalizedMessage() + " \n = " + element);
        }else{
            Assert.fail("\n TEST ASSERT FAILURE : \n" + e.getLocalizedMessage());
        }
        driver.close();
    }

    // VERIFY IF ELEMENT VISIBLE
    private static WebElement elementIfVisible(WebElement element) {
        LOGGER.info("=== LOG : elementIfVisible ON ELEMENT = " + element);
        return element.isDisplayed() ? element : null;
    }

    // VERIFY ELEMENT PRESENT
    public void customVerifyElementPresent(WebElement webelementToUse) throws Exception {
        LOGGER.info("=== LOG : customVerifyElementPresent : " + webelementToUse);
        verificationWait.until(this.visibilityOfElementLocated(webelementToUse));
        softAssert.assertTrue(webelementToUse.isDisplayed(), " == element is not PRESENT ==");
    }

    // ADD CUSTOM WAIT
    public void customWait(String dataToUse) throws Exception {
        LOGGER.info("=== LOG : customWait : " + dataToUse);
        int seconds = Integer.parseInt(dataToUse);
        Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
    }

    // WAIT FOR ELEMENT TO BE PRESENT
    public void customElementWait(WebElement webelementToUse) throws Exception {
        LOGGER.info("=== LOG : customElementWait webElementToUse : " + webelementToUse);
        verificationWait.until(presenceOfElementLocated(webelementToUse));
    }

    // VERIFY PAGE URL
    public void verifyPageUrl(String dataToUse){
        softAssert.assertTrue(driver.getCurrentUrl().contains(dataToUse));
    }

    // SCROLL TO ELEMENT
    public void scrollToElement(WebElement element){
        LOGGER.log(Level.INFO, "=== scrollToElement : ELEMENT " + element);
        try{
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            javaExecutor.executeAsyncScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    // SCROLL TO TOP
    public void scrollToTop(){
        LOGGER.log(Level.INFO, "scrollToTop");
        ((JavascriptExecutor) this.driver)
                .executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }

    // SCROLL TO BOTTOM
    public void scrollToBottom(){
        ((JavascriptExecutor) this.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // ANGULAR WAITS
    public void AngularWaits(WebDriver driver){
        AngularWaits allwaits = new AngularWaits();
        AngularWaits.setDriver(driver);
        allwaits.waitAllRequest();
    }

    // WAIT UNTIL & PAGE URL CONTAINS STRING
    public void customWaitUntilPageUrlContains(String dataToUse) throws IOException {
        LOGGER.log(Level.INFO, "=== customWaitUntilPageUrlContains = " + dataToUse);
        String URL = driver.getCurrentUrl();
        try {
            verificationWait.until(ExpectedConditions.urlContains(dataToUse));
        } catch (Exception e) {
            LOGGER.info("=== LOG: ERROR STRING || page_Url" + URL);
            throw new RuntimeException(e);
        }
    }

    // PAGE LOAD
    public void verifyPageLoaded(String dataToUse){
        softAssert.assertTrue(driver.getPageSource().contains(dataToUse));
    }


}
