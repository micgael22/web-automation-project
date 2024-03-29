package tests.swagLabs;

import base.BaseConfiguration;
import base.BaseController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

import static base.BaseResources.swagLabUser;

public class TC_0003_Fail extends BaseController {

    Properties propUserDetails;
    public TC_0003_Fail() throws MalformedURLException {

        propUserDetails = BaseConfiguration.setCustomProperties(swagLabUser("creds.swaglab.user00").toAbsolutePath().toString());
    }
    @Description("Text not present")
    @Severity(SeverityLevel.MINOR)
    @Story("Swag Labs")
    @Test(groups = {"testFAIL"}, description = "TC_ID=04001 | Verify text not present")
    public void verify_item_fail() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"swaglab.user00");

    }

    @Description("locator not present")
    @Severity(SeverityLevel.MINOR)
    @Story("Swag Labs")
    @Test(groups = {"testFAIL"}, description = "TC_ID=04002 | Unable to click on locator")
    public void clickable_button_fail() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"swaglab.user00");
        uiActionScenario.executeScenario("User add items to cart","CHECKOUT_NAVIGATION",null,"add_items");
        uiAction.executeStep("Verify (Red T-Shirt) is present", "VERIFY_ELEMENT_TEXT", poCheck.itemTitle00, "Test.allTheThings() T-Shirt (Red)");
        uiAction.executeStep("User remove item 00","CLICK",poCheck.itemPrice,null);
        uiAction.executeStep("Verify (Backpack) is present", "VERIFY_ELEMENT_TEXT", poCheck.itemTitle01, "Sauce Labs Backpack");
    }

    @Description("Incorrect URL")
    @Severity(SeverityLevel.MINOR)
    @Story("Swag Labs")
    @Test(groups = {"testFAIL"}, description = "TC_ID=04003 | Verify incorrect URL")
    public void verify_url_fail() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"swaglab.user00");
        uiAction.executeStep("Verify user directed to /checkout-step-two","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/checkout-step-two.html");
        uiActionScenario.executeScenario("User able to overview - checkout information","CHECKOUT_NAVIGATION",null,"overview_checkout");
    }
}
