package org.issoft.automation.page.FinalTask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private By addToWishListLink = By.xpath("//a[@id='wishlist_button']");
    private By addToCartButton = By.xpath("//button[@name='Submit']");
    private By closeCartPopUp = By.xpath("//span[@title='Close window']");
    private By closeAddedToWishListPopup = By.xpath("//a[@class='fancybox-item fancybox-close']");
    private By productName = By.xpath("//h1");
    private By productPrice = By.xpath("//span[@id='our_price_display']");
    private By linkToWomanCategoryPage = By.xpath("//a[@title='Women']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage addToWishListLinkAndClosePopup() {
        driver.findElement(addToWishListLink).click();
        driver.findElement(closeAddedToWishListPopup).click();
        return this;
    }

    public ProductDetailsPage addToCartAndClosePopUp() {
        driver.findElement(addToCartButton).click();
        //Yes, this is one more wait which I should not use,
        // but without it this test fails on Firefox and do not want get rid of implicit wait
        // which helps me not to set wait before a lot of elements
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeCartPopUp));

        driver.findElement(closeCartPopUp).click();
        return this;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public double getProductPrice() {
        String priceString = driver.findElement(productPrice).getText().substring(1);
        return Double.parseDouble(priceString);
    }

    public WomanCategoryPage returnOnWomanCategoryPage() {
        driver.findElement(linkToWomanCategoryPage).click();
        return new WomanCategoryPage(driver);
    }
}
