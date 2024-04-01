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
        uiActionScenario.executeScenario("User navigates to enable toggle button","DASHBOARD_HRM",null,"emp_leave_toggle_btn_nav");
        uiActionScenario.executeScenario("User reset employee leave and save","DASHBOARD_HRM",null,"reset_leave_toggle_btn_nav");
    }

    @Description("Banner Responsive")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Home"}, description = "TC_ID=06002 | Verify banner is responsive")
    public void home_activeBanner() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiActionScenario.executeScenario("User verify banner responsive","HOME_HRM",null,"banner_nav");
    }

    @Description("Navigates through pages")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Home"}, description = "TC_ID=06003 | Verify options in banner is responsive")
    public void home_responsiveBanner() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiActionScenario.executeScenario("User navigates through banner - pages","HOME_HRM",null,"banner_verify_pages");
    }


}
