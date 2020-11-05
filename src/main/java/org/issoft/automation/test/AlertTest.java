package org.issoft.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
    BaseTest baseTest = new BaseTest();
    private WebElement buttonClickMe = driver.findElement(By.xpath("//p[@id='confirm-demo']//preceding-sibling::button"));
    private WebElement buttonClickForPromptText = driver.findElement(By.xpath("//p[@id='prompt-demo']//preceding-sibling::button"));

    @BeforeEach
    public void setUp() {
        driver = baseTest.setUp(URL);
    }

    @Test
    public void acceptAlert() {
        buttonClickMe.click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void declineAlert() {
        buttonClickMe.click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }

    @Test
    public void alertText() {
        buttonClickMe.click();
        String alertText = driver.switchTo().alert().getText();
        Assertions.assertEquals("Press a button!", alertText);
    }

    @Test
    public void sendDataToAlert() {
        buttonClickForPromptText.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assertions.assertEquals("You have entered 'Test' !", actualText);
    }

    @AfterEach
    public void closeBrowser() {
        baseTest.closeBrowser();
    }
}
