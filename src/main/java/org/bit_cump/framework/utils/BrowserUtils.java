package org.bit_cump.framework.utils;

import com.codeborne.selenide.Selenide;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor()
public class BrowserUtils {

    public static final Logger log = LogManager.getLogger(BrowserUtils.class);

    public void refresh() {
        log.info("Refresh page");
        Selenide.refresh();
    }

    public void open(String URL) {
        log.info("Open browser page - {}", URL);
        Selenide.open(URL);
    }

    public void closeTab() {
        log.info("Close current window tab");
        Selenide.closeWindow();
    }
}
