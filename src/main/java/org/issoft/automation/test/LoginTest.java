package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    private static final String URL = "https://www.tut.by/";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
    }

    @ParameterizedTest
    @CsvSource({
            "seleniumtests@tut.by, 123456789zxcvbn, Selenium Test",
            "seleniumtests2@tut.by, 123456789zxcvbn, Selenium Test"
    }
    )
    public void loginWithCorrectCredentials(String email, String password, String expectedUserName) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getLoginLink()));
        mainPage.clickLoginLink();
        mainPage.login(email, password);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getUserNameLink()));
        String userName = mainPage.getUserNameLinkText();
        assertEquals(userName, expectedUserName);
    }
}
