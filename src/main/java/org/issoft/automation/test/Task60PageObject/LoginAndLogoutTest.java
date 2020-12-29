package org.issoft.automation.test.Task60PageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.Task60PageObject.MainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.issoft.automation.page.FinalTask.Constants.Constants.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTest {
    public WebDriver driver;
    //MainPage mainPage = new MainPage(driver);

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }


    @Test
    public void loginWithCorrectCredentials() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        String userName =  mainPage.getUserNameLinkText();
        assertEquals("Selenium Test", userName);
    }

    @Tag("Logout")
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
