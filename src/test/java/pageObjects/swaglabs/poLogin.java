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

    /** Login locators **/
    @FindBy(css = ".login_logo")
    public WebElement headerSwagLabs;

    @FindBy(css = "#user-name")
    public WebElement inputUsername;

    @FindBy(css = "#password")
    public WebElement inputPassword;

    @FindBy(css = "#login-button")
    public WebElement btnLogin;

    @FindBy(css = "*[data-test=\"error\"]")
    public WebElement msgError;


}
