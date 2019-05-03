package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniLoginDropdown extends BasePage {

//    dropdown = header-login-panel  -- data-ref
//    username = loginId, input
//    password = password
//    css = "div[data-ref='header-login-panel']"
//    className = "NavTiles__DropDown-s1yk6sys-3 bGxpqu"



    @FindBy(css = "div[data-ref='header-login-panel']")
    private WebElement loginDropdown;

    @FindBy(name = "loginId")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "div[data-ref='navLink-login']")
    private WebElement loginOption;

    public MiniLoginDropdown() {
        PageFactory.initElements(driver, this);
    }

    private Actions actions = new Actions(driver);

    public boolean isLoginDropdownDisplayed() {
        if (!loginDropdown.isDisplayed()){
            actions.moveToElement(loginOption).perform();
        }
        return loginDropdown.isDisplayed();
    }

    public void loginUser(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
