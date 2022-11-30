package web.test;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.BaseTest;
import web.page.InventoryPage;
import web.page.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class VerifyInventoryPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @BeforeClass(alwaysRun = true)
    public void logInAsStandardUser() {
        loginPage.navigateTo();
        loginPage.logInAsStandardUser();
    }

    @Test(description = "Standard inventory item size", groups = {"regression"})
    public void verifyStandardCountInventoryItemTest() {
        assertThat(
                "Standard count items on the inventory page is not 6",
                inventoryPage.getInventoryCount(),
                Matchers.equalTo(6)
        );
    }
}
