package org.bit_cump.framework.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DriverUtils {

    public static void initBrowser() {
        WebDriverManager.edgedriver().setup();
        //ChromeOptions option = new ChromeOptions();
        //option.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors");
        //WebDriverRunner.setWebDriver(new ChromeDriver(option));
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(7, ChronoUnit.SECONDS));
        WebDriverRunner.setWebDriver(driver);
    }

    public static void teardownBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
