package tests.swagLabs;

import base.BaseController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TC_0002Checkout extends BaseController {
    public TC_0002Checkout() throws MalformedURLException {
    }

    @Description("Scenario | Valid credentials")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03000 | Verify user able add items to cart")
    public void checkoutAddItems() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiAction.executeStep("Verify user directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");

        uiActionScenario.executeScenario("User add items to cart","ADD_ITEMS_TO_CART",null,"add_items");
        uiAction.executeStep("Verify user directed to /cart.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/cart.html");

    }
}
