package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(css = "h1[data-ref='category-title']")
    private WebElement pageName;

    public static WebDriver driver;
    public WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageName() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(pageName));
        return pageName.getText();
    }

}
