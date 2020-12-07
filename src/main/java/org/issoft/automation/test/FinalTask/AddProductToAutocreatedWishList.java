package org.issoft.automation.test.FinalTask;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.FinalTask.Constants.Constants;
import org.issoft.automation.page.FinalTask.Pages.WishListPage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddProductToAutocreatedWishList extends BaseTestFinalTask {
    @Tag("WishListTest")
    @TmsLink("AP-3")
    @Description("Verify products are added to the wishlist which was created automatically")
    @Test
    public void addProductToAutocreatedWishList() throws InterruptedException {
        WishListPage wishListPage = mainPageFinalTask
                .clickSignIn()
                .signIn(Constants.EMAIL, Constants.PASSWORD)
                .clickWishList();
        Assert.assertTrue(!wishListPage.isWishListExist());
        String productName = mainPageFinalTask
                .clickOnWomanCategory()
                .clickOnTheFirstItem()
                .addToWishListLinkAndClosePopup()
                .getProductName();
        //I know this is very bad approach to use Thread.sleep. But this is was the only way to fix the issue in firefox browser
        // "Element is not clickable at point because another element obscures it"
        //I also tried to resolve it with scrolling to this element with JavaScript and add Explicit waiter but nothing helped
        Thread.sleep(3000);
        String productNameInTheWishList = mainPageFinalTask
                .clickMyAccountLink()
                .clickWishList()
                .showProductInfo()
                .getProductName();
        String quantityOfProductsInTheWishList = wishListPage.getQuantityOfProducts();
        Assertions.assertAll(
                () -> Assert.assertEquals(productName, productNameInTheWishList),
                () -> Assert.assertEquals("1", quantityOfProductsInTheWishList)
        );
    }
}
