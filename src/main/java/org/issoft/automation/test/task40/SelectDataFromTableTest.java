package org.issoft.automation.test.task40;

import org.issoft.automation.page.task40.EmployeeAllInfo;
import org.issoft.automation.page.task40.EmployeeInfo;
import org.issoft.automation.page.task40.TablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        List<EmployeeInfo> expectedSelectedEmployee = new ArrayList<>();
        expectedSelectedEmployee.add(new EmployeeInfo("A. Cox", "Junior Technical Author", "San Francisco"));
        expectedSelectedEmployee.add(new EmployeeInfo("A. Satou", "Accountant", "Tokyo"));
        expectedSelectedEmployee.add(new EmployeeInfo("B. Greer", "Software Engineer", "London"));
        expectedSelectedEmployee.add(new EmployeeInfo("G. Joyce", "Developer", "Edinburgh"));
        expectedSelectedEmployee.add(new EmployeeInfo("G. Winters", "Accountant", "Tokyo"));
        expectedSelectedEmployee.add(new EmployeeInfo("H. Chandler", "Sales Assistant", "San Francisco"));
        expectedSelectedEmployee.add(new EmployeeInfo("M. House", "Integration Specialist", "Sidney"));
        expectedSelectedEmployee.add(new EmployeeInfo("M. Silva", "Marketing Designer", "London"));
        expectedSelectedEmployee.add(new EmployeeInfo("S. Burks", "Developer", "London"));
        Assertions.assertEquals(expectedSelectedEmployee, selectedEmployees);

        Object fdsf= new Object();



    }
}

