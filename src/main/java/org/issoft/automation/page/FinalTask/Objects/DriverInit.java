package org.issoft.automation.page.FinalTask.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*
In this class Singleton pattern was implemented. It creates only one instance of WebDriver.
Also there is added possibility to switch between different types of browsers:
1. We check whether browser is remote or not.
If it is remote browser it requires URL. There could be run tests in Selenium Grid/SauceLabs/Docker.
If it is not remote browser it does not need URL.
2. In each option type of browser should be chosen: Chrome or Firefox.
To set up all necessary fields for browser class DriverAttributes was created with necessary fields isRemote and name.
 */

public class DriverInit {
    public static DriverInit instanceDriver = null;
    private WebDriver driver;


    private DriverInit() {
    }

    public WebDriver openBrowser(DriverAttributes driverAttributes) throws MalformedURLException {
        if (driverAttributes.getRemote()) {
            DesiredCapabilities capabilities = null;
            switch (driverAttributes.getName()) {
                case CHROME:
                    capabilities = DesiredCapabilities.chrome();
                    break;
                case FIREFOX:
                    capabilities = DesiredCapabilities.firefox();
                    break;

            }
            driver = new RemoteWebDriver(new URL(driverAttributes.getUrl()), capabilities);
        } else {
            switch (driverAttributes.getName()) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverInit getInstance() {
        if (instanceDriver == null)
            instanceDriver = new DriverInit();
        return instanceDriver;
    }
}
