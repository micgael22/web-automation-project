package tests.swagLabs;

import base.BaseController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TC_0001Login extends BaseController {
    public TC_0001Login() throws MalformedURLException {
    }

    @Description("Scenario | Valid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Login"}, description = "TC_ID=02000 | Verify user able to login with valid credentials")
    public void loginValidCredsScenarios() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiAction.executeStep("Verify page directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");
    }

    @Description("Steps | Valid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Login"}, description = "TC_ID=02001 | Verify user able to login with valid credentials")
    public void loginValidCreds() throws Exception {
        uiAction.executeStep("Verify Home page header present", "VERIFY ELEMENT TEXT", poLog.headerSwagLabs, "Swag Labs");
        uiAction.executeStep("User Enter username", "INPUT_TEXT", poLog.inputUsername, "standard_user");
        uiAction.executeStep("User Enter password", "INPUT_TEXT", poLog.inputPassword, "secret_sauce");
        uiAction.executeStep("User click on login button","CLICK",poLog.btnLogin,null);
        uiAction.executeStep("Custom wait for page to load","WAIT_PAGE_LOADED",null,null);
        uiAction.executeStep("Verify page directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");
    }

    @Description("Steps | Invalid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("Swag Labs")
    @Test(groups = {"Login"},description = "TC_ID=02002 | Verify user unable to login with invalid credentials")
    public void loginInvalidCreds() throws Exception {
        uiAction.executeStep("Verify Home page header present", "VERIFY ELEMENT TEXT", poLog.headerSwagLabs, "Swag Labs");
        uiAction.executeStep("User Enter username", "INPUT_TEXT", poLog.inputUsername, "inv@alidUs3rName");
        uiAction.executeStep("User Enter password", "INPUT_TEXT", poLog.inputPassword, "f@a!lp@ssw0rd");
        uiAction.executeStep("User click on login button","CLICK",poLog.btnLogin,null);
        uiAction.executeStep("Wait added","wait",null,"3");
        uiAction.executeStep("Verify error message", "VERIFY ELEMENT TEXT", poLog.headerSwagLabs, "Epic sadface: Username and password do not match any user in this service");

    }



}
