package web.iterface;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public interface HamburgerPanel extends InterfaceLogger {

    SelenideElement hamburgerPanel = Selenide.$(By.className("bm-menu-wrap"));
    ElementsCollection hamburgerValues = Selenide.$$x("//a[@class='bm-item menu-item']");

    default boolean isHamburgerPanelDisplayed() {
        boolean isDisplayed = hamburgerPanel.is(Condition.visible);
        interfaceLog.info("Hamburger panel is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    default List<String> getHamburgerPanelValuesTexts() {
        List<String> values = hamburgerValues.texts();
        interfaceLog.info("Get hamburger values texts - {}", values);
        return values;
    }
}
