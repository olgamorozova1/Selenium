package org.issoft.automation.page.task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;

    public void selectQuantityOfRowsInTable(WebDriver driver) {
        By showEntriesDropdown = By.xpath("//select[@name='example_length']");
        Select numberOfRowsDropdown = new Select(driver.findElement(showEntriesDropdown));
        numberOfRowsDropdown.selectByValue("10");
    }

    public List<WebElement> getRows(WebDriver driver) {
        List<WebElement> allInfo = driver.findElements(By.xpath(".//tbody//tr"));
        return allInfo;
    }

    public List<EmployeeAllInfo> getEmployeeInfoOfWebElements(WebDriver driver, List<WebElement> allInfo) {
        List<EmployeeAllInfo> employeeAllInfo = new ArrayList<>();
        for (int i = 1; i <= allInfo.size(); i++) {
            String name = driver.findElement(By.xpath("//tr[" + i + "]/td[1]")).getText();
            String position = driver.findElement(By.xpath("//tr[" + i + "]/td[2]")).getText();
            String office = driver.findElement(By.xpath("//tr[" + i + "]/td[3]")).getText();
            int age = Integer.parseInt(driver.findElement(By.xpath("//tr[" + i + "]/td[4]")).getText());
            String startDate = driver.findElement(By.xpath("//tr[" + i + "]/td[5]")).getText();
            String salaryString = driver.findElement(By.xpath("//tr[" + i + "]/td[6]")).getText();
            salaryString = salaryString.substring(1, salaryString.length() - 2).replaceAll(",", "");
            int salary = Integer.parseInt(salaryString);
            employeeAllInfo.add(new EmployeeAllInfo(name, position, office, age, startDate, salary));
        }
        return employeeAllInfo;
    }

    public List<EmployeeSelectedInfo> selectEmployeeByAgeAndSalary(WebDriver driver, List<EmployeeAllInfo> employeeAllInfo) {
        List<EmployeeSelectedInfo> selectedEmployees = new ArrayList<>();
        for (EmployeeAllInfo employee : employeeAllInfo) {
            if (employee.getAge() > 30 && employee.getSalary() < 200000) {
                selectedEmployees.add(new EmployeeSelectedInfo(employee.getName(), employee.getPosition(), employee.getOffice()));
            }
        }
        return selectedEmployees;
    }

    public List<EmployeeAllInfo> getInfoFromAllPages(WebDriver driver) {
        TablePage tablePage = new TablePage();
        List<EmployeeAllInfo> allInfoAboutEmployee = new ArrayList<>();
        while (true) {
            List<WebElement> rows = tablePage.getRows(driver);
            List<EmployeeAllInfo> employeeInfoFromOnePage = tablePage.getEmployeeInfoOfWebElements(driver, rows);
            allInfoAboutEmployee.addAll(employeeInfoFromOnePage);
            //I have to find Next button in each iteration to avoid StaleReferenceException
            if ((!driver.findElement(By.id("example_next")).getAttribute("class").contains("disabled"))) {
                driver.findElement(By.id("example_next")).click();
            } else break;
        }
        return allInfoAboutEmployee;
    }

}
