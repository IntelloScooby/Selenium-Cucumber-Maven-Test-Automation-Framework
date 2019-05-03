package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationMenu extends BasePage {

    @FindBy(css = "div[data-ref='navLink-login']")
    private WebElement loginOption;

    private Actions actions = new Actions(driver);

    public TopNavigationMenu() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginOption() {
        actions.moveToElement(loginOption).perform();
    }
}
