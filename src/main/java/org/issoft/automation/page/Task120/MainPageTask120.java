package org.issoft.automation.page.Task120;

import org.issoft.automation.page.Task60PageObject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageTask120 {
    private WebDriver driver;
    private By loginLink = By.xpath("//a[@class='enter']");
    private By userNameLink = By.xpath("//a/span[@class='uname']");
    private By loginField = By.name("login");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@value='Войти']");
    private By logoutButton = By.xpath("//a[@class='button wide auth__reg']");
    private By userNameLinkLogedIn = By.xpath("//a[@class='enter logedin']");

    public MainPageTask120(WebDriver driver) {
        this.driver = driver;
    }

    public By getUserNameLink() {
        return userNameLink;
    }

    public By getLoginLink() {
        return loginLink;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String getUserNameLinkText() {
        return driver.findElement(userNameLink).getText();
    }

    public void fillLoginFieldsAndClickSubmit(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public MainPage login(String login, String password) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getLoginLink()));
        clickLoginLink();
        fillLoginFieldsAndClickSubmit(login, password);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getUserNameLink()));
        return new MainPage(driver);
    }

    public void clickUserNameLink() {
        driver.findElement(userNameLinkLogedIn).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public MainPage logout() {
        clickUserNameLink();
        clickLogoutButton();
        return new MainPage(driver);
    }
}
