package org.issoft.automation.page.FinalTask.Pages;

import org.issoft.automation.page.FinalTask.Utils.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateAnAccountPage {
    private WebDriver driver;
    private By MrRadioButton = By.xpath("//input[@id='id_gender1']");
    private By MrsRadioButton = By.xpath("//input[@id='id_gender2']");
    private By firstNameField = By.xpath("//input[@id='customer_firstname']");
    private By lastNameField = By.xpath("//input[@id='customer_lastname']");
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@name='passwd']");
    private By dateOfBirthDay = By.xpath("//select[@id='days']");
    private By dateOfBirthMonth = By.xpath("//select[@id='months']");
    private By dateOfBirthYears = By.xpath("//select[@id='years']");
    private By checkBoxSignUpForNewLetters = By.xpath("//input[@name='newsletter']");
    private By checkBoxSpecialOffers = By.xpath("//input[@name='optin']");
    private By company = By.xpath("//input[@id='company']");
    private By firstNameAddressField = By.xpath("//input[@id='firstname']");
    private By lastNameAddressField = By.xpath("//input[@id='lastname']");
    private By address1lineField = By.xpath("//input[@id='address1']");
    private By address2lineField = By.xpath("//input[@id='address2']");
    private By cityField = By.xpath("//input[@id='city']");
    private By stateField = By.xpath("//select[@id='id_state']");
    private By zipCodeField = By.xpath("//input[@id='postcode']");
    private By countryField = By.xpath("//select[@id='id_country']");
    private By additionalInformation = By.xpath("//textarea[@id='other']");
    private By homePhone = By.xpath("//input[@id='phone']");
    private By mobilePhone = By.xpath("//input[@id='phone_mobile']");
    private By addressAliasField = By.xpath("//input[@id='alias']");
    private By registerButton = By.xpath("//button[@id='submitAccount']");
    private By errorMessage = By.xpath("//div[@class='alert alert-danger']");

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage fillAccountFieldsAndClickRegister(String path, String password) {
        List<String> inputData = CSVReader.CSVReader(path);
        switch (inputData.get(0)) {
            case ("Mr."):
                driver.findElement(MrRadioButton).click();
                break;
            case ("Mrs."):
                driver.findElement(MrsRadioButton).click();
                break;
        }
        driver.findElement(firstNameField).sendKeys(inputData.get(1));
        driver.findElement(lastNameField).sendKeys(inputData.get(2));
        driver.findElement(passwordField).sendKeys(password);
        Select DOBDay = new Select(driver.findElement(dateOfBirthDay));
        DOBDay.selectByValue(inputData.get(3));
        Select DOBMonth = new Select(driver.findElement(dateOfBirthMonth));
        DOBMonth.selectByValue(inputData.get(4));
        Select DOBYear = new Select(driver.findElement(dateOfBirthYears));
        DOBYear.selectByValue(inputData.get(5));
        if (inputData.get(6).equalsIgnoreCase("Yes")) {
            driver.findElement(checkBoxSignUpForNewLetters).click();
        }
        if (inputData.get(7).equalsIgnoreCase("Yes")) {
            driver.findElement(checkBoxSpecialOffers).click();
        }
        driver.findElement(company).sendKeys(inputData.get(8));
        driver.findElement(address1lineField).sendKeys(inputData.get(9));
        driver.findElement(address2lineField).sendKeys(inputData.get(10));
        driver.findElement(cityField).sendKeys(inputData.get(11));
        Select state = new Select(driver.findElement(stateField));
        state.selectByVisibleText(inputData.get(12));
        driver.findElement(zipCodeField).sendKeys(inputData.get(13));
        Select country = new Select(driver.findElement(countryField));
        country.selectByVisibleText(inputData.get(14));
        driver.findElement(additionalInformation).sendKeys(inputData.get(15));
        driver.findElement(homePhone).sendKeys(inputData.get(16));
        driver.findElement(mobilePhone).sendKeys(inputData.get(17));
        driver.findElement(addressAliasField).clear();
        driver.findElement(addressAliasField).sendKeys(inputData.get(18));
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }
}














