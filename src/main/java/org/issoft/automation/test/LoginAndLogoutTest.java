package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest extends TestBase {
    MainPage mainPage = new MainPage(driver);

    @Test
    public void loginWithCorrectCredentials() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        String userName = mainPage.getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Test
    public void logout() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        mainPage.logout();
        String loginLinkText = mainPage.getLoginLink().getText();
        assertEquals("Войти", loginLinkText);
    }
}
