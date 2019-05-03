package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import utils.ConfigReader;
import utils.TestReportGenerator;

import java.util.logging.Logger;

public class SetupAndTearDown {

    @BeforeSuite
    public void setup() {

        ConfigReader config = new ConfigReader();

        switch (config.getBrowser()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/chromedriver-74");
                BasePage.driver = new ChromeDriver();
                break;

            case "firefox":
//                Add firefox driver
                break;

            case "safari":
//                Add Safari driver
                break;

            default:
                Logger.getLogger("Incorrect browser name in config");
                System.exit(1);
        }

        BasePage.driver.get(config.getBaseUrl());
    }

    @AfterSuite
    public void tearDown() {
        TestReportGenerator.EXTENT_REPORTS.flush();
        TestReportGenerator.EXTENT_REPORTS.close();
        BasePage.driver.quit();
    }

}