package scenarios;

import base.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import pageObjects.orangeHRM.poHome;
import pageObjects.orangeHRM.poOnboard;
import pageObjects.swaglabs.poCheckout;
import pageObjects.swaglabs.poLogin;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class WebScenario extends BaseController {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WebScenario.class);

    SeleniumHelpers helpers;
    GeneralModels general;
    LoginScenario_SL loginSC;
    CheckoutScenario_SL checkSC;
    OnboardScenario_HRM onboardSC;
    Properties propUserDetails;

    public WebScenario(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        helpers = new SeleniumHelpers(driver);
        general = new GeneralModels(driver);
        poLog = new poLogin(driver);
        poCheck = new poCheckout(driver);
        poOnbrd = new poOnboard(driver);
        poHme = new poHome(driver);
    }

    public void executeScenario(String sScenarioDescription, String sUiScenario, WebElement webelementToUse, String dataToUse) throws IOException {
        SCENARIO_DESCRIPTION = sScenarioDescription;
        loginSC  = new LoginScenario_SL(driver);
        checkSC = new CheckoutScenario_SL(driver);
        onboardSC = new OnboardScenario_HRM(driver);
        homeSC = new HomeScenario_HRM(driver);

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
                case "LOGIN_INVALID_HRM":
                    onboardSC.loginInvalidCreds(dataToUse);
                    break;
                case "LOGIN_VALID_HRM":
                    onboardSC.loginValidCreds(dataToUse);
                    break;
                case "ONBOARD_HRM":
                    onboardSC.onboardProcess(dataToUse);
                    break;
                case "DASHBOARD_HRM":
                    homeSC.dashboardScenarios(dataToUse);
                    break;
                case "HOME_HRM":
                    homeSC.homeScenarios(dataToUse);
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
