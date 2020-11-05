package org.issoft.automation.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MultiselectTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void setUp() {
        driver = baseTest.setUp(URL);
    }

    @Test
    public void multiselectTest() {
        Select dropdown = new Select(driver.findElement(By.id("multi-select")));
        dropdown.selectByValue("California");
        dropdown.selectByValue("New York");
        dropdown.selectByValue("Pennsylvania");
        List<WebElement> selectedValues = dropdown.getAllSelectedOptions();
        List<WebElement> expectedSelectedValues = new ArrayList<>();
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='California']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='New York']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='Pennsylvania']")));
        System.out.println(expectedSelectedValues);
        Assertions.assertEquals(selectedValues, expectedSelectedValues);
    }

    @AfterEach
    public void closeBrowser() {
        baseTest.closeBrowser();
    }
}
