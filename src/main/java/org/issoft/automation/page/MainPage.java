package org.issoft.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By loginLink = By.xpath("//a[@class='enter']");
    private By userNameLink = By.xpath("//a/span[@class='uname']");
    private By loginField = By.name("login");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@value='Войти']");
    private By registerButton = By.linkText("Зарегистрироваться");
    private By loginWithFBAccount = By.cssSelector(".b-auth-form .social__btn--fb");
    private By rememberMeCheckBox = By.id("memory");
    private By forgetPasswordLink = By.partialLinkText("пароль");
    private By allLinks = By.tagName("a");
    private By closeButton = By.className("b-popup-close");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getUserNameLink() {
        return userNameLink;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String getUserNameLinkText() {
        return driver.findElement(userNameLink).getText();
    }

    public void login(String login, String password) throws InterruptedException {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        //Thread.sleep is type of Explicit Waits as it waits for one specific event
        Thread.sleep(3000);
        driver.findElement(submitButton).click();
    }
}
