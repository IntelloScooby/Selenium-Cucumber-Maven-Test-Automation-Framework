package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class ProductCategoryListBasePage extends BasePage {

    private TestHelper helper = new TestHelper();

    public ProductCategoryListBasePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickProductCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }
}
