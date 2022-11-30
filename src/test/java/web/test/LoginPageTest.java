package web.test;

import org.bit_cump.framework.utils.EnvironmentUtils;
import org.bit_cump.framework.utils.StringUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.BaseTest;
import web.page.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @BeforeClass(alwaysRun = true)
    public void navigateToLoginPage() {
        loginPage.navigateTo();
        loginPage.waitForPageLoaded();
    }

    @Test(description = "Login input can be filled", groups = {"smoke"})
    public void verifyLoginCanBeFilledTest() {
        loginPage.fillLogin(EnvironmentUtils.standardUser);
        assertThat(
                "After fill login, login input value is not correct",
                loginPage.getLoginInputValue(),
                Matchers.equalTo(EnvironmentUtils.standardUser)
        );
    }

    @Test(description = "Password input has security ", groups = {"smoke"})
    public void verifyPasswordHasOnlyHashValueInXpathFilledTest() {
        loginPage.fillLogin(EnvironmentUtils.password);
        assertThat(
                "After fill password, password input value is not correct",
                loginPage.getPasswordInputValue(),
                Matchers.not(Matchers.equalTo(EnvironmentUtils.password))
        );
    }

    @Test(description = "Error message appeared with wrong password", groups = {"smoke"})
    public void isErrorMessageDisplayedWithWrongPasswordTest() {
        loginPage.fillLogin(StringUtils.randomString(20))
                .clickOnLogInButton();
        assertThat(
                "After fill login by incorrect value, error message does not displayed",
                loginPage.isErrorMessageDisplayed()
        );
    }

    @Test(description = "Error message appeared with wrong login", groups = {"smoke"})
    public void isErrorMessageDisplayedWithWrongLoginTest() {
        loginPage.fillPassword(StringUtils.randomString(20))
                .clickOnLogInButton();
        assertThat(
                "After fill password by incorrect value, error message does not displayed",
                loginPage.isErrorMessageDisplayed()
        );
    }

    @AfterMethod(alwaysRun = true)
    public void clearFields() {
        loginPage.clearLoginField();
        loginPage.clearPasswordField();
    }
}
