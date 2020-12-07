package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Objects.Product;
import org.issoft.automation.page.FinalTask.Strategy.AddToCartStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class WomanCategoryPage {
    private WebDriver driver;
    private By firstItem = By.xpath("(//a[@class='product-name'])[1]");
    private AddToCartStrategy strategy;

    public WomanCategoryPage(WebDriver driver, AddToCartStrategy strategy) {
        this.driver = driver;
        this.strategy = strategy;
        this.strategy.setDriver(driver);
    }

    public WomanCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage clickOnTheFirstItem() {
        driver.findElement(firstItem).click();
        return new ProductDetailsPage(driver);
    }

    public List<Product> addToCart(int quantity) {
        return this.strategy.addToCart(quantity);
    }

}
