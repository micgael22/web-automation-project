package scenarios;

import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class HomeScenario_HRM extends WebScenario{

    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));

    public HomeScenario_HRM(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void dashboardScenarios (String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Dashboard-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "EMP_LEAVE_TOGGLE_BTN_NAV":
                helpers.customVerifyElementText(poHme.chartEmpLeave, "Employees on Leave Today");
                helpers.customClick(poHme.iconSettings);
                helpers.customVerifyElementText(poHme.lblAccess, "Only show accessible employees on leave for other users");
                helpers.customClick(poHme.toggleBtnAccess);
                helpers.customClick(poHme.btnSave);
                helpers.customWait("2");
                helpers.customVerifyElementPresent(poHme.popUpSuccess);
                break;
            case "RESET_LEAVE_TOGGLE_BTN_NAV":
                helpers.customClick(poHme.iconSettings);
                helpers.customClick(poHme.toggleBtnAccess);
                helpers.customClick(poHme.btnSave);
                helpers.customWait("2");
                helpers.customVerifyElementText(poHme.popUpSuccessMsg, "Successfully Updated");
                break;
        }
    }

    public void homeScenarios (String dataToUse) throws Exception {
        LOGGER.get().info("Execute-home-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "BANNER_NAV":
                helpers.customVerifyElementPresent(poHme.logoBannerImg);
                helpers.customClick(poHme.btnOpenCloseBanner);
                helpers.customClick(poHme.btnOpenCloseBanner);
                helpers.customSetText(poHme.bannerSearch, "My Info");
                helpers.customClick(poHme.bnrSearchedItem);
                helpers.customWait("2");
                helpers.customVerifyElementText(poHme.headerPersonalInfo, "Personal Details");
                break;
            case "BANNER_VERIFY_PAGES":
                helpers.customVerifyElementPresent(poHme.logoBannerImg);
                helpers.customClick(poHme.bnrAdmin);
                helpers.customVerifyElementText(poHme.topBarTitle, "Admin\nUser Management");
                helpers.customClick(poHme.bnrPIM);
                helpers.customVerifyElementText(poHme.topBarTitle, "PIM");
                helpers.customClick(poHme.bnrLeave);
                helpers.customVerifyElementText(poHme.topBarTitle, "Leave");
                helpers.customClick(poHme.bnrTime);
                helpers.customVerifyElementText(poHme.topBarTitle, "Time\nTimesheets");
                helpers.customClick(poHme.bnrRecruitment);
                helpers.customVerifyElementText(poHme.topBarTitle, "Recruitment");
                helpers.customClick(poHme.bnrMyInfo);
                helpers.customVerifyElementText(poHme.topBarTitle, "PIM");
                helpers.customClick(poHme.bnrPerformance);
                helpers.customVerifyElementText(poHme.topBarTitle, "Performance\nManage Reviews");
                helpers.customClick(poHme.bnrDashboard);
                helpers.customVerifyElementText(poHme.topBarTitle, "Dashboard");
                helpers.customClick(poHme.bnrDirectory);
                helpers.customVerifyElementText(poHme.topBarTitle, "Directory");
                helpers.customClick(poHme.bnrMaintenance);
                helpers.customVerifyElementText(poHme.headerMntce, "Administrator Access");
                helpers.customClick(poHme.btnCancel);
                helpers.scrollToBottom();
                helpers.customClick(poHme.bnrClaim);
                helpers.customVerifyElementText(poHme.topBarTitle, "Claim");
                helpers.customClick(poHme.bnrBuzz);
                helpers.customVerifyElementText(poHme.topBarTitle, "Buzz");
                break;
        }
    }

}
