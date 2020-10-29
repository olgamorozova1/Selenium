package org.issoft.automation.page.task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;
//Could not get rid of Webdriver driver as method parameter - without it nothing is work. Why?)
    public void selectQuantityOfRowsInTable(WebDriver driver) {
        By showEntriesDropdown = By.xpath("//select[@name='example_length']");
        Select numberOfRowsDropdown = new Select(driver.findElement(showEntriesDropdown));
        numberOfRowsDropdown.selectByValue("50");
    }

    public List<WebElement> getAllDataFromTable(WebDriver driver) {
        List<WebElement> allInfo = new ArrayList<>();
        List<WebElement> table = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement cells : table) {
            allInfo = cells.findElements(By.xpath("./*"));
        }
        return allInfo;
    }
//I know that there should be foreach which goes through all web elements of allInfo list but
// I could not find appropriate xpath or other locator for td tag - so I will continue investigate this
    public List<EmployeeAllInfo> getEmployeeInfoOfWebElements(WebDriver driver, List<WebElement> allInfo) {
        List<EmployeeAllInfo> employeeAllInfo = new ArrayList<>();
//this value was set as maximum number of rows when we select 50 entries in the dropdown -
// if we would use foreach we can avoid using this variable
        int numberOfRows = 32;
        for (int i = 1; i <= numberOfRows; i++) {
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
}
