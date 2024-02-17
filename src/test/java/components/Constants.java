package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import pageObjects.poCheckout;
import pageObjects.poLoginPage;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;
import java.net.MalformedURLException;
import java.time.Duration;

public class Constants extends TestListener{

    public Constants() throws MalformedURLException {
        super();
    }
    public WebDriver driver;
    public poLoginPage poLog;
    public poCheckout poCheck;
    public Action uiAction;
    public Duration interval;
    public Duration timeout;
    public GeneralModels general;
    public SeleniumHelpers helpers;
    public static String PROJECTNAME ;
    public static String BROWSER;
    public static String BASEURL ;
    public static String TARGET ;
    public FluentWait<? extends WebDriver> verificationWait;

    //    public static Properties prop;
//     SCREENSHOT / REPORT PATH
    public static String PATH_USER_DIR = System.getProperty("user.dir");
    public static String FILEPATHSEPARATOR = System.getProperty("file.separator");
    public  String PATH_TO_REPORTS = "src" + FILEPATHSEPARATOR + "test"
            + FILEPATHSEPARATOR + "resources" + FILEPATHSEPARATOR + "reports" + FILEPATHSEPARATOR;

}
