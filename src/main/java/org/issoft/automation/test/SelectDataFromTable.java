package org.issoft.automation.test;

import org.issoft.automation.page.task9.EmployeeAllInfo;
import org.issoft.automation.page.task9.EmployeeSelectedInfo;
import org.issoft.automation.page.task9.TablePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectDataFromTable {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void selectDataFromTable() {
        TablePage tablePage = new TablePage();
        tablePage.selectQuantityOfRowsInTable(driver);
        List<WebElement> listOfWebElementsOfTable = tablePage.getAllDataFromTable(driver);
        List<EmployeeAllInfo> allInfoAboutEmployee = tablePage.getEmployeeInfoOfWebElements(driver, listOfWebElementsOfTable);
        List<EmployeeSelectedInfo> selectedEmployees = tablePage.selectEmployeeByAgeAndSalary(driver, allInfoAboutEmployee);
        System.out.println(selectedEmployees);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}

