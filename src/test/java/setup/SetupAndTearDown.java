package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import utils.TestReportGenerator;

public class SetupAndTearDown {

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver-74");
        BasePage.driver = new ChromeDriver();
        BasePage.driver.get("https://www.officeworks.com.au");
    }

    @AfterSuite
    public void tearDown() {
        TestReportGenerator.EXTENT_REPORTS.flush();
        TestReportGenerator.EXTENT_REPORTS.close();
        BasePage.driver.quit();
    }

}