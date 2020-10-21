package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private static final String URL = "https://www.tut.by/";
    private static final String LOGIN = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void loginWithCorrectCredentials() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();
        mainPage.login(LOGIN, PASSWORD);
        String userName = mainPage.getUserNameLinkText();
        Assert.assertEquals(userName, "Selenium Test");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
