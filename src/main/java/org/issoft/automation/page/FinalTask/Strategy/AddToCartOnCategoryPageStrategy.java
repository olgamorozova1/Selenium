package org.issoft.automation.page.FinalTask.Strategy;

import org.issoft.automation.page.FinalTask.Objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
This class describes one of two strategies of adding product to cart:
hovering over image and click 'Add to cart button' on the Woman category page
 */
import java.util.ArrayList;
import java.util.List;

public class AddToCartOnCategoryPageStrategy implements AddToCartStrategy {
    private WebDriver driver;
    private By closeAddToCartPopUp = By.xpath("//span[@title='Close window']");

    public List<Product> addToCart(int quantity) {
        Actions actions = new Actions(driver);
        List<Product> listOfProduct = new ArrayList<>();

        for (int i = 1; i <= quantity; i++) {
            WebElement product = driver.findElement(By.xpath("(//div[@class='product-container'])[" + i + "]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", product);
            actions.moveToElement(product).perform();
            driver.findElement(By.xpath("(//a[@title='Add to cart'])[" + i + "]")).click();
            String name = driver.findElement(By.xpath("(//div[@class='product-container'])[" + i + "]//child::a[@class='product-name']")).getText();
            String priceString = driver.findElement(By.xpath("(//div[@class='product-container'])[" + i + "]//child::div[@class='product-image-container']//child::span[@class='price product-price']"))
                    .getText().substring(1);
            double price = Double.parseDouble(priceString);
            listOfProduct.add(new Product(name, price));
            //Yes, this is one more wait which I should not use,
            // but without it this test fails on Firefox and do not want get rid of implicit wait
            // which helps me not to set wait before a lot of elements
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeAddToCartPopUp));
            driver.findElement(closeAddToCartPopUp).click();
        }
        return listOfProduct;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
