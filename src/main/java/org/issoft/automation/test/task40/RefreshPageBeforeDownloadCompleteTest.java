package org.issoft.automation.test.task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class RefreshPageBeforeDownloadCompleteTest extends BaseTest {
    private static final String URL = "https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
    }

    @Test
    public void refreshPageBeforeDownloadComplete() {
        WebElement button = driver.findElement(By.xpath("//button[@id='cricle-btn']"));
        button.click();
        By percentText = By.xpath("//div[@class='percenttext']");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        if (wait.until(ExpectedConditions.textMatches(percentText, Pattern.compile("^[5-9]\\d%$")))) {
            driver.navigate().refresh();
        }
        String percentValue = driver.findElement(percentText).getText();
        Assertions.assertTrue(percentValue.equals("0%"));
    }
}
