package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import pageObjects.swaglabs.poCheckout;
import pageObjects.swaglabs.poLogin;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import static base.BaseResources.*;

public class Constants extends TestListener{

    public Constants() throws MalformedURLException {
        super();
    }
    public WebDriver driver;
    public poLogin poLog;
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

    /** users properties path **/
    public static Properties prop;
    public String SL_USER_DETAILS_00 = swagLabUser00().toAbsolutePath().toString();
    public String SL_USER_DETAILS_01 = swagLabUser01().toAbsolutePath().toString();
    public String SL_USER_DETAILS_02 = swagLabUser02().toAbsolutePath().toString();

    //     SCREENSHOT / REPORT PATH
    public static String PATH_USER_DIR = System.getProperty("user.dir");
    public static String FILEPATHSEPARATOR = System.getProperty("file.separator");
    public  String PATH_TO_REPORTS = "src" + FILEPATHSEPARATOR +
                                    "test" + FILEPATHSEPARATOR +
                                    "resources" + FILEPATHSEPARATOR +
                                    "reports" + FILEPATHSEPARATOR;

}
