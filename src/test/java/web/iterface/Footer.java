package web.iterface;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public interface Footer extends InterfaceLogger{

    SelenideElement twitterLink = Selenide.$x("//li[@class='social_twitter']/a");

    SelenideElement facebookLink = Selenide.$x("//li[@class='social_facebook']/a");

    SelenideElement linkedinLink = Selenide.$x("//li[@class='social_linkedin']/a");

    SelenideElement footerCopy = Selenide.$(By.className("footer_copy"));

    default String getTwitterReference() {
        String reference = twitterLink.attr("href");
        interfaceLog.info("Get twitter link - {}", reference);
        return reference;
    }

    default String getFacebookReference() {
        String reference = facebookLink.attr("href");
        interfaceLog.info("Get facebook link - {}", reference);
        return reference;
    }

    default String getLinkedinReference() {
        String reference = linkedinLink.attr("href");
        interfaceLog.info("Get linkedin link - {}", reference);
        return reference;
    }

    default String getFooterCopeText() {
        String footerText = footerCopy.text();
        interfaceLog.info("get 'footer' text - {}", footerText);
        return footerText;
    }
}
