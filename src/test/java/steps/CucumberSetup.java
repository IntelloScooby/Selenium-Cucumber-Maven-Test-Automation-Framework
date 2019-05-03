package steps;

import cucumber.api.java.After;
import pages.HomePage;

public class CucumberSetup {

    @After
    public void logoffAfterScenario() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.logoffUser();
    }
}
