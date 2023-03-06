package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.magento.ShoppingCartPage;
import steps.MagentoUser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {
@Steps(shared = true)
private MagentoUser magentoUser;
private ShoppingCartPage shoppingCartPage;

    @Given("user opens Shopping Cart")
    public void openShoppingCart() {
        shoppingCartPage.getOpenShoppingCartLink().waitUntilClickable().click();
    }

    @When("user adds all displayed items in Shopping Cart")
    public void userAddsAllDisplayedItemsInShoppingCart() {
        magentoUser.addToCart();
    }

    @Then("items are successfully added")
    public void itemsAreSuccessfullyAdded() {
        assertTrue(shoppingCartPage.getMessageSuccess().isVisible());
    }

    @And("sum of all items price equals Total price")
    public void sumOfAllItemsPriceEqualsTotalPrice() {
        assertTrue(magentoUser.checkPriceSumEqualsTotalPrice());
    }

    @When("user deletes {int} item from shopping cart")
    public void userDeletesItemFromShoppingCart(int itemNumber) {
    }

    @Then("the number of items is decreased by {int} item")
    public void theNumberOfItemsIsDecreasedByItem(int itemNumber) {
    }
}
