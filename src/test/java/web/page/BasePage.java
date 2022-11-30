package web.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bit_cump.framework.utils.BrowserUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import web.iterface.Navigational;

public abstract class BasePage implements Navigational {

    protected Logger log = LogManager.getLogger(BasePage.class);

    private final String URL;
    private final BrowserUtils browserUtils;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'logo')]")
    public SelenideElement logo;

    protected BasePage(String URL) {
        this.URL = URL;
        this.browserUtils = new BrowserUtils();
    }

    @Override
    public void navigateTo() {
        browserUtils.open(URL);
    }

    public boolean isLogoDisplayed() {
        boolean isDisplayed = logo.is(Condition.visible);
        log.info("'Logo' is displayed - {}", isDisplayed);
        return isDisplayed;
    }
}
