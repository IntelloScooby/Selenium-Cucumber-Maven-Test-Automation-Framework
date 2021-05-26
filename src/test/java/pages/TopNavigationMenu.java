package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

import static utils.TestReportGenerator.LOGGER;

public class TopNavigationMenu extends BasePage {

    @FindBy(css = "span[class^='MenuButton__Button']")
    private WebElement loginMenuOption;

    @FindBy(css = "button[data-ref='identity-login-button']")
    private WebElement loginMenuButton;

    @FindBy(id = "header-myaccount-tile")
    private WebElement myAccountMenuOption;

    @FindBy(css = "button[data-ref='identity-logout-button']")
    private WebElement logoutMenuButton;

    @FindBy(id = "header-cart-tile")
    private WebElement cartOption;

    @FindBy(css = "div[aria-label='Navigation list']")
    private WebElement megaMenu;

    private Actions actions = new Actions(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public TopNavigationMenu() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnMenuOption(String menuOption) {
        driver.findElement(By.linkText(menuOption)).click();
    }

    public void hoverOnCartOption() {
        actions.moveToElement(cartOption).perform();
        cartOption.click();
    }

    public void navigateToLoginPage() {
        actions.moveToElement(loginMenuOption).perform();
        actions.moveToElement(loginMenuButton).click().perform();
    }

    public boolean isMyAccountButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(myAccountMenuOption));

        return myAccountMenuOption.isDisplayed();
    }

    public void logoffUser() {
        if (isMyAccountButtonDisplayed()) {
            actions.moveToElement(myAccountMenuOption).perform();
            actions.moveToElement(logoutMenuButton).click().perform();
        } else {
            LOGGER.log(Level.INFO, "User is already logged off");
        }
    }
}
