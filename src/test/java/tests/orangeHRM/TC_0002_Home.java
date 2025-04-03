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

    @Description("User search option in banner")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Home"}, description = "TC_ID=06004 | Verify search input is responsive")
    public void home_searchResponsive() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiAction.executeStep("User search option", "INPUT_TEXT", poHme.bannerSearch, "PIM");
        uiAction.executeStep("User click on option","CLICK",poHme.bnrPIM,null);
        uiAction.executeStep("Wait added","wait",null,"3");
        uiAction.executeStep("Verify title present", "VERIFY_ELEMENT_TEXT", poHme.topBarTitle, "PIM");
    }
    
    @Description("User verify Time page is responsive")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Home"}, description = "TC_ID=0801 | User navigate through sub Time page sub-categories")
    public void home_timeSheetsResponsive() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiAction.executeStep("User search option", "INPUT_TEXT", poHme.bannerSearch, "Time");
        uiAction.executeStep("User click on option","CLICK",poHme.bnrTime,null);
        uiAction.executeStep("Wait added","wait",null,"3");
        uiActionScenario.executeScenario("User navigates through the Time sheets section", "HOME_HRM",null,"time_sheets_nav");
        uiActionScenario.executeScenario("User navigates through the Attendance section", "HOME_HRM",null,"attendance_nav");
        uiActionScenario.executeScenario("User navigates through the Reports section", "HOME_HRM",null,"reports_nav");
        uiActionScenario.executeScenario("User navigates through the Projects section", "HOME_HRM",null,"project_info_nav");
        LOGGER.info("===== LOG: User able to navigate through the TIME PAGE  =====");
    }

    @Description("User verify PIM page is responsive")
    @Severity(SeverityLevel.MINOR)
    @Story("Orange HRM")
    @Test(groups = {"Home"}, description = "TC_ID=06005 | User navigate to dropdown icons on PIM page & verify icons is reactive")
    public void home_pimPageResponsive() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_HRM",null,"hrm.user00");
        uiActionScenario.executeScenario("User navigates to PIM page", "HOME_HRM",null,"pim_page_nav");
        uiActionScenario.executeScenario("User select the Employee Status", "HOME_HRM",null,"emp_status_nav");
        uiActionScenario.executeScenario("User select an Include option", "HOME_HRM",null,"include_nav");
        uiActionScenario.executeScenario("User select Job Title", "HOME_HRM",null,"job_title_nav");
        uiActionScenario.executeScenario("User select an Sub Unit", "HOME_HRM",null,"sub_unit_nav");
        LOGGER.info("===== LOG: User able to navigate through the PIM PAGE(REACTIVE)  =====");
    }

}
