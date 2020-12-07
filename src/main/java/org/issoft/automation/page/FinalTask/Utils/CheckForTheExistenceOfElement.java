package org.issoft.automation.page.FinalTask.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
This class was created to implement check whether user is logged in and whether WishList exists.
After each test we need to delete WishList as it is not saved in cookies.
 */
public class CheckForTheExistenceOfElement {
    public static boolean checkIfElementExists(By locator, WebDriver driver) {
        return !driver.findElements(locator).isEmpty();
    }
}
