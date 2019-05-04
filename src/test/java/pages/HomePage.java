package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.logging.Level;

import static utils.TestReportGenerator.LOGGER;

public class HomePage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(css = "input[data-ref='home-login-password']")
    private WebElement passwordField;

    @FindBy(css = "button[data-ref='home-login-button']")
    private WebElement loginButton;

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(linkText = "My Account")
    private WebElement myAccountButton;

    @FindBy(css = "div[class^='ToolTip__Popover']")
    private WebElement errorToolTip;

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ConfigReader config = new ConfigReader();

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        ArrayList<WebElement> accountButtons = new ArrayList<>();
        accountButtons.add(logoutLink);
        accountButtons.add(myAccountButton);
        wait.until(ExpectedConditions.visibilityOfAllElements(accountButtons));

        return logoutLink.isDisplayed() && myAccountButton.isDisplayed();
    }

    public void logoffUser() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutLink));
            if (logoutLink.isDisplayed()) {
                logoutLink.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            LOGGER.log(Level.INFO, "User is already logged off");
        }
    }

    public void navigateToHomePage() {
        if (!driver.getCurrentUrl().equals(config.getBaseUrl())) {
            driver.get(config.getBaseUrl());
        }
    }

    public String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorToolTip));
        return errorToolTip.getText();
    }
}
