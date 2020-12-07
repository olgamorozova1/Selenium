package org.issoft.automation.page.FinalTask.Strategy;

import org.issoft.automation.page.FinalTask.Objects.Product;
import org.openqa.selenium.WebDriver;

import java.util.List;

/*
Here is interface which allows me to implement to different approaches to add product to cart:
1. Clicking 'Add to cart button' on the Woman category page (by hovering over image)
2. Click on product and add to cart on the page where single product described
*/
public interface AddToCartStrategy {
    List<Product> addToCart(int quantity);

    void setDriver(WebDriver driver);
}
