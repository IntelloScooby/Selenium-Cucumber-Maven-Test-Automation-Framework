package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.NoSuchElementException;
import pages.HomePage;
import pages.MiniCartDropdown;
import pages.ReviewCartPage;
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

        HomePage homePage = new HomePage();
        ReviewCartPage cartPage = new ReviewCartPage();
        TopNavigationMenu topNavigationMenu = new TopNavigationMenu();
        MiniCartDropdown miniCart = new MiniCartDropdown();

        //take screen shot right on failure, keep this at top
        TestReportGenerator reporter = new TestReportGenerator();
        reporter.reportScenarioStatus(scenario);

        EXTENT_REPORTS.endTest(EXTENT_TEST);

        if (scenario.getSourceTagNames().contains("@AfterScenarioLogoff")) {
            homePage.navigateToHomePage();
            homePage.logoffUser();
        }

        if (scenario.getSourceTagNames().contains("@AfterScenarioEmptyCart")) {
            try {
                cartPage.emptyCart();
            } catch (NoSuchElementException e) {
                topNavigationMenu.hoverOnCartOption();
                miniCart.clickViewCart();
                cartPage.emptyCart();
            }
        }

    }
}
