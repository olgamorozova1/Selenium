package org.issoft.automation.test.Task110;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseTask110 {
    public static WebDriver driver;
    private static final String URL = "https://www.tut.by/";
    @BeforeAll
    static void setUp() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://192.168.100.11:4444/wd/hub"), cap);
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
