package org.issoft.automation.page.FinalTask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By emailFieldForAccountCreation = By.xpath("//input[@id='email_create']");
    private By createAnAccountButton = By.xpath("//button[@id='SubmitCreate']");
    private By createAccountError = By.xpath("//div[@class='alert alert-danger']/ol/li");
    private By emailFieldForSignIn = By.xpath("//input[@id='email']");
    private By passwordFieldForSignIn = By.xpath("//input[@id='passwd']");
    private By signInButton = By.xpath("//button[@id='SubmitLogin']");
    private By invalidPasswordMessage = By.xpath("//div[@class='alert alert-danger']/ol/li");


    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAnAccountPage createAnAccount(String email) {
        driver.findElement(emailFieldForAccountCreation).sendKeys(email);
        driver.findElement(createAnAccountButton).click();
        return new CreateAnAccountPage(driver);
    }

    public MyAccountPage signIn(String email, String password) {
        driver.findElement(emailFieldForSignIn).sendKeys(email);
        driver.findElement(passwordFieldForSignIn).sendKeys(password);
        driver.findElement(signInButton).click();
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(createAccountError).getText();
    }

    public String incorrectPasswordErrorMessage() {
        return driver.findElement(invalidPasswordMessage).getText();
    }

}
