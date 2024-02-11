package components;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;
import java.io.IOException;
import java.net.MalformedURLException;

public class Action extends Constants{
    SeleniumHelpers helpers;

    public Action(WebDriver driver) throws MalformedURLException {
        this.driver = driver;
        helpers = new SeleniumHelpers(this.driver);
        general = new GeneralModels(this.driver);
    }

    // EXECUTE STEPS
    @Step("Execute Step : {stepActionDesc}")
    public void executeStep(String stepActionDesc, String sUiAction, WebElement webelementToUse, String dataToUse) throws IOException {
        STEP_DESCRIPTION = stepActionDesc;
        try {
            switch (sUiAction.toUpperCase()) {
                case "VERIFY_CORRECT_PAGE_URL_CONTAINS":
                    helpers.customWaitUntilPageUrlContains(dataToUse);
                    break;
                case "NAVIGATE_TO_PAGE":
                    driver.manage().deleteAllCookies();
                    break;
                case "VERIFY_ELEMENT_TEXT":
                    helpers.customVerifyElementText(webelementToUse,dataToUse);
                    break;
                case "VERIFY_ELEMENT_CONTAINS_TEXT":
                    helpers.customVerifyElementTextContains(webelementToUse, dataToUse);
                    break;
                case "VERIFY_ELEMENT_PRESENT":
                    helpers.customVerifyElementPresent(webelementToUse);
                    break;
                case "WAIT_FOR_ELEMENT":
                    helpers.customElementWait(webelementToUse);
                    break;
                case "REFRESH_PAGE":
                    driver.navigate().refresh();
                    break;
                case "INPUT_TEXT":
                    helpers.customInputText(webelementToUse,dataToUse);
                    break;
                case "SET_TEXT":
                    helpers.customSetText(webelementToUse,dataToUse);
                    break;
                case "CLICK":
                    helpers.customClick(webelementToUse);
                    break;
                case "WAIT":
                    helpers.customWait(dataToUse);
                    break;
                case "SCROLL":
                    ((JavascriptExecutor) this.driver).executeScript("window.scrollBy(0,200)");
                    break;
                case "WAIT_PAGE_LOADED":
                    helpers.waitForPageLoaded(this.driver);
                    break;
                case "SCROLL_TO_TOP":
                    helpers.scrollToTop();
                    break;
                case "SCROLL_TO_BOTTOM":
                    helpers.scrollToBottom();
                    break;
                case "SCROLL_TO_ELEMENT":
                    ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", webelementToUse);
                    break;
            }
            // EXCEPTIONS ON ACTION
            try {
                LOGGER.get().info("====== STEP PASSED  : " + stepActionDesc + " COMPLETED SUCCESSFULLY!! ======");
            } catch (Exception e) {
                LOGGER.get().info("====== STEP FAILED : " + stepActionDesc + " COMPLETED UNSUCCESSFULLY!! ======");
                driver.quit();
            }
        } catch (Exception e) {
            LOGGER.get().info("====== STEP FAILED : " + stepActionDesc + " COMPLETED UNSUCCESSFULLY!! ======");
            LOGGER.get().info("====== LOG: UNKNOWN getCause ERROR \n : '" + e.getCause().getMessage() +"'======");
            helpers.assertfailure(e, webelementToUse);
            driver.quit();
        }
    }
}
