package org.issoft.automation.test.Task120;

import org.issoft.automation.page.Task110.MainPageTask110;
import org.issoft.automation.page.Task120.MainPageTask120;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTestTask120 extends TestBaseTask120 {
    MainPageTask120 mainPageTask120 = new MainPageTask120(driver);

    @Test
    public void loginWithCorrectCredentials() {
        String userName = mainPageTask120.login("seleniumtests@tut.by", "123456789zxcvbn").getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Test
    public void logout() {
        mainPageTask120.login("seleniumtests@tut.by", "123456789zxcvbn").logout();
        String loginLinkText = driver.findElement(mainPageTask120.getLoginLink()).getText();
        assertEquals("Войти", loginLinkText);
    }
}
