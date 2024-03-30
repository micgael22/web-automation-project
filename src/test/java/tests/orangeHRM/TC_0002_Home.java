package tests.orangeHRM;

import base.BaseController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TC_0002_Home extends BaseController {

    public TC_0002_Home() throws MalformedURLException {
    }

    @Description("Toggle button - access employees on leave")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Dashboard"}, description = "TC_ID=06001 | Verify user can click toggle button (on and off)")
    public void dashboard_toggleButton() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiActionScenario.executeScenario("User navigates to enable toggle button","DASHBOARD_HRM",null,"EMP_LEAVE_TOGGLE_BTN_NAV");
        uiActionScenario.executeScenario("User reset employee leave and save","DASHBOARD_HRM",null,"reset_leave_toggle_btn_nav");
    }


}
