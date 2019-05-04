package utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import pages.BasePage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constants.TEST_REPORT_FILE_PATH;

public class TestReportGenerator {

    public static final ExtentReports EXTENT_REPORTS = new ExtentReports(TEST_REPORT_FILE_PATH, true, DisplayOrder.OLDEST_FIRST);
    public static ExtentTest EXTENT_TEST;

    public static final Logger LOGGER = Logger.getLogger("UI Automation");

    private TestHelper helper = new TestHelper();

    public void reportScenarioStatus(Scenario scenario) {
        String scenarioStatus = scenario.getStatus();
        if (scenarioStatus.equals("passed")) {
            EXTENT_TEST.log(LogStatus.PASS, "");
        } else {
            String screenshot = "./screenshots/" + helper.takeScreenshot(BasePage.driver);
            EXTENT_TEST.log(LogStatus.FAIL, EXTENT_TEST.addScreenCapture(screenshot));
        }
        LOGGER.log(Level.INFO, "Scenario STATUS: " + scenarioStatus);
    }
}
