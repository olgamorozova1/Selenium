package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Utils.CheckForTheExistenceOfElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {
    private WebDriver driver;
    private By wishListTable = By.xpath("//table[@class='table table-bordered']");
    private By nameField = By.xpath("//input[@id='name']");
    private By saveButton = By.xpath("//button[@id='submitWishlist']");
    private By myWishListLink = By.xpath("//td[1]/a");
    private By productName = By.xpath("//p[@id='s_title']");
    private By quantityOfProductsInTheWishList = By.xpath("//td[2]");
    private By wishListName = By.xpath("//td[1]");
    private By noProductsMessage = By.xpath("//p[@class='alert alert-warning']");
    private By removeListWishIcon = By.xpath("//i[@class='icon-remove']");

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public WishListPage createWishList(String name) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(saveButton).click();
        return this;
    }

    public boolean isWishListExist() {
        return CheckForTheExistenceOfElement.checkIfElementExists(wishListTable, driver);
    }

    public WishListPage showProductInfo() {
        driver.findElement(myWishListLink).click();
        return this;
    }

    public String getProductName() {
        String productFullName = driver.findElement(productName).getAttribute("textContent").trim();
        String details = driver.findElement(By.xpath("//small/a[@title='Product detail']")).getText();
        String productNameWithoutDetails = productFullName.replace(details, "").replace("\n", "").trim();
        return productNameWithoutDetails;
    }

    public String getQuantityOfProducts() {
        return driver.findElement(quantityOfProductsInTheWishList).getText();
    }

    public String getWishListName() {
        return driver.findElement(wishListName).getText();
    }

    public String getNoProductsMessage() {
        //This is no the best approach to mix implicit and explicit waits.
        //I decided to use implicit waiter in this task as there are a lot of places where I have to wait for presence of element.
        //But only in Firefox test fails as implicit wait time is not enough in this place. I do not want to increase implicit wait
        //and decided to add Explicit wait only in one place here
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(noProductsMessage));
        return driver.findElement(noProductsMessage).getText();
    }

    public WishListPage deleteWishList() {
        if (CheckForTheExistenceOfElement.checkIfElementExists(wishListTable, driver)) {
            driver.findElement(removeListWishIcon).click();
            driver.switchTo().alert().accept();
        }
        return this;
    }
}
