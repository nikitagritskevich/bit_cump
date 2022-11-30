package web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.bit_cump.framework.utils.EnvironmentUtils;
import org.bit_cump.framework.utils.StringUtils;

public class CartPage extends MainPage {

    private static final String URL = EnvironmentUtils.URL + "cart.html";

    private CartPage() {
        super(URL);
    }

    private final String REMOVE_CART_PATTERN = "//button[@id='remove-%s']";

    public void clickOnRemoveCartButton(String cartName) {
        log.info("Click on remove button for '{}' cart", cartName);
        String xpathCartName = StringUtils.convertCartNameToXpathFormat(cartName);
        Selenide.$x(REMOVE_CART_PATTERN.formatted(xpathCartName)).click();
    }

    public boolean isRemoveCartButtonDisplayed(String cartName) {
        String xpathCartName = StringUtils.convertCartNameToXpathFormat(cartName);
        boolean isDisplayed = Selenide.$x(REMOVE_CART_PATTERN.formatted(xpathCartName)).is(Condition.visible);
        log.info("Remove button for '{}' cart is displayed - {}", cartName, isDisplayed);
        return isDisplayed;
    }
}
