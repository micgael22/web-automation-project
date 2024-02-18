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

    @Description("Item to cart process")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03000 | Verify user able add items to cart")
    public void checkoutTC_AddItems() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiAction.executeStep("Verify user directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");

        uiActionScenario.executeScenario("User add items to cart","ADD_ITEMS_TO_CART",null,"add_items");
        uiAction.executeStep("Verify user directed to /cart.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/cart.html");

    }

    @Description("Item details process")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03001 | Verify user able to see item to details")
    public void checkoutTC_ItemDetails() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");

        uiAction.executeStep("Verify products header", "VERIFY_ELEMENT_TEXT", poCheck.headerProd, "Products");
        uiAction.executeStep("User select item","CLICK",poCheck.selItemBPack,null);
        uiAction.executeStep("Verify item -name", "VERIFY_ELEMENT_TEXT", poCheck.itemName, "Sauce Labs Backpack");
        uiAction.executeStep("Verify item -price", "VERIFY_ELEMENT_TEXT", poCheck.itemPrice, "$29.99");
        uiAction.executeStep("Verify item -present","VERIFY_ELEMENT_PRESENT",poCheck.itemImg,null);
        uiAction.executeStep("User clicks on Back to home button","CLICK",poCheck.btnBack,null);
        uiAction.executeStep("Verify user directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");

    }
}
