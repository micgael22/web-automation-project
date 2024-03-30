package scenarios;

import base.BaseConfiguration;
import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Logger;

public class OnboardScenario_HRM extends WebScenario{

    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));

    public OnboardScenario_HRM(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void onboardProcess(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Onboard-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "FORGOT_PASSWORD":
                helpers.customVerifyElementPresent(poOnbrd.linkForgotPwd);
                helpers.customClick(poOnbrd.linkForgotPwd);
                helpers.customVerifyElementText(poOnbrd.headerResetPwd, "Reset Password");
                helpers.customSetText(poOnbrd.inputResetUsername, "GENERATED NAME");
                helpers.customClick(poOnbrd.btnResetPwd);
                helpers.customVerifyElementText(poOnbrd.headerSuccess, "Reset Password link sent successfully");
                break;

        }
    }

    public void loginInvalidCreds(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Login-with-invalid-Details <<< DATA TO USE >>>" + dataToUse);
        try {
            propUserDetails = getUserDetailsFromPropertiesFile(dataToUse);
            helpers.customVerifyElementPresent(poOnbrd.imgHRMLogo);
            helpers.customVerifyElementText(poOnbrd.headerLogin, "Login");
            helpers.customInputText(poOnbrd.inputUsername, prop.getProperty("INV_USERNAME"));
            helpers.customInputText(poOnbrd.inputPassword, prop.getProperty("INV_PWD"));
            helpers.customClick(poOnbrd.btnLogin);
            helpers.customWait("3");
            helpers.customVerifyElementText(poOnbrd.errorLoginMsg, "Invalid credentials");
        }
        catch (Exception e){
            LOGGER.get().info(">>>> LOG : ERROR!! LOGIN-SCENARIO <<<< \n >>>> login-email-password USER-Unable to login <<<< " + e.getMessage());
            helpers.assertfailure(e,null);
        }
    }

    public void loginValidCreds(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Login-with-Valid-Details <<< DATA TO USE >>>" + dataToUse);
        try {
            propUserDetails = getUserDetailsFromPropertiesFile(dataToUse);
            helpers.customVerifyElementPresent(poOnbrd.imgHRMLogo);
            helpers.customVerifyElementText(poOnbrd.headerLogin, "Login");
            helpers.customInputText(poOnbrd.inputUsername, prop.getProperty("USERNAME"));
            helpers.customInputText(poOnbrd.inputPassword, prop.getProperty("PWD"));
            helpers.customClick(poOnbrd.btnLogin);
            helpers.customWait("3");
            helpers.customVerifyElementText(poOnbrd.headerDashboard, "Dashboard");
        }
        catch (Exception e){
            LOGGER.get().info(">>>> LOG : ERROR!! LOGIN-SCENARIO <<<< \n >>>> login-email-password USER-Unable to login <<<< " + e.getMessage());
            helpers.assertfailure(e,null);
        }
    }

    public Properties getUserDetailsFromPropertiesFile(String dataToUse){
        dataToUse = dataToUse.toLowerCase();
        if(dataToUse.equals("hrm.user00")){
            propUserDetails = BaseConfiguration.setCustomProperties(HRM_USER_DETAILS_00 );
        }
        else if(dataToUse.equals("hrm.user01")){
            propUserDetails = BaseConfiguration.setCustomProperties(HRM_USER_DETAILS_01);
        }

        return propUserDetails;
    }



}
