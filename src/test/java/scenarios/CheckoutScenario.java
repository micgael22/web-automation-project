package scenarios;

import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class CheckoutScenario extends WebScenario{
    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));
    public CheckoutScenario(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void checkoutProcess(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Checkout-Step <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "ADD_ITEMS":
                helpers.customVerifyElementText(poCheck.headerProd, "Products");
                helpers.customClick(poCheck.btnAddBike);
                helpers.customClick(poCheck.btnAddBPack);
                helpers.scrollToElement(poCheck.btnAddRShirt);
                helpers.customClick(poCheck.btnAddRShirt);
                helpers.customClick(poCheck.iconCart);
                helpers.customWait("3");
                break;

        }
    }
}
