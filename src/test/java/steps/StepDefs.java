package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;

import static utils.Constants.HOME_PAGE_TITLE;

public class StepDefs {

    WebDriver webDriver = BasePage.driver;
    HomePage homePage = new HomePage(webDriver);

    @Then("^the user is able to login successfully$")
    public void theUserIsAbleToLoginSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the home page is displayed$")
    public void theHomePageIsDisplayed() {
        String actualPageTitle = webDriver.getTitle();
        Assert.assertEquals(actualPageTitle, HOME_PAGE_TITLE, "Home page title is not displayed correctly");
    }

    @When("^the user tries to login with valid credentials from the home page$")
    public void theUserTriesToLoginWithValidCredentialsFromTheHomePage() {
        String username = "testmail@grr.la";
        String password = "Welcome@123";
        homePage.loginUser(username, password);
    }

    @And("^the user hover on the login menu option$")
    public void theUserHoverOnTheLoginMenuOption() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the mini login dropdown is displayed$")
    public void theMiniLoginDropdownIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user tries to login with valid credentials from the mini login dropdown$")
    public void theUserTriesToLoginWithValidCredentialsFromTheMiniLoginDropdown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
