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
            case "TIME_SHEETS_NAV":
                helpers.customClick(poHme.ddTSheets);
                helpers.customClick(poHme.itemMyTSheets);
                helpers.customClick(poHme.iconCalender);
                helpers.customClick(poHme.ddMonth);
                helpers.customClick(poHme.selectMonth);
                helpers.customClick(poHme.selectDate);
                helpers.customVerifyElementText(poHme.txtNoTimeSheets, "No Timesheets Found");
                break;
            case "ATTENDANCE_NAV":
                helpers.customClick(poHme.ddAttendance);
                helpers.customClick(poHme.itemConfig);
                helpers.customVerifyElementText(poHme.txtChangeTime, "Employee can change current time when punching in/out");
                helpers.customClick(poHme.toggleBtn01);
                helpers.customVerifyElementText(poHme.txtDeleteRecords, "Employee can edit/delete own attendance records");
                helpers.customClick(poHme.toggleBtn02);
                helpers.customVerifyElementText(poHme.txtEditRecords, "Supervisor can add/edit/delete attendance records of subordinates");
                helpers.customClick(poHme.toggleBtn03);
                break;
            case "REPORTS_NAV":
                helpers.customClick(poHme.ddReports);
                helpers.customClick(poHme.itemEmpReports);
                helpers.customSetText(poHme.inputEmpName, "Micgael Julies");
                helpers.customSetText(poHme.inputProjectName, "QA AUTOMATION PROJECT");
                helpers.customClick(poHme.toggleBtnApprove);
                helpers.customClick(poHme.arrowBtnHide); // Hide information
                helpers.customWait("2");
                helpers.customClick(poHme.arrowBtnOpen); // Open information
                break;
            case "PROJECT_INFO_NAV":
                helpers.customClick(poHme.ddProjectInfo);
                helpers.customClick(poHme.itemCustomers);
                helpers.customVerifyElementText(poHme.titleCustomers, "Customers");
                helpers.customClick(poHme.btnAddCustomer);
                helpers.customClick(poHme.btnCancel01);
                helpers.customWait("2");
                helpers.customVerifyElementPresent(poHme.titleCustomers);
                break;
            case "PIM_PAGE_NAV":
                helpers.customClick(poHme.bnrPIM);
                helpers.customVerifyElementText(poHme.topBarTitle, "PIM");
                helpers.customVerifyElementText(poHme.titleEmpInfo, "Employee Information");
                break;
            case "EMP_STATUS_NAV":
                helpers.customVerifyElementText(poHme.lblEmployeeStatus, "Employment Status");
                helpers.customClick(poHme.ddStatus);
//                helpers.customClick(poHme.optFreelance);
                break;
            case "INCLUDE_NAV":
                helpers.customVerifyElementText(poHme.lblInclude, "Include");
                helpers.customClick(poHme.ddInclude);
                helpers.customClick(poHme.optPastEmployees);
                break;
            case "JOB_TITLE_NAV":
                helpers.customVerifyElementText(poHme.lblJobTitle, "Job Title");
                helpers.customClick(poHme.ddJobTitle);
                helpers.customClick(poHme.optJobTitle);
                helpers.customWait("2");
                break;
            case "SUB_UNIT_NAV":
                helpers.customVerifyElementText(poHme.lblSubUnit, "Sub Unit");
                helpers.customClick(poHme.ddSubUnit);
                helpers.customClick(poHme.optSubUnit);
                break;
            case "ASSIGN_CLAIM_NAV":
                helpers.customClick(poHme.bnrClaim);
                helpers.customVerifyElementText(poHme.topBarTitle, "Claim");
                helpers.customClick(poHme.btnAssignClaim);
                break;
            case "ENTER_CLAIM_DET":
                helpers.customVerifyElementText(poHme.titleClaimRequest, "Create Claim Request");
                helpers.customVerifyElementText(poHme.lblEmpName, "Employee Name");
                helpers.customSetText(poHme.inputEmpName01, "John Dan");
//                helpers.customWait("3");
//                helpers.customClick(poHme.optEmpName01);
                // Event Drop Down
                helpers.customVerifyElementText(poHme.lblEvent, "Event");
                helpers.customClick(poHme.ddEvent);
//                helpers.customClick(poHme.optAccommodation);
                // Currency Drop Down
                helpers.customVerifyElementText(poHme.lblCurrency, "Currency");
                helpers.customClick(poHme.ddCurrency);
//                helpers.customClick(poHme.optAlgerianDinar);
                helpers.customVerifyElementText(poHme.lblRemarks, "Remarks");
                helpers.customSetText(poHme.inputRemarks, "able to insert REMARKS text");
                helpers.customClick(poHme.btnCreate);
//                helpers.customVerifyElementText(poHme.popUpMsg, "Remarks");
                helpers.customVerifyElementText(poHme.errorLabel, "Required");
                break;

        }
    }

}
