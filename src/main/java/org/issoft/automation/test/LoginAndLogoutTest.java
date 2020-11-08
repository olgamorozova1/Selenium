package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest extends TestBase {
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

    @Test
    public void loginWithCorrectCredentials() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        String userName = mainPage.getUserNameLinkText();
        assertEquals(userName, "Selenium Test");
    }

    @Test
    public void logout() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        mainPage.logout();
    }
}
