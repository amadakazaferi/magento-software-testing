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
import steps.MagentoUser;
import utils.settings.MagentoSettings;

import java.io.IOException;
import java.nio.file.Path;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.settings.MagentoSettings.*;

public class LoginAndRegistrationSteps {

    private BasePage basePage;
    private CreateAccountPage createAccountPage;
    private AccountPage accountPage;
    private LoginPage loginPage;
    private MagentoUser magentoUser;


    @Given("a user is navigating the Magento app")
    public void aUserIsNavigatingTheApp() {
        basePage.navigateTo(magentoBaseUrl);
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
        magentoUser.loginWithDynamicEmail();
    }

    @Then("the username is displayed right")
    public void checkUsername() {
        basePage.setImplicitTimeout(30, ChronoUnit.SECONDS);
        basePage.getUsernameLink().waitUntilVisible();
        assertTrue(basePage.getUsernameLink().getText().contains(testUsername), "Username is correct.");
        basePage.resetImplicitTimeout();
    }

    @And("user sign out")
    public void logout() {
      magentoUser.logout();
    }

    @When("user fills the form and creates the account")
    public void fillRegistrationForm() throws IOException {
        magentoUser.fillRegistrationForm();

    }

    @Then("the account is successfully  created")
    public void theAccountIsSuccessfullyCreated() {
        basePage.setImplicitTimeout(30, ChronoUnit.SECONDS);
        System.out.println("Check account");
        createAccountPage.getAccountCreatedAlert().waitUntilVisible();
        assertTrue(createAccountPage.getAccountCreatedAlert().containsText("Thank you for registering"));
        basePage.resetImplicitTimeout();
    }
}
