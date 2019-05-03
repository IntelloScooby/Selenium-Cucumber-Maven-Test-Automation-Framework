package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

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

    private WebDriverWait wait = new WebDriverWait(driver, 5);

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
            //Do nothing
        }
    }

    public void navigateToHomePage() {
        if (!driver.getCurrentUrl().equals("https://www.officeworks.com.au")) {
            driver.get("https://www.officeworks.com.au");
        }
    }
}
