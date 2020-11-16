package org.issoft.automation.test.task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertTest extends BaseTest {
    private static final String URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
    }

    @Test
    public void acceptAlert() {
        By button = By.xpath("//p[@id='confirm-demo']//preceding-sibling::button");
        driver.findElement(button).click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void declineAlert() {
        By button = By.xpath("//p[@id='confirm-demo']//preceding-sibling::button");
        driver.findElement(button).click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }

    @Test
    public void alertText() {
        By button = By.xpath("//p[@id='confirm-demo']//preceding-sibling::button");
        driver.findElement(button).click();
        String alertText = driver.switchTo().alert().getText();
        Assertions.assertEquals("Press a button!", alertText);
    }

    @Test
    public void sendDataToAlert() {
        By buttonClickForPromptText = By.xpath("//p[@id='prompt-demo']//preceding-sibling::button");
        driver.findElement(buttonClickForPromptText).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assertions.assertEquals("You have entered 'Test' !", actualText);
    }
}
