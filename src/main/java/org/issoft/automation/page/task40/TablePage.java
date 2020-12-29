package org.issoft.automation.page.task40;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectQuantityOfRowsInTable() {
        By showEntriesDropdown = By.xpath("//select[@name='example_length']");
        Select numberOfRowsDropdown = new Select(driver.findElement(showEntriesDropdown));
        numberOfRowsDropdown.selectByValue("10");
    }

    public List<WebElement> getRows() {
        List<WebElement> allInfo = driver.findElements(By.xpath(".//tbody//tr"));
        return allInfo;
    }

    public List<EmployeeAllInfo> getEmployeeInfoOfWebElements(List<WebElement> allInfo) {
        //$120,324 Yz 120324
        List<EmployeeAllInfo> employeeAllInfo = new ArrayList<>();
        for (WebElement employeeInfo : allInfo) {
            String name = employeeInfo.findElement(By.xpath("./td[1]")).getText();
            String position = employeeInfo.findElement(By.xpath("./td[2]")).getText();
            String office = employeeInfo.findElement(By.xpath("./td[3]")).getText();
            int age = Integer.parseInt(employeeInfo.findElement(By.xpath("./td[4]")).getText());
            String startDate = employeeInfo.findElement(By.xpath("./td[5]")).getText();
            String salaryString = employeeInfo.findElement(By.xpath("./td[6]")).getText();
            salaryString = salaryString.substring(1, salaryString.length() - 2).replaceAll(",", "");
            int salary = Integer.parseInt(salaryString);
            employeeAllInfo.add(new EmployeeAllInfo(name, position, office, age, startDate, salary));

        }

        return employeeAllInfo;


    }


    public List<EmployeeInfo> selectEmployeeByAgeAndSalary(List<EmployeeAllInfo> employeeAllInfo) {
        List<EmployeeInfo> selectedEmployees = new ArrayList<>();
        for (EmployeeAllInfo employee : employeeAllInfo) {
            if (employee.getAge() > 30 && employee.getSalary() < 200000) {
                selectedEmployees.add(new EmployeeInfo(employee.getName(), employee.getPosition(), employee.getOffice()));
            }
        }
        return selectedEmployees;
    }

    public List<EmployeeAllInfo> getInfoFromAllPages() {
        TablePage tablePage = new TablePage(driver);
        List<EmployeeAllInfo> allInfoAboutEmployee = new ArrayList<>();
        while (true) {
            List<WebElement> rows = tablePage.getRows();
            List<EmployeeAllInfo> employeeInfoFromOnePage = tablePage.getEmployeeInfoOfWebElements(rows);
            allInfoAboutEmployee.addAll(employeeInfoFromOnePage);
            //I have to find Next button in each iteration to avoid StaleReferenceException
            if ((!driver.findElement(By.id("example_next")).getAttribute("class").contains("disabled"))) {
                driver.findElement(By.id("example_next")).click();
            } else break;
        }
        return allInfoAboutEmployee;
    }

}
