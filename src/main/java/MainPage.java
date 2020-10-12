import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By loginLink = By.xpath("//a[@class='enter']");
    private By userNameLink = By.xpath("//a/span[@class='uname']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public String getUserNameLinkText() {
        return driver.findElement(userNameLink).getText();
    }
}
