package scenarios;

import base.BaseConfiguration;
import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Logger;

public class LoginScenario_SL extends WebScenario {
    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));
    public LoginScenario_SL(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void executeLoginCreationStep(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Login-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "USER_INVALID_LOGIN_NAV":
                helpers.customVerifyElementText(poLog.headerSwagLabs, "Swag Labs");
                helpers.customSetText(poLog.inputUsername, "inv@l!dUserN@me");
                helpers.customSetText(poLog.inputPassword, "f@a!lp@ssw0rd");
                helpers.customClick(poLog.btnLogin);
                helpers.customWait("3");
                break;

        }
    }

    public void loginWithValidCreds(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Login-with-Valid-Details <<< DATA TO USE >>>" + dataToUse);
        try {
            propUserDetails = getUserDetailsFromPropertiesFile(dataToUse);
            helpers.customInputText(poLog.inputUsername,  prop.getProperty("USERNAME"));
            helpers.customInputText(poLog.inputPassword,  prop.getProperty("PWD"));
            helpers.customClick(poLog.btnLogin);
            helpers.customWait("3");
            helpers.customVerifyElementText(poCheck.headerProd, "Products");

        }catch (Exception e){
            LOGGER.get().info(">>>> LOG : ERROR!! LOGIN-SCENARIO <<<< \n >>>> login-email-password USER-Unable to login <<<< " + e.getMessage());
            helpers.assertfailure(e,null);
        }
    }

    public Properties getUserDetailsFromPropertiesFile(String dataToUse){
        dataToUse = dataToUse.toLowerCase();
        if(dataToUse.equals("swaglab.user00")){
            propUserDetails = BaseConfiguration.setCustomProperties(SL_USER_DETAILS_00);
        }
        else if(dataToUse.equals("swaglab.user01")){
            propUserDetails = BaseConfiguration.setCustomProperties(SL_USER_DETAILS_01);
        }
        else if(dataToUse.equals("swaglab.user02")){
            propUserDetails = BaseConfiguration.setCustomProperties(SL_USER_DETAILS_02);
        }
        return propUserDetails;

    }

}
