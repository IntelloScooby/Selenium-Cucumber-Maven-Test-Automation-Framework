package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.SetupAndTearDown;

@CucumberOptions
        (
                plugin = "json:target/cucumber-report.json",
                glue = {"steps"}
                , features = {"src/test/resources/features/Login.feature"}
                , format = {"pretty"}
        )
public class LoginTestRunner extends SetupAndTearDown {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            description = "Test runner method for Login feature.",
            dataProvider = "features"
    )
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        this.testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return this.testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}