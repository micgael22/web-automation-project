package scenarios;

import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class CheckoutScenario_SL extends WebScenario{
    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));
    public CheckoutScenario_SL(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void checkoutProcess(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Checkout-Steps <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "ADD_ITEMS":
                helpers.customVerifyElementText(poCheck.headerProd, "Products");
                helpers.customClick(poCheck.btnAddBike);
                helpers.customClick(poCheck.btnAddBPack);
                helpers.scrollToElement(poCheck.btnAddRShirt);
                helpers.customClick(poCheck.btnAddRShirt);
                helpers.customClick(poCheck.iconCart);
                helpers.customWait("2");
                break;
            case "VERIFY_CART_ITEMS":
                helpers.customVerifyElementText(poCheck.titleCart, "Your Cart");
                helpers.customVerifyElementText(poCheck.itemTitle00, "Test.allTheThings() T-Shirt (Red)");
                helpers.customVerifyElementText(poCheck.itemTitle01, "Sauce Labs Backpack");
                helpers.customVerifyElementText(poCheck.itemTitle02, "Sauce Labs Bike Light");
                helpers.customClick(poCheck.btnCheckout);
                helpers.customWait("2");
                break;
            case "ENTER_USER_DETAILS":
                helpers.customVerifyElementText(poCheck.titleInformation, "Checkout: Your Information");
                helpers.customSetText(poCheck.inputFirstname, "GENERATED NAME");
                helpers.customSetText(poCheck.inputLastname, "GENERATED NAME");
                helpers.customSetText(poCheck.inputZipCode, "4057");
                helpers.customClick(poCheck.btnContinue);
                helpers.customWait("2");
                break;
            case "OVERVIEW_CHECKOUT":
                helpers.customVerifyElementText(poCheck.titleOverview, "Checkout: Overview");
                helpers.customVerifyElementText(poCheck.lblPayment, "Payment Information");
                helpers.customVerifyElementText(poCheck.lblShipping, "Shipping Information");
                helpers.customVerifyElementText(poCheck.lblPrice, "Price Total");
                helpers.customVerifyElementPresent(poCheck.lblTaxAmount);
                helpers.customVerifyElementPresent(poCheck.totalAmount);
                helpers.customClick(poCheck.btnFinish);
                helpers.customWait("3");
                break;
            case "COMPLETE_ORDER":
                helpers.customVerifyElementText(poCheck.h1Success, "Thank you for your order!");
                helpers.customVerifyElementText(poCheck.txtSuccess, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
                helpers.customVerifyElementPresent(poCheck.btnBackProducts);
                helpers.customWait("2");
                break;

        }
    }
}
