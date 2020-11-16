package org.issoft.automation.test.Task60PageFactory;

import org.issoft.automation.page.Task60PageFactory.MainPage;
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
