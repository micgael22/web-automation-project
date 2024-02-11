package pageObjects;

import components.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.net.MalformedURLException;

public class poLoginPage extends Constants {

    private int timeout = 10;
    public poLoginPage(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, this.timeout), this);
        helpers = new SeleniumHelpers(this.driver);
    }


    @FindBy(xpath = "//input[@placeholder='example@gmail.com']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='RealPassword2']")
    public WebElement inputPassword;

    @FindBy(css = ".login-button")
    public WebElement btnSignIn;

    @FindBy(css = "#Automation_Practice")
    public WebElement headerQA;

    @FindBy(xpath = "//a[contains(text(),'Big page with many elements')]")
    public WebElement linkBigPage;

    @FindBy(css = "#Skills_Improved")
    public WebElement headerSkills;




}
