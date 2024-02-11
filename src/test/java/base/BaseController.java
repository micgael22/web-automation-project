package base;

import components.Action;
import components.Constants;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.poLoginPage;
import scenarios.AppScenario;
import scenarios.LoginScenario;
import utilities.GeneralModels;
import utilities.SeleniumHelpers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class BaseController extends Constants implements ITest{
    public AppScenario uiActionScenario;
    public LoginScenario loginSC;
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class.getSimpleName());
    private static String testName = "";
    public BaseController() throws MalformedURLException {
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) throws IOException {
        BASEURL = context.getCurrentXmlTest().getParameter("WEB_URL");
        TARGET = context.getCurrentXmlTest().getParameter("TARGET");
        BROWSER = context.getCurrentXmlTest().getParameter("BROWSER_TYPE");
        PROJECTNAME = context.getCurrentXmlTest().getParameter("WEB_NAME");
        LOGGER.info("============= BEFORE SUITE =============") ;
    }

    @BeforeTest
    public void beforeTest(ITestContext iContext) throws IOException {
        LOGGER.info("====== LOG @beforeTest | CONTEXT  : " + iContext.getCurrentXmlTest().getClasses().toString().toLowerCase());
        if(iContext.getCurrentXmlTest().getClasses().toString().toLowerCase().contains("ultimateqa") && TARGET == null || BASEURL == null){
            PROJECTNAME = "ULTIMATEQA";
            BASEURL = "https://ultimateqa.com/automation";
            // Able to switch
        }else if(iContext.getCurrentXmlTest().getClasses().toString().toLowerCase().contains("PROJECT-NAME2nd")){
            PROJECTNAME = "PROJECT-NAME2nd";
            BASEURL = "secondwebsite.com";
        }
        LOGGER.info("============= BEFORE TEST =============") ;
    }

    @BeforeClass
    public void beforeClass() throws IOException {
        LOGGER.info("============= BEFORE CLASS =============") ;
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        this.parametersTestng();
        driver = new DriverFactory().createInstance(BROWSER,TARGET, PROJECTNAME);
        driver.get(BASEURL);
        driver.manage().window().maximize();

        interval = Duration.ofSeconds(1);
        timeout = Duration.ofSeconds(10);
        verificationWait = new WebDriverWait(driver, timeout);

        uiAction = new Action(getDriver());
        uiActionScenario = new AppScenario(getDriver());
        helpers = new SeleniumHelpers(getDriver());
        general = new GeneralModels(getDriver());

        poLog = new poLoginPage(getDriver());
        loginSC = new LoginScenario(getDriver());
        LOGGER.info("============= BEFORE METHOD =============") ;
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext context) throws IOException {
        boolean driverHasQuit = false;
        if (!driverHasQuit) {
            driver.close();
        }
        LOGGER.info("============= AFTER METHOD =============") ;
    }
    @AfterClass
    public void afterClass() throws IOException {
        LOGGER.info("============= AFTER CLASS =============") ;
    }
    @AfterTest
    public void afterTest() throws IOException {
        LOGGER.info("============= AFTER TEST =============") ;
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException {
        LOGGER.info("============= AFTERSUITE =============") ;
    }

    private void parametersTestng() {
        if (BASEURL == null || BASEURL.length() == 0){
            BASEURL = System.getProperty("WEB_URL");
        }
        if (TARGET == null || TARGET.length() == 0){
            TARGET = System.getProperty("TARGET");
        }
        if (BROWSER == null || BROWSER.length() == 0){
            BROWSER = System.getProperty("BROWSER_TYPE");
        }
        if (PROJECTNAME == null || PROJECTNAME.length() == 0){
            PROJECTNAME = System.getProperty("WEB_NAME");
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }
    @Override
    public String getTestName() {
        return testName;
    }

}
