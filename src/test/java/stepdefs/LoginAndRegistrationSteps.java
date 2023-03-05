package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import pages.magento.AccountPage;
import pages.magento.BasePage;
import pages.magento.CreateAccountPage;
import pages.magento.LoginPage;
import utils.settings.MagentoSettings;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.settings.MagentoSettings.*;

public class LoginAndRegistrationSteps {

private BasePage basePage;
private CreateAccountPage createAccountPage;
private AccountPage accountPage;
private LoginPage loginPage;



    @Given("a user is navigating the Magento app")
    public void aUserIsNavigatingTheApp() {
        basePage.navigateToHome();
    }

    @When("user clicks on link to {string}")
    public void userClicksOnLink(String linkName) {
        switch (linkName) {
            case "Create Account" -> basePage.getCreateAccountLink().waitUntilClickable().click();
            case "Sign In" -> basePage.getSignInLink().waitUntilClickable().click();
            default -> System.out.println("There was no link name passed");
        }
    }

    @Then("the page {string} is opened")
    public void thePageIsOpened(String expectedPageTitle) {
        assertEquals(expectedPageTitle, createAccountPage.getCreateAccountPageTitle().getText());
    }

    @And("user sign in with credentials")
    public void login() throws IOException {
       dynamicEmail = readStrFromFile();
        loginPage.getLoginEmailInput().sendKeys(dynamicEmail);
        loginPage.getLoginPswInput().sendKeys(testPassword);
        loginPage.getLoginButton().click();
    }

    @Then("the username is displayed right")
    public void checkUsername() {

    }

    @And("user sign out")
    public void logout() {
        accountPage.getMenuToggle().click();
        accountPage.getLogoutButton().waitUntilClickable().click();
    }

    @When("user fills the form and creates the account")
    public void fillRegistrationForm() throws IOException {
        dynamicEmail = basePage.generateRandomEmailAddress();
        writeStrToFile(dynamicEmail);
        createAccountPage.getFirstNameinput().sendKeys(testFirstName);
        createAccountPage.getLastNameinput().sendKeys(testLastName);
        createAccountPage.getEmailAddressInput().sendKeys(dynamicEmail);
        createAccountPage.getPasswordInput().sendKeys(testPassword);
        createAccountPage.getConfirmPasswordInput().sendKeys(testPassword);
        createAccountPage.getCreateAccountButton().click();

    }

    @Then("the account is successfully  created")
    public void theAccountIsSuccessfullyCreated() {
        System.out.println("Check account");
       assertTrue(createAccountPage.getAccountCreatedAlert().containsText("Thank you for registering"));
    }
}
