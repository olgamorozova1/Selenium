package org.issoft.automation.test;

import org.issoft.automation.page.task9.EmployeeAllInfo;
import org.issoft.automation.page.task9.EmployeeInfo;
import org.issoft.automation.page.task9.TablePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SelectDataFromTableTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
    BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void setUp() {
        driver = baseTest.setUp(URL);
    }

    @Test
    public void selectDataFromTable() {
        TablePage tablePage = new TablePage(driver);
        tablePage.selectQuantityOfRowsInTable();
        List<EmployeeAllInfo> allInfoAboutEmployee = tablePage.getInfoFromAllPages();
        List<EmployeeInfo> selectedEmployees = tablePage.selectEmployeeByAgeAndSalary(allInfoAboutEmployee);
    }

    @AfterEach
    public void closeBrowser() {
        baseTest.closeBrowser();
    }
}

