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
                helpers.customSetText(poLog.inputEmail, "example@gmail.com");
                helpers.customSetText(poLog.inputPassword, "qwerty12345");
                helpers.customClick(poLog.btnSignIn);
                helpers.customWait("5");
                break;
            case "USER_PAGE_SWITCH":
                helpers.customVerifyElementText(poLog.headerQA, "Automation Practice");
                helpers.customClick(poLog.linkBigPage);
                helpers.customWait("5");
                helpers.customVerifyElementText(poLog.headerSkills, "Skills Improved:");
                break;
        }
    }

}
