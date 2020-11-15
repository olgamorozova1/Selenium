package org.issoft.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@class='enter']")
    private WebElement loginLink;
    @FindBy(xpath = "//a/span[@class='uname']")
    private WebElement userNameLink;
    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@class='button wide auth__reg']")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[@class='enter logedin']")
    private WebElement userNameLinkLogedIn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserNameLink() {
        return userNameLink;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public String getUserNameLinkText() {
        return userNameLink.getText();
    }

    public void fillLoginFields(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public MainPage login(String login, String password) {
        clickLoginLink();
        fillLoginFields(login, password);
        return new MainPage(driver);
    }

    public void clickUserNameLink() {
        userNameLinkLogedIn.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public MainPage logout() {
        clickUserNameLink();
        clickLogoutButton();
        return new MainPage(driver);
    }
}
