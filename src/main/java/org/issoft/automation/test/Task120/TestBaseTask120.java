package org.issoft.automation.test.Task120;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseTask120 {
    public static WebDriver driver;
    private static final String URL = "https://www.tut.by/";

    @BeforeAll
    static void setUp() throws MalformedURLException {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setCapability("platformName", "macOS 10.14");
        browserOptions.setCapability("browserVersion", "83.0");
        driver = new RemoteWebDriver(new URL("https://olgamorozova:a582d1f6-2b50-43b3-91b9-24d230659300@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
