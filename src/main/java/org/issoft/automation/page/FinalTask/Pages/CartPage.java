package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By tableWithProducts = By.xpath("//tbody/tr");
    private By totalPriceCell = By.xpath("//td[@id='total_product']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Product> getDataFromTable() {
        List<Product> listOfProductsFromTable = new ArrayList<>();
        List<WebElement> listOfWebElements = driver.findElements(tableWithProducts);
        for (int i = 1; i <= listOfWebElements.size(); i++) {
            String productName = driver.findElement(By.xpath("(//td[@class='cart_description']/p/a)[" + i + "]")).getText();
            String productPrice = driver.findElement(By.xpath("(//td[@class='cart_unit']/span/span)[" + i + "]")).getText().substring(1);
            double price = Double.parseDouble(productPrice);
            listOfProductsFromTable.add(new Product(productName, price));
        }
        return listOfProductsFromTable;
    }

    public double getTotalPriceOfTheCart() {
        String totalPriceString = driver.findElement(totalPriceCell).getText().substring(1);
        return Double.parseDouble(totalPriceString);
    }
}
