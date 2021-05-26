package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class MiniCartDropdown extends BasePage {

    @FindBy(css = "button[data-ref='minicart-checkout-btn']")
    private WebElement viewCartButton;

    private TestHelper helper = new TestHelper();

    public MiniCartDropdown() {
        PageFactory.initElements(driver, this);
    }

    public void clickViewCart() {
        try {
            viewCartButton.click();
        } catch (NoSuchElementException e) {
            helper.waitForPageToLoad(driver);
            viewCartButton.click();
        }
    }
}
