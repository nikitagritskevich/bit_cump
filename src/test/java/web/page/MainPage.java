package web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import web.iterface.HamburgerPanel;
import web.iterface.Footer;

public class MainPage extends BasePage implements Footer, HamburgerPanel {

    protected MainPage(String URL) {
        super(URL);
    }

    private final SelenideElement pageTitle = Selenide.$(By.className("title"));

    private final SelenideElement hamburgerButton = Selenide.$(By.id("react-burger-menu-btn"));

    private final SelenideElement shoppingCartButton = Selenide.$(By.id("shopping_cart_container"));

    public String getPageTitle() {
        String title = pageTitle.text();
        log.info("Get page title - {}", title);
        return title;
    }

    public boolean isPageTitleDisplayed() {
        boolean isDisplayed = pageTitle.is(Condition.visible);
        log.info("Page title is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isHamburgerButtonDisplayed() {
        boolean isDisplayed = hamburgerButton.is(Condition.visible);
        log.info("Hamburger button is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isHamburgerButtonEnabled() {
        boolean isEnabled = hamburgerButton.is(Condition.enabled);
        log.info("Hamburger button is enabled - {}", isEnabled);
        return isEnabled;
    }

    public void clickOnHamburgerButton() {
        log.info("Click on hamburger button");
        hamburgerButton.click();
    }

    public boolean isShoppingCartButtonDisplayed() {
        boolean isDisplayed = shoppingCartButton.is(Condition.visible);
        log.info("Shopping cart button is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public void clickOnShoppingCartButton() {
        log.info("Click on shopping cart button");
        shoppingCartButton.click();
    }
}
