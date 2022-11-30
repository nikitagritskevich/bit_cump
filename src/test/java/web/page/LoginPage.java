package web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.bit_cump.framework.utils.EnvironmentUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(EnvironmentUtils.URL);
    }

    private final SelenideElement loginInput = Selenide.$(By.id("user-name"));

    private final SelenideElement passwordInput = Selenide.$(By.id("password"));

    private final SelenideElement errorMessage = Selenide.$x("//h3[@data-test='error']");

    private final SelenideElement closeErrorButton = Selenide.$(By.className("error-button"));

    private final SelenideElement logInButton = Selenide.$(By.id("login-button"));

    public LoginPage fillLogin(String loginValue) {
        log.info("Fill 'login' input - {}", loginValue);
        loginInput.sendKeys(loginValue);
        return this;
    }

    public LoginPage fillPassword(String passwordValue) {
        log.info("Fill 'password' input - {}", passwordValue);
        passwordInput.sendKeys(passwordValue);
        return this;
    }

    public void clearPasswordField() {
        log.info("Clear password field");
        passwordInput.clear();
    }

    public void clearLoginField() {
        log.info("Clear login field");
        loginInput.clear();
    }

    public boolean isLoginInputDisplayed() {
        boolean isDisplayed = loginInput.is(Condition.visible);
        log.info("'Login' input is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isLoginInputEnabled() {
        boolean isEnabled = loginInput.is(Condition.enabled);
        log.info("'Login' input is enabled - {}", isEnabled);
        return isEnabled;
    }

    public boolean isPasswordInputDisplayed() {
        boolean isDisplayed = passwordInput.is(Condition.visible);
        log.info("'Password' input is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isPasswordInputEnabled() {
        boolean isEnabled = loginInput.is(Condition.enabled);
        log.info("'Password' input is enabled - {}", isEnabled);
        return isEnabled;
    }

    public String getLoginInputValue() {
        String inputValue = loginInput.val();
        log.info("Get 'login' input value - {}", inputValue);
        return inputValue;
    }

    public String getPasswordInputValue() {
        String inputValue = passwordInput.val();
        log.info("Get 'login' input value - {}", inputValue);
        return inputValue;
    }

    public void clickOnLogInButton() {
        log.info("Click on 'LogIn' button");
        logInButton.click();
    }

    public boolean isLogInButtonDisplayed() {
        boolean isDisplayed = logInButton.is(Condition.visible);
        log.info("'LogIn' button is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isLogInButtonEnabled() {
        boolean isEnabled = logInButton.is(Condition.enabled);
        log.info("'LogIn' button is enabled - {}", isEnabled);
        return isEnabled;
    }

    public String getErrorMessageText() {
        String errorText = errorMessage.text();
        log.info("Get 'Error message' text - {}", errorText);
        return errorText;
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = errorMessage.is(Condition.visible);
        log.info("'Error message' is displayed - {}", isDisplayed);
        return isDisplayed;
    }

    public void clickOnCloseErrorMessage() {
        log.info("Click on close error message");
        closeErrorButton.click();
    }

    public boolean isCloseErrorMessageDisplayed() {
        boolean isErrorMessageDisplayed = closeErrorButton.is(Condition.visible);
        log.info("Close error message button is displayed - {}", isErrorMessageDisplayed);
        return isErrorMessageDisplayed;
    }

    public boolean isCloseErrorMessageEnabled() {
        boolean isErrorMessageEnabled = closeErrorButton.is(Condition.enabled);
        log.info("Close error message button is enabled - {}", isErrorMessageEnabled);
        return isErrorMessageEnabled;
    }

    private void logIn(String login, String password) {
        fillLogin(login)
                .fillPassword(password)
                .clickOnLogInButton();
    }

    public void waitForPageLoaded() {
        logInButton.shouldBe(Condition.visible);
    }

    public void logInAsStandardUser() {
        logIn(EnvironmentUtils.standardUser, EnvironmentUtils.password);
    }
}

