package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest extends TestBase {
    MainPage mainPage = new MainPage(driver);

    @Test
    public void loginWithCorrectCredentials() {
        String userName = mainPage.login("seleniumtests@tut.by", "123456789zxcvbn").getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Test
    public void logout() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn").logout();
        String loginLinkText = driver.findElement(mainPage.getLoginLink()).getText();
        assertEquals("Войти", loginLinkText);
    }
}
