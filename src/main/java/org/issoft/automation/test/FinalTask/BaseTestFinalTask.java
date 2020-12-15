package org.issoft.automation.test.FinalTask;

import org.issoft.automation.page.FinalTask.Constants.Constants;
import org.issoft.automation.page.FinalTask.Objects.BrowserType;
import org.issoft.automation.page.FinalTask.Objects.DriverAttributes;
import org.issoft.automation.page.FinalTask.Objects.DriverInit;
import org.issoft.automation.page.FinalTask.Pages.MainPageFinalTask;
import org.issoft.automation.page.FinalTask.TestListeners.TestListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

@ExtendWith(TestListener.class)
public class BaseTestFinalTask {
    public static WebDriver driver;
    MainPageFinalTask mainPageFinalTask = new MainPageFinalTask(driver);

    @BeforeAll
    static void setUp() throws MalformedURLException {
        DriverInit instanceDriver = DriverInit.getInstance();
        DriverAttributes driverAttributes = new DriverAttributes(BrowserType.CHROME, false);
        driver = instanceDriver.openBrowser(driverAttributes);
    }

    @BeforeEach
    void openMainPage() {
        driver.get(Constants.URL);
    }

    @AfterEach
    void cleanUp() {
        mainPageFinalTask.clickMyAccountLink()
                .clickWishList()
                .deleteWishList();
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
