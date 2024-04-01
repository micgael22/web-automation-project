package tests.orangeHRM;

import base.BaseController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class TC_0001_Onboard extends BaseController {

    public TC_0001_Onboard() throws MalformedURLException {
    }

    @Description("Valid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Onboard"}, description = "TC_ID=05001 | User login successfully")
    public void onboard_validLogin() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
    }

    @Description("Invalid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Onboard"}, description = "TC_ID=05002 | Verify user unable to login with invalid credentials")
    public void onboard_invalidLogin() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_INVALID_HRM",null,"hrm.user01");
    }

    @Description("Forgot password")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Onboard"}, description = "TC_ID=05003 | Verify user unable to login with invalid credentials")
    public void onboard_forgotPassword() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","ONBOARD_HRM",null,"forgot_password");
    }

}
