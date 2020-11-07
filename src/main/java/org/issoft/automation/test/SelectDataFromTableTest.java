package org.issoft.automation.test;

import org.issoft.automation.page.task9.EmployeeAllInfo;
import org.issoft.automation.page.task9.EmployeeInfo;
import org.issoft.automation.page.task9.TablePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SelectDataFromTableTest extends BaseTest {
    private static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";

    @BeforeEach
    public void setUp() {
        super.setUp(URL);
    }

    @Test
    public void selectDataFromTable() {
        TablePage tablePage = new TablePage(driver);
        tablePage.selectQuantityOfRowsInTable();
        List<EmployeeAllInfo> allInfoAboutEmployee = tablePage.getInfoFromAllPages();
        List<EmployeeInfo> selectedEmployees = tablePage.selectEmployeeByAgeAndSalary(allInfoAboutEmployee);
    }
}

