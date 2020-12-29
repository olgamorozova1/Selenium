package org.issoft.automation.test.Task60PageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.Task60PageObject.MainPage;
import org.issoft.automation.test.task40.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest extends BaseTest {
    MainPage mainPage = new MainPage(driver);


    @Test
    public void loginWithCorrectCredentials() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        String userName = mainPage.getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Tag("Logout")
    @Feature(value = "Logout")
    @Description("Verify logout functionality")
    @TmsLink(value = "ST-02")
    @Test
    public void logout() {
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        mainPage.logout();
        String loginLinkText = driver.findElement(mainPage.getLoginLink()).getText();
        assertEquals("Войти", loginLinkText);
    }
}
