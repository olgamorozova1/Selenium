package org.issoft.automation.test.Task60PageObject;

import org.apache.commons.io.FileUtils;
import org.issoft.automation.page.Listeners.TestResultWatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@ExtendWith(TestResultWatchers.class)
public abstract class TestBase {
    public static WebDriver driver;
    private static final String URL = "https://www.tut.by/";

    @BeforeAll
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterEach
    void takeScreenshoot() {
        Date date = new Date();
        String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(screenshot, new File("./target/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
