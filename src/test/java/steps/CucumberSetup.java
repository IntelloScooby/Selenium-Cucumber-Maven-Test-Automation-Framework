package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.TopNavigationMenu;
import utils.TestReportGenerator;

import static utils.TestReportGenerator.EXTENT_REPORTS;
import static utils.TestReportGenerator.EXTENT_TEST;

public class CucumberSetup {

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();
        EXTENT_TEST = EXTENT_REPORTS.startTest(scenarioName, "");
    }

    @After
    public void afterScenario(Scenario scenario) {

        TopNavigationMenu topNavigationMenu = new TopNavigationMenu();

        //take screen shot right on failure, keep this at top
        TestReportGenerator reporter = new TestReportGenerator();
        reporter.reportScenarioStatus(scenario);

        EXTENT_REPORTS.endTest(EXTENT_TEST);

        if (scenario.getSourceTagNames().contains("@AfterScenarioLogoff")) {
            topNavigationMenu.logoffUser();
        }

    }
}
