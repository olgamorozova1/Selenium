package org.issoft.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alert {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void acceptAlert() {
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]"));
        button.click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void declineAlert() {
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]"));
        button.click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }

    @Test
    public void alertText() {
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]"));
        button.click();
        String alertText = driver.switchTo().alert().getText();
        Assertions.assertEquals("Press a button!", alertText);
    }

    @Test
    public void sendDataToAlert() {
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[2]"));
        button.click();
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assertions.assertEquals("You have entered 'Test' !", actualText);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
