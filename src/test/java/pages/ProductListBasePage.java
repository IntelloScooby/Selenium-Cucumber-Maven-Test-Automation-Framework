package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static utils.TestReportGenerator.LOGGER;

public class ProductListBasePage extends BasePage {

    @FindBy(css = "h5[class^='DefaultProductTile__ProductName']")
    private List<WebElement> allProductNames;

    @FindBy(css = "button[data-ref^='add-to-cart-button']")
    private List<WebElement> allAddToCartButtons;

    @FindBy(css = "div[data-ref='mini-cart']")
    private WebElement miniCart;

    public ProductListBasePage() {
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> addProductsToCart(int productCount) {
        driver.manage().window().maximize();
        ArrayList<String> productsAddedToCart = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            productsAddedToCart.add(allProductNames.get(i).getText());
            LOGGER.log(Level.INFO, "productsAddedToCart.get(i): " + productsAddedToCart.get(i));
            try {
                allAddToCartButtons.get(i).click();
            } catch (NullPointerException | ElementClickInterceptedException e) {
                wait.until(ExpectedConditions.invisibilityOf(miniCart));
                wait.until(ExpectedConditions.visibilityOfAllElements(allAddToCartButtons));
                allAddToCartButtons.get(i).click();
            }
        }

        return productsAddedToCart;
    }
}