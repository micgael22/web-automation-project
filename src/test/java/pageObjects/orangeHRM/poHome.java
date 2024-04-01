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

}
