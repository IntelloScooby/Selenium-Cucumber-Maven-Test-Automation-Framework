package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.TestDataReader;
import utils.TestHelper;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Constants.*;

public class StepDefs extends BasePage {

    private HomePage homePage = new HomePage();
    private BasePage basePage = new BasePage();
    private TopNavigationMenu topNavigationMenu = new TopNavigationMenu();
    private MiniCartDropdown miniCartDropdown = new MiniCartDropdown();
    private TestHelper helper = new TestHelper();
    private TestDataReader dataReader = new TestDataReader();
    private ProductCategoryListBasePage categoryListPage = new ProductCategoryListBasePage();
    private ProductListBasePage productListPage = new ProductListBasePage();
    private ReviewCartPage cartPage = new ReviewCartPage();

    private ArrayList<String> productsAddedToCart = new ArrayList<>();

    @Then("^the user is able to login successfully$")
    public void theUserIsAbleToLoginSuccessfully() {
        Assert.assertTrue(homePage.isLoginSuccessful(), "Unable to successfully login");
    }

    @Given("^the home page is displayed$")
    public void theHomePageIsDisplayed() {
        helper.waitForPageToLoad(driver);
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

    @Given("^the user is logged into the website$")
    public void theUserIsLoggedIntoTheWebsite() {
        homePage.navigateToHomePage();
        HashMap<String, String> loginDetails = dataReader.getLoginDetails(VALID_USER);
        String username = loginDetails.get(USERNAME);
        String password = loginDetails.get(PASSWORD);
        homePage.loginUser(username, password);
    }

    @When("^the user clicks on the \"([^\"]*)\" option from the top menu$")
    public void theUserClicksOnTheOptionFromTheTopMenu(String menuOption) {
        topNavigationMenu.clickOnMenuOption(menuOption);
        Assert.assertEquals(basePage.getPageName(), menuOption);
    }

    @And("^the user clicks on the \"([^\"]*)\" option from the product category list page$")
    public void theUserClicksOnTheOptionFromTheProductCategoryListPage(String categoryName) {
        helper.waitForPageToLoad(driver);
        categoryListPage.clickProductCategory(categoryName);
    }

    @Then("^the \"([^\"]*)\" product list page is displayed$")
    public void theProductListPageIsDisplayed(String pageName) {
        helper.waitForPageToLoad(driver);
        Assert.assertEquals(basePage.getPageName(), pageName);
    }

    @When("^the user adds the first \"([^\"]*)\" products to the cart$")
    public void theUserAddsTheFirstProductsToTheCart(int productCount) {
        productsAddedToCart = productListPage.addProductsToCart(productCount);
    }

    @When("^the user navigates to the cart$")
    public void theUserNavigatesToTheCart() {
        topNavigationMenu.hoverOnCartOption();
        miniCartDropdown.clickViewCart();
    }

    @Then("^the same items are displayed in the cart$")
    public void theSameItemsAreDisplayedInTheCart() {
        ArrayList<String> allProductsInCart = cartPage.getProductsInCart();
        for (String productName : productsAddedToCart) {
            boolean isProductAddedToCart = false;
            for (String productInCart : allProductsInCart) {
                if (productInCart.equals(productName)) {
                    isProductAddedToCart = true;
                    System.out.println("Product: " + productName + " is available in the cart");
                    break;
                }
            }
            Assert.assertTrue(isProductAddedToCart, productName + " is not available in the cart");
        }
    }

    @When("^the user tries to login with invalid credentials from the home page$")
    public void theUserTriesToLoginWithInvalidCredentialsFromTheHomePage() {
        HashMap<String, String> loginDetails = dataReader.getLoginDetails(INVALID_USER);
        String username = loginDetails.get(USERNAME);
        String password = loginDetails.get(PASSWORD);
        homePage.loginUser(username, password);
    }

    @Then("^the user is unable to login$")
    public void theUserIsUnableToLogin() {
        Assert.assertEquals(homePage.getLoginErrorMessage(), INVALID_LOGIN_ERROR_MESSAGE);
    }
}
