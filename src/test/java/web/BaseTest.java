package web;

import org.bit_cump.framework.utils.DriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void initBrowser() {
        DriverUtils.initBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void teardownBrowser() {
        DriverUtils.teardownBrowser();
    }
}
