import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tut.by/");
    }

    @Test
    public void loginWithCorrectCredentials() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickLoginLink();
        MainPage newMainPage = loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        String userName = newMainPage.getUserNameLinkText();
        Assert.assertEquals(userName, "Selenium Test");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
