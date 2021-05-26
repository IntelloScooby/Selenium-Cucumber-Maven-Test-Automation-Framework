package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

import java.util.ArrayList;
import java.util.List;

public class ReviewCartPage extends BasePage {

    @FindBy(css = "a[class^='ProductInfo__ProductNameWithLink']")
    private List<WebElement> allProductsInCart;

    @FindBy(linkText = "Empty Cart")
    private WebElement emptyCartLink;

    private TestHelper helper = new TestHelper();

    public ReviewCartPage() {
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> getProductsInCart() {
        ArrayList<String> allProductNames = new ArrayList<>();
        helper.waitForPageToLoad(driver);

        for (WebElement product : allProductsInCart) {
            allProductNames.add(product.getText());
        }

        return allProductNames;
    }

    public void emptyCart() {
        emptyCartLink.click();
    }
}
