package scenarios;

import base.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import pageObjects.poCheckout;
import pageObjects.poLoginPage;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class WebScenario extends BaseController {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WebScenario.class);

    SeleniumHelpers helpers;
    GeneralModels general;
    LoginScenario loginSC;
    CheckoutScenario checkSC;
    Properties propUserDetails;

    public WebScenario(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        helpers = new SeleniumHelpers(driver);
        general = new GeneralModels(driver);
        poLog = new poLoginPage(driver);
        poCheck = new poCheckout(driver);
    }

    public void executeScenario(String sScenarioDescription, String sUiScenario, WebElement webelementToUse, String dataToUse) throws IOException {
        SCENARIO_DESCRIPTION = sScenarioDescription;
        loginSC  = new LoginScenario(driver);
        checkSC = new CheckoutScenario(driver);

        LOGGER.info("== START = Executing Scenario :" + sUiScenario + " : " + dataToUse);
        try {
            switch (sUiScenario.toUpperCase()) {
                case "LOGIN_INVALID_CREDS":
                    loginSC.executeLoginCreationStep(dataToUse);
                    break;
                case "LOGIN_VALID_CREDS":
                    loginSC.loginWithValidCreds(dataToUse);
                    break;
                case "CHECKOUT_NAVIGATION":
                    checkSC.checkoutProcess(dataToUse);
                    break;

            }

            LOGGER.info("== END : Executing Scenario : " + sUiScenario + " : " + dataToUse);
            try {
                LOGGER.info("====== SCENARIO PASSED : " + sScenarioDescription + " COMPLETED SUCCESSFULLY!! ======");
            } catch (Exception e) {
                LOGGER.info("====== SCENARIO FAILED : " + sScenarioDescription + " COMPLETED UNSUCCESSFULLY!! ======");
                driver.quit();
            }
        } catch (Exception e) {
            LOGGER.info("====== SCENARIO FAILED : " + sScenarioDescription + " COMPLETED UNSUCCESSFULLY!! ======");
            LOGGER.info("====== LOG: UNKNOWN ERROR with test step \n : '" + e.getMessage() + " ======'");
            helpers.assertfailure(e, webelementToUse);
            driver.quit();
        }
    }

}
