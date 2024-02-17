package scenarios;

import components.TestListener;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class LoginScenario extends WebScenario {
    private static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));
    public LoginScenario(WebDriver driver) throws MalformedURLException {
        super(driver);
        this.driver = driver;
    }

    public void executeLoginCreationStep(String dataToUse) throws Exception {
        LOGGER.get().info("Execute-Login-Creation-Step <<< DATA TO USE >>>" + dataToUse);
        switch (dataToUse.toUpperCase()) {
            case "USER_LOGIN_NAV":
                helpers.customVerifyElementText(poLog.headerSwagLabs, "Swag Labs");
                helpers.customSetText(poLog.inputUsername, "standard_user");
                helpers.customSetText(poLog.inputPassword, "secret_sauce");
                helpers.customClick(poLog.btnLogin);
                helpers.customWait("3");
                break;

        }
    }

}
