package org.issoft.automation.page.FinalTask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyPersonalInformationPage {
    private WebDriver driver;
    private By mrRadioButton = By.xpath("//input[@id='id_gender1']");
    private By mrsRadioButton = By.xpath("//input[@id='id_gender2']");
    private By firstNameField = By.xpath("//input[@id='firstname']");
    private By lastNameField = By.xpath("//input[@id='lastname']");
    private By emailFiled = By.xpath("//input[@id='email']");
    private By dayOfBirth = By.xpath("//select[@id='days']");
    private By monthOfBirth = By.xpath("//select[@id='months']");
    private By yearOfBirth = By.xpath("//select[@id='years']");
    private By newsletterCheckbox = By.xpath("//input[@id='newsletter']");
    private By subscriptionCheckbox = By.xpath("//input[@id='optin']");

    public MyPersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSocialTitle() {
        if (driver.findElement(mrRadioButton).isSelected()) {
            return "Mr.";
        }
        if (driver.findElement(mrsRadioButton).isSelected())
            return "Mrs.";
        else return "";
    }

    public String getFirstName() {
        return driver.findElement(firstNameField).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameField).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(emailFiled).getAttribute("value");
    }

    public String getDayOfBirth() {
        Select select = new Select(driver.findElement(dayOfBirth));
        return select.getFirstSelectedOption().getText().trim();
    }

    public String getMonthOfBirth() {
        Select select = new Select(driver.findElement(monthOfBirth));
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public String getYearOfBirth() {
        Select select = new Select(driver.findElement(yearOfBirth));
        return select.getFirstSelectedOption().getText().trim();
    }

    public String getStatusOfNewsLetterCheckbox() {
        if (driver.findElement(newsletterCheckbox).isSelected()) {
            return "Yes";
        } else return "No";
    }

    public String getStatusOfSubscriptionCheckbox() {
        if (driver.findElement(subscriptionCheckbox).isSelected()) {
            return "Yes";
        } else return "No";
    }
}
