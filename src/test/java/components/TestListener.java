package components;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.net.MalformedURLException;
import java.util.logging.Logger;

public class TestListener implements ITestListener {

    public String STEP_DESCRIPTION;
    public String SCENARIO_DESCRIPTION;
    public static final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> Logger.getLogger(TestListener.class.getName()));

    public TestListener() throws MalformedURLException {
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.get().severe(" ======= TEST EXECUTION " + result.getTestContext().getName() + " -- " + result.getTestContext().getClass().getSimpleName() + " FAILED ======= ");
    }

    public void onStart(ITestContext context) {
        LOGGER.get().info(" ======= TEST " + context.getName() + " STARTED ======= ");
    }

    public void onFinish(ITestContext context) {
        LOGGER.get().info(("======= TEST " + context.getName() + " ENDING ======= "));
    }

    public void onTestStart(ITestResult result) {
        LOGGER.get().info(("======= RUNNING THE TEST FLOW " + result.getTestContext().getName() + " -- " + result.getTestContext().getClass().getSimpleName() + " ======= "));
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.get().info("======= EXECUTED " + result.getTestContext().getName() + " -- " + result.getTestContext().getClass().getSimpleName() + " SUCCESSFULLY ======= ");
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.get().warning("======= TEST " + result.getTestContext().getName() + " -- " + result.getTestContext().getClass().getSimpleName() + " SKIPPED ======= ");
    }

}
