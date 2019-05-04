package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationMenu extends BasePage {

    @FindBy(css = "div[data-ref='navLink-login']")
    private WebElement loginOption;

    @FindBy(css = "div[data-ref='navLink-cart']")
    private WebElement cartOption;

    private Actions actions = new Actions(driver);

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
}
