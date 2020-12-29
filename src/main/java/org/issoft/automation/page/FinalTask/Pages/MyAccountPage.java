package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Utils.CheckForTheExistenceOfElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private By welcomeMessage = By.xpath("//p[@class='info-account']");
    private By myWishListLink = By.xpath("//a[@title='My wishlists']");
    private By myPersonalInformationButton = By.xpath("//a[@title='Information']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WishListPage clickWishList() {
        if (CheckForTheExistenceOfElement.checkIfElementExists(myWishListLink, driver)) {
            driver.findElement(myWishListLink).click();

        }
        return new WishListPage(driver);
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public MyPersonalInformationPage clickMyPersonalInformationButton() {
        driver.findElement(myPersonalInformationButton).click();
        return new MyPersonalInformationPage(driver);
    }
}
