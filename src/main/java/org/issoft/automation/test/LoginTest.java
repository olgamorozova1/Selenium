package org.issoft.automation.test;

import org.issoft.automation.page.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private static final String URL = "https://www.tut.by/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @ParameterizedTest
    @CsvSource({
            "seleniumtests@tut.by, 123456789zxcvbn, Selenium Test",
            "seleniumtests2@tut.by, 123456789zxcvbn, Selenium Test"
    }
    )
    public void loginWithCorrectCredentials(String email, String password, String expectedUserName) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();
        mainPage.login(email, password);
        WebDriverWait explicitWait = new WebDriverWait(driver, 7);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getUserNameLink()));
        String userName = mainPage.getUserNameLinkText();
        assertEquals(userName, expectedUserName);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
