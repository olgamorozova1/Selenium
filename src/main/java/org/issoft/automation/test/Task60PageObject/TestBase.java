package org.issoft.automation.test.Task60PageObject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {
    protected static WebDriver driver;
    private static final String URL = "https://www.tut.by/";

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
