import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    MainPage mainPage = new MainPage(driver);
    //Here is second task: covered all possible types of locations
    private By loginField = By.name("login");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By registerButton = By.linkText("Зарегистрироваться");
    private By loginWithFBAccount = By.cssSelector(".b-auth-form .social__btn--fb");
    private By rememberMeCheckBox = By.id("memory");
    private By forgetPasswordLink = By.partialLinkText("пароль");
    private By allLinks = By.tagName("a");
    private By closeButton = By.className("b-popup-close");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }
}
