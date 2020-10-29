package org.issoft.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForUser {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html";

    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }
    @Test
    public void waitForUser () {
        By button = By.xpath("//button[@id='save']");
        By photo = By.xpath("//div[@id='loading']/img");
        driver.findElement(button).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(photo));
        Boolean userPhotoIsDisplayed = driver.findElement(photo).isDisplayed();
        Assertions.assertEquals(true, userPhotoIsDisplayed );
    }
    @AfterEach
    public void closeBrowser () {
        driver.quit();
    }
}
