package steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Actions;
import pages.magento.*;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static utils.settings.MagentoSettings.*;

public class MagentoUser extends BasePage {

    private BasePage basePage;
    private LoginPage loginPage;
    private CreateAccountPage createAccountPage;
    private ProfilePage accountPage;
    private StorePage storePage;

    @Step("#actor logs in with dynamic email")
    public void loginWithDynamicEmail() throws IOException {
        dynamicEmail = readStrFromFile();
        loginPage.getLoginEmailInput().sendKeys(dynamicEmail);
        loginPage.getLoginPswInput().sendKeys(testPassword);
        loginPage.getLoginButton().click();
    }

    @Step("#actor logs in with simple email")
    public void loginWithSimpleEmail() {
        waitForPageLoaded();
        basePage.getSignInLink().waitUntilClickable().click();
        loginPage.getLoginEmailInput().sendKeys(simpleEmail);
        loginPage.getLoginPswInput().sendKeys(testPassword);
        loginPage.getLoginButton().click();

        if (loginPage.getPageMessages().containsText("Please wait and try again later.")) {
            loginPage.getLoginPswInput().sendKeys(testPassword);
            loginPage.getLoginButton().click();
        }
    }

    @Step("#actor fills registration form")
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

    @Step("#actor logs out")
    public void logout() {
        accountPage.getMenuToggle().click();
        accountPage.getLogoutButton().waitUntilClickable().click();
    }

    @Step("#actor check page filters")
    public void checkPageFilters(List<List<String>> dataTable) {
        List<String> pageFilters = dataTable.get(0);
        basePage.setImplicitTimeout(30, ChronoUnit.SECONDS);
        Actions action = new Actions(getDriver());
        action.moveToElement(storePage.getLevel1MenuDropdown(pageFilters.get(0))).perform();
        action.moveToElement(storePage.getLevel2MenuDropdown(pageFilters.get(1))).perform();
        action.moveToElement(storePage.getLevel3MenuDropdown(pageFilters.get(2))).perform();
        storePage.getLevel3MenuDropdown(pageFilters.get(2)).waitUntilClickable().click();
        basePage.resetImplicitTimeout();
    }

    @Step("#actor selects color")
    public void selectColor(String colorName) {
        waitForPageLoaded();
        basePage.setImplicitTimeout(30, ChronoUnit.SECONDS);
        storePage.getColorFilterButton().click();
        storePage.getColorChoiceButton(colorName).click();
        basePage.resetImplicitTimeout();
    }
    @Step("#actor selects first price Range")
    public void selectFirstPriceRange() {
        setImplicitTimeout(30, ChronoUnit.SECONDS);
        storePage.getPriceFilterButton().waitUntilClickable().click();
        storePage.getFirstPriceRange().click();
        resetImplicitTimeout();
    }

    @Step("#actor selects price Range")
    public void selectPriceRange(String priceRange) {
        setImplicitTimeout(30, ChronoUnit.SECONDS);
        storePage.getPriceFilterButton().waitUntilClickable().click();
        storePage.getFixedPriceRange(priceRange);
        resetImplicitTimeout();
    }

    @Step("#actor removes price filter")
    public void removePriceFilter() {

    }
    @Step("#actor sorts filters based on option")
    public void sortFilters(String option) {
        storePage.getSorterSelectButton().waitUntilClickable().click();
        storePage.getSorterOption(option).waitUntilClickable().click();
    }
}
