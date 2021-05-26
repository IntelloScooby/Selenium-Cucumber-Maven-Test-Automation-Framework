package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(css = "input[data-ref='login-username-input']")
    private WebElement usernameField;

    @FindBy(css = "input[data-ref='login-password-input']")
    private WebElement passwordField;

    @FindBy(css = "button[label='Log in']")
    private WebElement loginButton;

    @FindBy(css = "div[data-ref='login-panel-error-toast']")
    private WebElement errorToast;

    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorToast));
        return errorToast.getText();
    }

}
