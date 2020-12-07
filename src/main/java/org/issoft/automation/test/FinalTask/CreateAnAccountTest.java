package org.issoft.automation.test.FinalTask;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.issoft.automation.page.FinalTask.Constants.Constants;
import org.issoft.automation.page.FinalTask.Pages.MyAccountPage;
import org.issoft.automation.page.FinalTask.Pages.MyPersonalInformationPage;
import org.issoft.automation.page.FinalTask.Pages.SignInPage;
import org.issoft.automation.page.FinalTask.Utils.CSVReader;
import org.issoft.automation.page.FinalTask.Utils.EmailAndPasswordGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

public class CreateAnAccountTest extends BaseTestFinalTask {
    @Tag("CreateAnAccount")
    @TmsLink("AP-1")
    @Description("Verify the ability to create an account")
    @Test
    public void createAnAccountWithValidData() {
        MyAccountPage myAccountPage = mainPageFinalTask
                .clickSignIn()
                .createAnAccount(EmailAndPasswordGenerator.generateEmailAddress())
                .fillAccountFieldsAndClickRegister("src/main/resources/account.csv", EmailAndPasswordGenerator.generatePassword());
        String currentUrl = driver.getCurrentUrl();
        String welcomeMessage = myAccountPage.getWelcomeMessage();
        Assertions.assertAll(
                () -> Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", currentUrl),
                () -> Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", welcomeMessage)
        );
    }

    @Tag("CreateAnAccount")
    @TmsLink("AP-1")
    @Description("Verify personal information in the new account")
    @Test
    public void verifyPersonalInformationOfNewAccount() {
        String email = EmailAndPasswordGenerator.generateEmailAddress();
        String path = "src/main/resources/account.csv";
        MyPersonalInformationPage myPersonalInformationPage = mainPageFinalTask
                .clickSignIn()
                .createAnAccount(email)
                .fillAccountFieldsAndClickRegister(path, EmailAndPasswordGenerator.generatePassword())
                .clickMyPersonalInformationButton();
        List<String> inputData = CSVReader.CSVReader(path);
        String socialTitle = myPersonalInformationPage.getSocialTitle();
        String firstName = myPersonalInformationPage.getFirstName();
        String lastName = myPersonalInformationPage.getLastName();
        String dayOfBirth = myPersonalInformationPage.getDayOfBirth();
        String monthOfBirth = myPersonalInformationPage.getMonthOfBirth();
        String yearOfBirth = myPersonalInformationPage.getYearOfBirth();
        String newsLetterCheckbox = myPersonalInformationPage.getStatusOfNewsLetterCheckbox();
        String subscriptionCheckbox = myPersonalInformationPage.getStatusOfSubscriptionCheckbox();
        String accountEmail = myPersonalInformationPage.getEmail();
        Assertions.assertAll(
                () -> Assert.assertEquals(inputData.get(0), socialTitle),
                () -> Assert.assertEquals(inputData.get(1), firstName),
                () -> Assert.assertEquals(inputData.get(2), lastName),
                () -> Assert.assertEquals(inputData.get(3), dayOfBirth),
                () -> Assert.assertEquals(inputData.get(4), monthOfBirth),
                () -> Assert.assertEquals(inputData.get(5), yearOfBirth),
                () -> Assert.assertEquals(inputData.get(6), newsLetterCheckbox),
                () -> Assert.assertEquals(inputData.get(7), subscriptionCheckbox),
                () -> Assert.assertEquals(email, accountEmail)
        );
    }

    @Tag("CreateAnAccount")
    @TmsLink("AP-1")
    @Description("Verify account could not be created with invalid email")
    @ParameterizedTest
    @CsvFileSource(resources = "/invalidEmails.csv")
    public void createAnAccountWithInvalidEmail(String email) {
        SignInPage signInPage = mainPageFinalTask.clickSignIn();
        signInPage.createAnAccount(email);
        String errorMessage = signInPage.getErrorMessage();
        Assert.assertEquals("Invalid email address.", errorMessage);
    }

    @Tag("CreateAnAccount")
    @TmsLink("AP-1")
    @Description("Verify account could not be created with empty email")
    @Test
    public void createAnAccountWithEmptyEmail() {
        SignInPage signInPage = mainPageFinalTask.clickSignIn();
        signInPage.createAnAccount("");
        String errorMessage = signInPage.getErrorMessage();
        Assert.assertEquals("Invalid email address.", errorMessage);
    }

    @Tag("CreateAnAccount")
    @TmsLink("AP-1")
    @Description("Verify account could not be created with email which is already in use")
    @Test
    public void createAnAccountWithEmailWhichIsAlreadyInUse() {
        SignInPage signInPage = mainPageFinalTask.clickSignIn();
        signInPage.createAnAccount(Constants.EMAIL);
        String errorMessage = signInPage.getErrorMessage();
        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", errorMessage);
    }
}
