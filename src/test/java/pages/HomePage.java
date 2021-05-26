package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

public class HomePage extends BasePage {

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(linkText = "My Account")
    private WebElement myAccountButton;

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ConfigReader config = new ConfigReader();

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        if (!driver.getCurrentUrl().equals(config.getBaseUrl())) {
            driver.get(config.getBaseUrl());
        }
    }
}
