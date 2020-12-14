package org.issoft.automation.test.FinalTask;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.FinalTask.Constants.Constants;
import org.issoft.automation.page.FinalTask.Pages.MyAccountPage;
import org.issoft.automation.page.FinalTask.Objects.Product;
import org.issoft.automation.page.FinalTask.Strategy.AddToCartOnCategoryPageStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddToCartTest extends BaseTestFinalTask {
    @Tag("CartTest")
    @TmsLink("AP-5")
    @Description("Verify products are added to the cart")
    @Test
    public void productsAreAddedToCart() {
        MyAccountPage myAccountPage = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD);
        List<Product> productList = mainPageFinalTask
                .clickOnWomanCategory(new AddToCartOnCategoryPageStrategy())
                .addToCart(3);
        List<Product> productListInTheCart = mainPageFinalTask
                .clickOnCartButton()
                .getDataFromTable();
        Assert.assertEquals(productList, productListInTheCart);
    }

    @Tag("CartTest")
    @TmsLink("AP-5")
    @Description("Verify total price of all products in the cart")
    @Test
    public void totalPriceIsCorrect() {
        MyAccountPage myAccountPage = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD);
        List<Product> productList = mainPageFinalTask
                .clickOnWomanCategory(new AddToCartOnCategoryPageStrategy())
                .addToCart(3);
        double expectedTotalPrice = 0;
        for (Product item : productList) {
            expectedTotalPrice += item.getPrice();
        }
        double actualTotalPrice = mainPageFinalTask
                .clickOnCartButton()
                .getTotalPriceOfTheCart();
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);
    }
}
