package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.magento.BasePage;
import pages.magento.StorePage;
import steps.MagentoUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.settings.MagentoSettings.waitForPageLoaded;

public class WishlistSteps {


    private BasePage basePage;
    @Steps(shared = true)
    private MagentoUser magentoUser;

    private StorePage storePage;

    public int itemNumberBefore;
    public int itemNumberAfter;

    @Given("user removes existing price filter")
    public void removePriceFilter() {
        itemNumberBefore = Integer.parseInt(storePage.getItemsNumber().getText());
        magentoUser.removePriceFilter();
    }

    @Then("the item number increases")
    public void theItemNumberIncreases() {
        waitForPageLoaded();
        itemNumberAfter = Integer.parseInt(storePage.getItemsNumber().getText());
        assertTrue(itemNumberAfter > itemNumberBefore);
    }

    @When("user adds {int} first item in WishList")
    public void userAddsFirstItemInWishList(int itemsNumber) {
        List<WebElementFacade> itemsList = storePage.getItemsList();
        for (WebElementFacade item:itemsList) {
            while (!(itemsNumber == 0)){
                Actions action = new Actions(basePage.getDriver());
                action.moveToElement(item.findElement(By.xpath("//a[@data-action='add-to-wishlist']"))).perform();
                action.click();
//                item.findElement(By.xpath("//a[@data-action='add-to-wishlist']")).click();
                itemsNumber--;
            }

        }

    }

    @Then("items are added successfully")
    public void itemsAreAddedSuccessfully() {
        System.out.println("Check wishlist");
    }

    @And("the {int} items added are displayed in User Profile")
    public void theItemsAddedAreDisplayedInUserProfile(int itemsNumber) {

    }
}
