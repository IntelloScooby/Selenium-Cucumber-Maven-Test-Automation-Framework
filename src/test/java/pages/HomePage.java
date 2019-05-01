package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[data-ref='home-login-button']")
    private WebElement loginButton;
//
//    private static final String PAGE_TITLE = "Office Supplies, Stationery & Office Furniture at the Lowest Prices | Officeworks";
//    private static final String PAGE_URL = "https://www.officeworks.com.au/";

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void loginUser(String userName, String password) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
