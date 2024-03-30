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


    public void employeeLeaveScenarios (String dataToUse) throws Exception {
        LOGGER.get().info("Execute-employeeLeave-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "APPLY_LEAVE_NAV":
                helpers.customVerifyElementText(poHme.chartEmpLeave, "Employees on Leave Today");
                helpers.customClick(poHme.iconSettings);
                helpers.customVerifyElementText(poHme.lblAccess, "Only show accessible employees on leave for other users");
                helpers.customClick(poHme.toggleBtnAccess);
                helpers.customClick(poHme.btnSave);
                helpers.customWait("2");
                helpers.customVerifyElementPresent(poHme.popUpSuccess);
                break;

        }
    }

}
