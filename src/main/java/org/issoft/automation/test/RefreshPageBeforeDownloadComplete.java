package org.issoft.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RefreshPageBeforeDownloadComplete {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void refreshPageBeforeDownloadComplete() {
        WebElement button = driver.findElement(By.xpath("//button[@id='cricle-btn']"));
        button.click();
        By percentText = By.xpath("//div[@class='percenttext']");
        int progressValue = 0;
        while (progressValue <= 50) {
            String progressPercent = driver.findElement(percentText).getText();
            progressValue = Integer.parseInt(progressPercent.substring(0, progressPercent.length() - 1));
        }
        if (progressValue >= 50) {
            driver.navigate().refresh();
        }
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
