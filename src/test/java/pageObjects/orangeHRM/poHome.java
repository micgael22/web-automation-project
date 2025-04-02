package pageObjects.orangeHRM;

import components.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.net.MalformedURLException;

public class poHome extends Constants {

    private int timeout = 10;
    public poHome(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, this.timeout), this);
        helpers = new SeleniumHelpers(this.driver);
    }

    // dashboard locators
    @FindBy(xpath = "//p[contains(.,'Employees on Leave Today')]")
    public WebElement chartEmpLeave;
    @FindBy(css = ".bi-gear-fill")
    public WebElement iconSettings;
    @FindBy(css = ".oxd-label")
    public WebElement lblAccess;
    @FindBy(css = ".oxd-switch-input")
    public WebElement toggleBtnAccess;
    @FindBy(css = ".oxd-button--secondary")
    public WebElement btnSave;
    @FindBy(css = ".oxd-toast")
    public WebElement popUpSuccess;
    @FindBy(css = ".oxd-text--toast-message")
    public WebElement popUpSuccessMsg;

    //banner responsive
    @FindBy(css = ".oxd-brand-banner > img")
    public WebElement logoBannerImg;
    @FindBy(css = ".oxd-main-menu-button")
    public WebElement btnOpenCloseBanner;
    @FindBy(css = ".oxd-input")
    public WebElement bannerSearch;
    @FindBy(css = ".oxd-main-menu-item")
    public WebElement bnrSearchedItem;
    @FindBy(xpath = "//h6[contains(.,'Personal Details')]")
    public WebElement headerPersonalInfo;
    //

    @FindBy(css = ".oxd-topbar-header-title")
    public WebElement topBarTitle;
    @FindBy(css = ".oxd-text--h6")
    public WebElement headerMntce;
    @FindBy(css = ".oxd-button--ghost")
    public WebElement btnCancel;
    @FindBy(linkText = "Admin")
    public WebElement bnrAdmin;
    @FindBy(linkText = "PIM")
    public WebElement bnrPIM;
    @FindBy(linkText = "Leave")
    public WebElement bnrLeave;
    @FindBy(linkText = "Time")
    public WebElement bnrTime;
    @FindBy(linkText = "Recruitment")
    public WebElement bnrRecruitment;
    @FindBy(linkText = "My Info")
    public WebElement bnrMyInfo;
    @FindBy(linkText = "Performance")
    public WebElement bnrPerformance;
    @FindBy(linkText = "Dashboard")
    public WebElement bnrDashboard;
    @FindBy(linkText = "Directory")
    public WebElement bnrDirectory;
    @FindBy(linkText = "Maintenance")
    public WebElement bnrMaintenance;
    @FindBy(linkText = "Claim")
    public WebElement bnrClaim;
    @FindBy(linkText = "Buzz")
    public WebElement bnrBuzz;

    // Time sheets
    @FindBy(xpath = "//li[contains(.,'Timesheets ')]")
    public WebElement ddTSheets;
    @FindBy(linkText = "My Timesheets")
    public WebElement itemMyTSheets;
    @FindBy(css = ".bi-calendar")
    public WebElement iconCalender;
    @FindBy(css = ".oxd-calendar-selector-month-selected > .oxd-icon")
    public WebElement ddMonth;
    @FindBy(css = ".oxd-calendar-dropdown--option:nth-child(4)")
    public WebElement selectMonth;
    @FindBy(css = ".oxd-calendar-date-wrapper:nth-child(16) > .oxd-calendar-date")
    public WebElement selectDate;
    @FindBy(css = ".oxd-alert-content-text")
    public WebElement txtNoTimeSheets;
    // attendance
    @FindBy(xpath = "//span[contains(.,'Attendance ')]")
    public WebElement ddAttendance;
    @FindBy(linkText = "Configuration")
    public WebElement itemConfig;
    @FindBy(xpath = "//p[contains(.,'Employee can change current time when punching in/out')]")
    public WebElement txtChangeTime;
    @FindBy(css = ".orangehrm-attendance-field-row:nth-child(1) .oxd-switch-input")
    public WebElement toggleBtn01;
    @FindBy(xpath = "//p[contains(.,'Employee can edit/delete own attendance records')]")
    public WebElement txtDeleteRecords;
    @FindBy(css = ".orangehrm-attendance-field-row:nth-child(2) .oxd-switch-input")
    public WebElement toggleBtn02;
    @FindBy(xpath = "//p[contains(.,'Supervisor can add/edit/delete attendance records of subordinates')]")
    public WebElement txtEditRecords;
    @FindBy(css = ".orangehrm-attendance-field-row:nth-child(3) .oxd-switch-input")
    public WebElement toggleBtn03;
    // reports
    @FindBy(css = ".oxd-topbar-body-nav-tab:nth-child(3) > .oxd-topbar-body-nav-tab-item") // x = //li[contains(.,'Reports ')]
    public WebElement ddReports;
    @FindBy(linkText = "Employee Reports")
    public WebElement itemEmpReports;
    @FindBy(xpath = "//div/div[2]/div/div/input") // unstable and duplicate elements
    public WebElement inputEmpName;
    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div/div/input") // unstable and duplicate elements
    public WebElement inputProjectName;
    @FindBy(css = ".oxd-switch-input")
    public WebElement toggleBtnApprove;
    @FindBy(css = ".bi-caret-up-fill")
    public WebElement arrowBtnHide; // css=.oxd-icon-button > .bi-caret-down-fill
    @FindBy(css = ".oxd-icon-button > .bi-caret-down-fill")
    public WebElement arrowBtnOpen;
    //Project Info
    @FindBy(xpath = "//span[contains(.,'Project Info ')]")
    public WebElement ddProjectInfo;
    @FindBy(linkText = "Customers")
    public WebElement itemCustomers;
    @FindBy(css = ".orangehrm-main-title")
    public WebElement titleCustomers;
    @FindBy(css = ".oxd-button")
    public WebElement btnAddCustomer;
    @FindBy(css = ".oxd-button--ghost")
    public WebElement btnCancel01;

}
