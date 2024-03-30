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

}
