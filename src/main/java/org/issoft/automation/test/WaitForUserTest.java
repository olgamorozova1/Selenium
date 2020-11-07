package org.issoft.automation.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForUserTest extends BaseTest {
    private static final String URL = "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
    }

    @Test
    public void waitForUser() {
        By button = By.xpath("//button[@id='save']");
        By photo = By.xpath("//div[@id='loading']/img");
        driver.findElement(button).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(photo));
        Boolean userPhotoIsDisplayed = driver.findElement(photo).isDisplayed();
        Assertions.assertTrue(userPhotoIsDisplayed);
    }
}
