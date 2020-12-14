package org.issoft.automation.test.FinalTask;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.FinalTask.Constants.Constants;
import org.issoft.automation.page.FinalTask.Strategy.AddToCartOnCategoryPageStrategy;
import org.issoft.automation.page.FinalTask.Pages.WishListPage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddProductToWishList extends BaseTestFinalTask {
    @Tag("WishListTest")
    @TmsLink("AP-4")
    @Description("Verify wishlist is created with correct name")
    @Test
    public void wishListIsCreatedAndHasCorrectName() {
        String listName = "List1";
        String nameOfCreatedList = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD)
                .clickWishList()
                .createWishList(listName)
                .getWishListName();
        Assert.assertEquals(listName, nameOfCreatedList);
    }

    @Tag("WishListTest")
    @TmsLink("AP-4")
    @Description("Verify wishlist is created with zero quantity")
    @Test
    public void wishListContainsZeroQuantityOfProducts() {
        String quantityOfProductsInTheWishList = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD)
                .clickWishList()
                .createWishList("List1")
                .getQuantityOfProducts();
        Assert.assertEquals("0", quantityOfProductsInTheWishList);
    }

    @Tag("WishListTest")
    @TmsLink("AP-4")
    @Description("Verify new wishlist does not contain products")
    @Test
    public void newWishListDoesNotContainProducts() {
        String message = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD)
                .clickWishList()
                .createWishList("List1")
                .showProductInfo()
                .getNoProductsMessage();
        Assert.assertEquals("No products", message);
    }

    @Tag("WishListTest")
    @TmsLink("AP-4")
    @Description("Verify products could be added to the wishlist")
    @Test
    public void addProductsToTheWishList() throws InterruptedException {
        WishListPage wishListPage = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD)
                .clickWishList()
                .createWishList("List1");
        String productName = mainPageFinalTask
                .clickOnWomanCategory(new AddToCartOnCategoryPageStrategy())
                .clickOnTheFirstItem()
                .addToWishListLinkAndClosePopup()
                .getProductName();
        //I know this is very bad approach to use Thread.sleep. But this is was the only way to fix the issue in firefox browser
        // "Element is not clickable at point because another element obscures it"
        //I also tried to resolve it with scrolling to this element with JavaScript and add Explicit waiter but nothing helped
        Thread.sleep(3000);
        String productNameInTheWishList = mainPageFinalTask.
                clickMyAccountLink()
                .clickWishList()
                .showProductInfo()
                .getProductName();
        String quantityOfProductsInTheWishList = wishListPage.getQuantityOfProducts();
        String nameOfTheWishList = wishListPage.getWishListName();
        Assertions.assertAll(
                () -> Assert.assertEquals(productName, productNameInTheWishList),
                () -> Assert.assertEquals("1", quantityOfProductsInTheWishList),
                () -> Assert.assertEquals("List1", nameOfTheWishList)
        );
    }
}
