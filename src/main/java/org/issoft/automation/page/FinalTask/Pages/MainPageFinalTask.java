package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Strategy.AddToCartStrategy;
import org.issoft.automation.page.FinalTask.Utils.CheckForTheExistenceOfElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageFinalTask {
    private WebDriver driver;
    private By signInButton = By.xpath("//a[@class='login']");
    private By womanSection = By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='Women']");
    private By myAccountLink = By.xpath("//a[@class='account']");
    private By cartButton = By.xpath("//a[@title='View my shopping cart']");
    private By logoutLink = By.xpath("//a[@class='logout']");

    public MainPageFinalTask(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public WomanCategoryPage clickOnWomanCategory(AddToCartStrategy strategy) {
        driver.findElement(womanSection).click();
        return new WomanCategoryPage(driver, strategy);
    }

    public WomanCategoryPage clickOnWomanCategory() {
        driver.findElement(womanSection).click();
        return new WomanCategoryPage(driver);
    }

    public MyAccountPage clickMyAccountLink() {
        if (CheckForTheExistenceOfElement.checkIfElementExists(myAccountLink, driver)) {
            driver.findElement(myAccountLink).click();
        }
        return new MyAccountPage(driver);
    }

    public CartPage clickOnCartButton() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public MainPageFinalTask logout() {
        if (CheckForTheExistenceOfElement.checkIfElementExists(logoutLink, driver)) {
            driver.findElement(logoutLink).click();
        }
        return this;
    }
}

