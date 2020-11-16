package org.issoft.automation.test.task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MultiselectTest extends BaseTest {
    private static final String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
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
        Assertions.assertEquals(selectedValues, expectedSelectedValues);
    }
}
