package org.issoft.automation.page.FinalTask.Strategy;

import org.issoft.automation.page.FinalTask.Objects.Product;
import org.issoft.automation.page.FinalTask.Pages.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/*
This class describes one of two strategies of adding product to cart:
Click on product and add to cart on the page where single product described
 */
public class AddToCartOnProductDetailsPageStrategy implements AddToCartStrategy {
    private WebDriver driver;

    @Override
    public List<Product> addToCart(int quantity) {
        List<Product> listOfProduct = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            driver.findElement(By.xpath("(//div[@class='product-container'])[" + i + "]//a[@class='product-name']")).click();
            ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
            productDetailsPage.addToCartAndClosePopUp();
            String name = productDetailsPage.getProductName();
            double price = productDetailsPage.getProductPrice();
            listOfProduct.add(new Product(name, price));
            productDetailsPage.returnOnWomanCategoryPage();
        }
        return listOfProduct;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
