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

import java.util.List;

public class LoginTest extends BaseTestFinalTask {
    @Tag("LoginTest")
    @TmsLink("AP-2")
    @Description("Verify ability to login in the existing account")
    @Test
    public void loginInExistingAccount() {
        String email = EmailAndPasswordGenerator.generateEmailAddress();
        String password = EmailAndPasswordGenerator.generatePassword();
        MyAccountPage myAccountPage = mainPageFinalTask
                .clickSignIn()
                .createAnAccount(email)
                .fillAccountFieldsAndClickRegister("src/main/resources/account.csv", password);
        myAccountPage = mainPageFinalTask
                .logout()
                .clickSignIn()
                .signIn(email, password);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", currentUrl);
        String accountEmail = myAccountPage
                .clickMyPersonalInformationButton()
                .getEmail();
        Assert.assertEquals(email, accountEmail);
    }

    @Tag("LoginTest")
    @TmsLink("AP-2")
    @Description("Verify personal information in the existing account")
    @Test
    public void verifyPersonalInformationOfExistingAccount() {
        String email = EmailAndPasswordGenerator.generateEmailAddress();
        String password = EmailAndPasswordGenerator.generatePassword();
        String path = "src/main/resources/account.csv";
        MyAccountPage myAccountPage = mainPageFinalTask
                .clickSignIn()
                .createAnAccount(email)
                .fillAccountFieldsAndClickRegister(path, password);
        MyPersonalInformationPage myPersonalInformationPage = mainPageFinalTask
                .logout()
                .clickSignIn()
                .signIn(email, password)
                .clickMyPersonalInformationButton();
        List<String> inputData = CSVReader.CSVReader(path);
        Assertions.assertAll(
                () -> Assert.assertEquals(inputData.get(0), myPersonalInformationPage.getSocialTitle()),
                () -> Assert.assertEquals(inputData.get(1), myPersonalInformationPage.getFirstName()),
                () -> Assert.assertEquals(inputData.get(2), myPersonalInformationPage.getLastName()),
                () -> Assert.assertEquals(inputData.get(3), myPersonalInformationPage.getDayOfBirth()),
                () -> Assert.assertEquals(inputData.get(4), myPersonalInformationPage.getMonthOfBirth()),
                () -> Assert.assertEquals(inputData.get(5), myPersonalInformationPage.getYearOfBirth()),
                () -> Assert.assertEquals(inputData.get(6), myPersonalInformationPage.getStatusOfNewsLetterCheckbox()),
                () -> Assert.assertEquals(inputData.get(7), myPersonalInformationPage.getStatusOfSubscriptionCheckbox()),
                () -> Assert.assertEquals(email, myPersonalInformationPage.getEmail())
        );
    }

    @Tag("LoginTest")
    @TmsLink("AP-2")
    @Description("Verify impossible to login with incorrect password")
    @Test
    public void impossibleToLoginWithInvalidPassword() {
        SignInPage signInPage = mainPageFinalTask.clickSignIn();
        signInPage.signIn(Constants.EMAIL, "1");
        String errorMessage = signInPage.getErrorMessage();
        Assert.assertEquals("Invalid password.", errorMessage);
    }

}
