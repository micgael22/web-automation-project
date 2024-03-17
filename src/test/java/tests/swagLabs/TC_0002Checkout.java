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

        uiActionScenario.executeScenario("User add items to cart","CHECKOUT_NAVIGATION",null,"add_items");
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

    @Description("Remove items from cart process")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03002 | Verify user able to remove items from cart")
    public void checkoutTC_removeItems() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiActionScenario.executeScenario("User add items to cart","CHECKOUT_NAVIGATION",null,"add_items");

        uiAction.executeStep("Verify (Red T-Shirt) is present", "VERIFY_ELEMENT_TEXT", poCheck.itemTitle00, "Test.allTheThings() T-Shirt (Red)");
        uiAction.executeStep("User remove item 00","CLICK",poCheck.btnRemove00,null);
        uiAction.executeStep("Verify (Backpack) is present", "VERIFY_ELEMENT_TEXT", poCheck.itemTitle01, "Sauce Labs Backpack");
        uiAction.executeStep("User remove item 01","CLICK",poCheck.btnRemove01,null);
        uiAction.executeStep("Verify (Bike Light ) is present", "VERIFY_ELEMENT_TEXT", poCheck.itemTitle02, "Sauce Labs Bike Light");
        uiAction.executeStep("User remove item 02","CLICK",poCheck.btnRemove02,null);

        uiAction.executeStep("User click on continue shopping Btn","CLICK",poCheck.btnContShop,null);
        uiAction.executeStep("Verify user directed to /inventory.html","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/inventory.html");

    }

    @Description("Overview before checkout")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03002 | Verify user able to overview information before checkout")
    public void checkoutTC_overview() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiActionScenario.executeScenario("User add items to cart","CHECKOUT_NAVIGATION",null,"add_items");
        uiActionScenario.executeScenario("Verify items are added to cart","CHECKOUT_NAVIGATION",null,"verify_cart_items");
        uiActionScenario.executeScenario("User able to enter personal information","CHECKOUT_NAVIGATION",null,"enter_user_details");

        uiAction.executeStep("Verify user directed to /checkout-step-two","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/checkout-step-two.html");
        uiActionScenario.executeScenario("User able to overview - checkout information","CHECKOUT_NAVIGATION",null,"overview_checkout");
    }

    @Description("User complete order")
    @Severity(SeverityLevel.MINOR)
    @Story("SWAG LABS")
    @Test(groups = {"Checkout"}, description = "TC_ID=03002 | Verify user able to place order successfully")
    public void checkoutTC_completeOrder() throws Exception {
        uiActionScenario.executeScenario("Login with user a valid details","LOGIN_VALID_CREDS",null,"user_login_nav");
        uiActionScenario.executeScenario("User add items to cart","CHECKOUT_NAVIGATION",null,"add_items");
        uiActionScenario.executeScenario("Verify items are added to cart","CHECKOUT_NAVIGATION",null,"verify_cart_items");
        uiActionScenario.executeScenario("User able to enter personal information","CHECKOUT_NAVIGATION",null,"enter_user_details");

        uiAction.executeStep("Verify user directed to /checkout-step-two","VERIFY_CORRECT_PAGE_URL_CONTAINS",null,"/checkout-step-two.html");
        uiActionScenario.executeScenario("User able to overview - checkout information","CHECKOUT_NAVIGATION",null,"overview_checkout");
        uiActionScenario.executeScenario("User able to checkout items successfully","CHECKOUT_NAVIGATION",null,"complete_order");
    }

}
