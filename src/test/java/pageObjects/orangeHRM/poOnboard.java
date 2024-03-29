package pageObjects.orangeHRM;

import components.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.net.MalformedURLException;

public class poOnboard extends Constants {

    private int timeout = 10;
    public poOnboard(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, this.timeout), this);
        helpers = new SeleniumHelpers(this.driver);
    }

    // login locators
    @FindBy(css = ".orangehrm-login-branding > img")
    public WebElement imgHRMLogo;
    @FindBy(css = ".oxd-text--h5")
    public WebElement headerLogin;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement inputUsername;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;
    @FindBy(css = ".oxd-button")
    public WebElement btnLogin;
    @FindBy(xpath = "//h6[contains(.,'Dashboard')]")
    public WebElement headerDashboard;
    @FindBy(css = ".oxd-alert-content-text")
    public WebElement errorLoginMsg;

    // Forgot password
    @FindBy(css = ".orangehrm-login-forgot-header")
    public WebElement linkForgotPwd;
    @FindBy(xpath = "//h6[contains(.,'Reset Password')]")
    public WebElement headerResetPwd;
    @FindBy(css = ".oxd-input")
    public WebElement inputResetUsername;
    @FindBy(css = ".oxd-button--secondary")
    public WebElement btnResetPwd;
    @FindBy(xpath = "//h6[contains(.,'Reset Password link sent successfully')]")
    public WebElement headerSuccess;

}
