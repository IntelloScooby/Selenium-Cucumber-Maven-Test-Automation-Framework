package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.MiniLoginDropdown;
import pages.TopNavigationMenu;
import utils.TestDataReader;
import utils.TestHelper;

import java.util.HashMap;

import static utils.Constants.*;

public class StepDefs extends BasePage {

    private HomePage homePage = new HomePage();
    private TopNavigationMenu topNavigationMenu = new TopNavigationMenu();
    private MiniLoginDropdown miniLoginDropdown = new MiniLoginDropdown();
    private TestHelper helper = new TestHelper();
    private TestDataReader dataReader = new TestDataReader();

    @Then("^the user is able to login successfully$")
    public void theUserIsAbleToLoginSuccessfully() {
        Assert.assertTrue(homePage.isLoginSuccessful(), "Unable to successfully login");
    }

    @Given("^the home page is displayed$")
    public void theHomePageIsDisplayed() {
        try {
            helper.waitForPageToLoad(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, HOME_PAGE_TITLE, "Home page title is not displayed correctly");
    }

    @When("^the user tries to login with valid credentials from the home page$")
    public void theUserTriesToLoginWithValidCredentialsFromTheHomePage() {
        HashMap<String, String> loginDetails = dataReader.getLoginDetails(VALID_USER);
        String username = loginDetails.get(USERNAME);
        String password = loginDetails.get(PASSWORD);
        homePage.loginUser(username, password);
    }

    @And("^the user clicks on the login menu option$")
    public void theUserClicksOnTheLoginMenuOption() {
        topNavigationMenu.clickOnLoginOption();
    }

    @And("^the mini login dropdown is displayed$")
    public void theMiniLoginDropdownIsDisplayed() {
        Assert.assertTrue(miniLoginDropdown.isLoginDropdownDisplayed(), "Mini login dropdown is not displayed");
    }

    @When("^the user tries to login with valid credentials from the mini login dropdown$")
    public void theUserTriesToLoginWithValidCredentialsFromTheMiniLoginDropdown() {
        HashMap<String, String> loginDetails = dataReader.getLoginDetails(VALID_USER);
        String username = loginDetails.get(USERNAME);
        String password = loginDetails.get(PASSWORD);
        miniLoginDropdown.loginUser(username, password);
    }
}
