package org.issoft.automation.test.Task60PageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.Task60PageObject.MainPage;
import org.issoft.automation.test.Task60PageFactory.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest extends TestBase {
    MainPage mainPage = new MainPage(driver);

    @Feature(value = "Login")
    @Description("Login with correct credentials")
    @TmsLink(value = "ST-01")
    @Test
    public void loginWithCorrectCredentials() {
        String userName = mainPage.login("seleniumtests@tut.by", "123456789zxcvbn").getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Feature(value = "Logout")
    @Description("Verify logout functionality")
    @TmsLink(value = "ST-02")
    @Test
    public void logout() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn").logout();
        String loginLinkText = driver.findElement(mainPage.getLoginLink()).getText();
        assertEquals("Войти", loginLinkText);
    }
}
